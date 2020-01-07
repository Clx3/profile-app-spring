package fi.tuni.teemu.profileapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import fi.tuni.teemu.profileapp.service.ProfileImageService;

@RestController
public class ProfileImageController {
	
	@Autowired
	private ProfileImageService profileImageService;
	
	@PostMapping(value = "image/")
	public void postProfileImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		try {
			profileImageService.storeFile(file, request);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error while uploading image.");
		}
	}

}
