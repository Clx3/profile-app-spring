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
	
	public List<Profile> findAllByIds(List<Long> idList) {
		return profileRepository.findByIdIn(idList);
	}
	
	public Profile findByUsername(String username) {
		return profileRepository.findByUsername(username);
	}
	
	public List<Profile> findAllBySearchText(String searchText) {
		Profile userProfile = findMe();
		
		return profileRepository.findByUsernameContainingAndIdNot(searchText, userProfile.getId());
	}
	
	public Profile findMe() {
		return profileRepository.findByEmail(authService.getCurrentAuthEmail());
	}
	
	public Profile save(Profile profile) {
		profile.setEmail(authService.getCurrentAuthEmail());
		
		return profileRepository.save(profile);
	}
	
	public Profile edit(Profile profile) {
		Profile userProfile = findMe();
		
		profile.setId(userProfile.getId());
		profile.setEmail(authService.getCurrentAuthEmail());
		
		return profileRepository.save(profile);
	}

}
