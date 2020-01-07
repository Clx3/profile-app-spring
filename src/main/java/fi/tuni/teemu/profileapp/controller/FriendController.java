package fi.tuni.teemu.profileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.tuni.teemu.profileapp.entity.Friend;
import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping(value = "friend/")
	public List<Profile> getAll() {
		return friendService.findAll();
	}
	
	@PostMapping(value = "friend/add/{friendId}")
	public Friend addFriend(@PathVariable("friendId") Long friendId) {
		Friend currentFriend = friendService.findByFriendId(friendId);
		
		if(currentFriend != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "This friend entity already exists!");
		} else {
			return friendService.saveByFriendId(friendId);
		}
	}
	
	@DeleteMapping(value = "friend/delete/{friendId}")
	public void deleteFriend(@PathVariable("friendId") Long friendId) {
		if(friendService.deleteFriendByFriendId(friendId) == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This profile is not a friend with the given id!");
		}
	}

}
