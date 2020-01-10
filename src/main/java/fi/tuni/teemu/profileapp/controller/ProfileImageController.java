package fi.tuni.teemu.profileapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "profile/image/me/", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getUserProfilePicture() {
		Resource resource = profileImageService.getUserProfilePictureResource();
		
		if(resource.exists()) {
			try {
				return IOUtils.toByteArray(resource.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error while serving image");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No profile picture found for user.");
		}
	}
	
	@GetMapping(value = "profile/image/{profileId}/")
	public byte[] getProfilePictureByProfileId(@PathVariable("profileId") Long profileId) {
		Resource resource = profileImageService.getProfilePictureResourceByProfileId(profileId);
		
		if(resource.exists()) {
			try {
				return IOUtils.toByteArray(resource.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error while serving image");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No profile picture found for the given profile id");
		}
	}
	
	@PostMapping(value = "profile/image/")
	public void postProfileImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		try {
			profileImageService.storeFile(file, request);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error while uploading image");
		}
	}

}
