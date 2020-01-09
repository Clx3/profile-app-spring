package fi.tuni.teemu.profileapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fi.tuni.teemu.profileapp.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService service;

}
