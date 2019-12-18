package fi.tuni.teemu.profileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "profile/")
	public List<Profile> getAll() {
		return profileService.findAll();
	}

}
