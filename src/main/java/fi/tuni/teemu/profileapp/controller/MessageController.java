package fi.tuni.teemu.profileapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.tuni.teemu.profileapp.entity.Message;
import fi.tuni.teemu.profileapp.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PutMapping(value = "message/")
	public Message putMessage(@RequestBody Message message) {
		return messageService.save(message);
	}

}
