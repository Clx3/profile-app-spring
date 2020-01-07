package fi.tuni.teemu.profileapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.tuni.teemu.profileapp.entity.Friend;
import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.repository.FriendRepository;

@Service
public class FriendService {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private FriendRepository friendRepository;
	
	public List<Profile> findAll() {
		Profile userProfile = profileService.findMe();
		
		List<Friend> friends = friendRepository.findAllByProfileId(userProfile.getId());
		
		List<Long> friendIds = new ArrayList<>();
		for(Friend friend : friends) {
			friendIds.add(friend.getFriendId());
		}
		
		return profileService.findAllByIds(friendIds);
	}
	
	public Friend saveByFriendId(Long friendId) {
		Profile userProfile = profileService.findMe();
		
		Friend friend = new Friend();
		friend.setProfileId(userProfile.getId());
		friend.setFriendId(friendId);
		
		return friendRepository.save(friend);
	}
	
	public Friend findByFriendId(Long friendId) {
		Profile userProfile = profileService.findMe();
		
		return friendRepository.findByProfileIdAndFriendId(userProfile.getId(), friendId);
	}

}
