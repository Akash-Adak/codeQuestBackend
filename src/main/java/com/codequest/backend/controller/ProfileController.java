package com.codequest.backend.controller;

import com.codequest.backend.entity.Profile;
import com.codequest.backend.repository.ProfileRepository;
import com.codequest.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    // Get profile of authenticated user
    @GetMapping
    public ResponseEntity<?> getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String username = authentication.getName();
        Optional<Profile> profile = profileRepository.findByUsername(username);
        System.out.println(username);
        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile not found for user: " + username);
        }
    }



    // Update existing profile for authenticated user
    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody Profile updatedProfile) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String username = authentication.getName();
        Optional<Profile> existingProfileOpt = profileRepository.findByUsername(username);

        if (existingProfileOpt.isPresent()) {
            Profile existingProfile = existingProfileOpt.get();

            // Update only non-null fields (frontend can send partial updates)
            if (updatedProfile.getName() != null) {
                existingProfile.setName(updatedProfile.getName());
            }
            if (updatedProfile.getDob() != null) {
                existingProfile.setDob(updatedProfile.getDob());
            }
            if (updatedProfile.getCity() != null) {
                existingProfile.setCity(updatedProfile.getCity());
            }
            if (updatedProfile.getGender() != null) {
                existingProfile.setGender(updatedProfile.getGender());
            }
            // Add more fields as needed...

            Profile savedProfile = profileRepository.save(existingProfile);
            return ResponseEntity.ok(savedProfile);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile not found");
        }
    }

}