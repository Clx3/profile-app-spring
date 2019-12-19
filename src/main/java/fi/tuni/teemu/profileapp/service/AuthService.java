package fi.tuni.teemu.profileapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
	
	public String getCurrentAuthEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null && authentication instanceof JwtAuthenticationToken) {
			JwtAuthenticationToken token = (JwtAuthenticationToken) authentication;
			
			if(token.getTokenAttributes().containsKey("email")) {
				return (String) token.getTokenAttributes().get("email");
			}
		}
		
		// This should not happen lol
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No email attribute in token");
	}

}
