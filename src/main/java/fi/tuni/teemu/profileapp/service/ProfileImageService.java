package fi.tuni.teemu.profileapp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import fi.tuni.teemu.profileapp.entity.Profile;

@Service
public class ProfileImageService {
	
    public static final String UPLOAD_DIR = "src/main/resources/images/";
    
    @Autowired
    private ProfileService profileService;
	
	public void storeFile(MultipartFile file, HttpServletRequest request) throws IOException {
		Profile userProfile = profileService.findMe();
		String fileName = String.format("Profile_%d.png", userProfile.getId());
		System.out.println(Paths.get(UPLOAD_DIR).toAbsolutePath());

		String path = UPLOAD_DIR + fileName;
		FileCopyUtils.copy(file.getBytes(), new File(path));
		
	}

}
