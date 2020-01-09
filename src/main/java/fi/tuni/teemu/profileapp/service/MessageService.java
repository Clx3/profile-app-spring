package fi.tuni.teemu.profileapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.tuni.teemu.profileapp.entity.Message;
import fi.tuni.teemu.profileapp.entity.Profile;
import fi.tuni.teemu.profileapp.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ProfileService profileService;
	
	public Message save(Message message) {
		Profile userProfile = profileService.findMe();
		
		message.setSenderId(userProfile.getId());
		
		return messageRepository.save(message);
	}

}
