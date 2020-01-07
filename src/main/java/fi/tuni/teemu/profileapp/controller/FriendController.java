package fi.tuni.teemu.profileapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.tuni.teemu.profileapp.entity.Friend;
import fi.tuni.teemu.profileapp.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	private FriendService friendService;
	
	@PostMapping(value = "friend/add/{friendId}")
	public Friend addFriend(@PathVariable("friendId") Long friendId) {
		Friend currentFriend = friendService.findByFriendId(friendId);
		
		if(currentFriend != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "This friend entity already exists!");
		} else {
			return friendService.saveByFriendId(friendId);
		}
	}

}
