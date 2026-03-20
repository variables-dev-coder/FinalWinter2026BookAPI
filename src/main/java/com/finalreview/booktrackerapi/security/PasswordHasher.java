package com.finalreview.booktrackerapi.security;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHasher {


   public static String hashPassword(String password) {
       return BCrypt.hashpw(password, BCrypt.gensalt());
   }

    public static boolean verifyPassword(String plainText, String hashedPassword) {
        try {
            return BCrypt.checkpw(plainText, hashedPassword);
        } catch (IllegalArgumentException ex) {
            // Stored password is not a valid BCrypt hash.
            return false;
        }
    }
}
