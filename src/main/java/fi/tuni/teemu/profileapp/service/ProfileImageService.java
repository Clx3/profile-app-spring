package fi.tuni.teemu.profileapp.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import fi.tuni.teemu.profileapp.entity.Profile;

@Service
public class ProfileImageService {
	
	// Seems to be working on Heroku..
    public static final String UPLOAD_DIR = "src/main/resources/images/";
    
    @Autowired
    private ProfileService profileService;
	
	public void storeFile(MultipartFile file, HttpServletRequest request) throws IOException {
		Profile userProfile = profileService.findMe();
		String fileName = String.format("Profile_%d.png", userProfile.getId());

		String path = UPLOAD_DIR + fileName;
		FileCopyUtils.copy(file.getBytes(), new File(path));
		
	}

}
