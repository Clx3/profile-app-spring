package fi.tuni.teemu.profileapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> findAll() {
		return profileRepository.findAll();
	}
	
	public Profile findByUsername(String username) {
		return profileRepository.findByUsername(username);
	}
	
	public Profile findMe() {
		return profileRepository.findByEmail(authService.getCurrentAuthEmail());
	}
	
	public Profile save(Profile profile) {
		profile.setEmail(authService.getCurrentAuthEmail());
		
		return profileRepository.save(profile);
	}

}
