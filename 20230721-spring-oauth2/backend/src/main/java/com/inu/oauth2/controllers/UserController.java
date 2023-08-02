package com.inu.oauth2.controllers;

import com.inu.oauth2.applications.GetUserProfileService;
import com.inu.oauth2.dtos.UserProfileDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final GetUserProfileService getUserProfileService;

    public UserController(GetUserProfileService getUserProfileService) {
        this.getUserProfileService = getUserProfileService;
    }

    @GetMapping("me/profile")
    public UserProfileDto myProfile(
        @RequestAttribute("accessToken") String accessToken
    ) {
        return getUserProfileService.getUserProfile(accessToken);
    }
}
