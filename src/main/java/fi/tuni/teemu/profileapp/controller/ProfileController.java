package fi.tuni.teemu.profileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "profile/")
	public List<Profile> getAll(Authentication authentication) {
		return profileService.findAll();
	}
	
	@GetMapping(value = "profile/search/")
	public List<Profile> getAllByUsernameSearch(@RequestParam("searchText") String searchText) {
		return profileService.findAllBySearchText(searchText);
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
	
	@PostMapping(value = "profile/")
	public Profile createProfile(@RequestBody Profile profile) {
		return profileService.save(profile);
	}
	
	@PutMapping(value = "profile/me/")
	public Profile editProfile(@RequestBody Profile profile) {
		return profileService.edit(profile);
	}

}
