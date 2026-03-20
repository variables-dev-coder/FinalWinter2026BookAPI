package com.finalreview.follow;

import com.finalreview.booktrackerapi.dtos.FollowResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/followService")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/newFollow")
    public FollowResponseDTO newFollow(@RequestBody Follow follow) {
        return followService.newFollow(follow);
    }
    @PostMapping("/getAllFollowsForUser/{userName}")
    public Iterable<FollowResponseDTO> getAllFollowsForUser(@PathVariable String userName) {
        return followService.getAllFollowsForUser(userName);
    }
}
