package sg.corporation.testSpringSecurity.rest;

import javax.annotation.security.RolesAllowed;
import javax.websocket.OnError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginCtrl {
//
//	@RolesAllowed("USER")
//	@GetMapping("/user")
//	public String getUser() {
//		return "Welcome User";
//	}
//	
//	@RolesAllowed("ADMIN")
//	@GetMapping("/admin")
//	public String getAdmin() {
//		return "Welcome Admin";
//	}
	
	@GetMapping("*/test")
	public String getTest() {
		return "test";
	}
	
	@OnError
	public String getError() {
		return "Oops il y a eu une erreur";
	}
}
