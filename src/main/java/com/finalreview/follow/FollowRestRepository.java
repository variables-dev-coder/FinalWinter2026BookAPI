package com.finalreview.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRestRepository extends JpaRepository<Follow, Long> {
    Iterable<Follow> findFollowByFollowed_Username(String followedUsername);
}
