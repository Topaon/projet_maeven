package sg.corporation.echo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.echo.service.ServiceEcho;

@RestController
@RequestMapping(value = "/echo", headers="Accept=application/json")
public class EchoRestCtrl {

	@GetMapping("")
	public void echo(@RequestParam(value= "msg") String msg) {
		ServiceEcho.reponseEcho(msg);
	}
}