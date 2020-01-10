package fi.tuni.teemu.profileapp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

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
    
    public Resource getUserProfilePictureResource() {
    	Profile userProfile = profileService.findMe();
    	String fileName = String.format("Profile_%d.jpg", userProfile.getId());
    	
    	return new ClassPathResource("/images/" + fileName);
    }
    
    public Resource getProfilePictureResourceByProfileId(Long profileId) {
    	String fileName = String.format("Profile_%d.jpg", profileId);
    	
    	return new ClassPathResource("/images/" + fileName);
    }
	
	public void storeFile(MultipartFile file, HttpServletRequest request) throws IOException {
		Profile userProfile = profileService.findMe();
		String fileName = String.format("Profile_%d.jpg", userProfile.getId());

		String path = UPLOAD_DIR + fileName;
		
		System.out.println("HERE");
		
        try (Stream<Path> walk = Files.walk(Paths.get("./"))) {
            // We want to find only regular files
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		FileCopyUtils.copy(file.getBytes(), new File(path));
	}

}
