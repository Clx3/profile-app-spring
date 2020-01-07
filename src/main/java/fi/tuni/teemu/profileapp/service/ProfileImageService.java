package fi.tuni.teemu.profileapp.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    
    public byte[] getUserProfilePictureByteData() throws IOException {
    	String fileName = "Profile_1.png";
    	
    	Resource resource = new ClassPathResource("/images/" + fileName);
    	
    	return IOUtils.toByteArray(resource.getInputStream());
    }
	
	public void storeFile(MultipartFile file, HttpServletRequest request) throws IOException {
		Profile userProfile = profileService.findMe();
		String fileName = String.format("Profile_%d.png", userProfile.getId());

		String path = UPLOAD_DIR + fileName;
		FileCopyUtils.copy(file.getBytes(), new File(path));
	}

}
