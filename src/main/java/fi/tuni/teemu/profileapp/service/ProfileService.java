package fi.tuni.teemu.profileapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> findAll() {
		return profileRepository.findAll();
	}

}
