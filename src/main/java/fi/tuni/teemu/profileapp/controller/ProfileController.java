package fi.tuni.teemu.profileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.service.AuthService;
import fi.tuni.teemu.profileapp.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "profile/")
	public List<Profile> getAll(Authentication authentication) {

		System.out.println(authService.getCurrentAuthEmail());
		
		return profileService.findAll();
	}
	
	@GetMapping(value = "profile/me/")
	public Profile getMe() {
		Profile profile = profileService.findMe();
		
		if(profile != null) {
			return profile;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not registered");
		}

	}
	
	@GetMapping(value = "profile/isvalid/")
	public Boolean getIsUsernameValid(@RequestParam("username") String username) {
		Profile profile = profileService.findByUsername(username);
		
		if(profile != null) {
			return false;
		}
		
		return true;
	}

}
