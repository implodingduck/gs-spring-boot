package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		Map<String, String> env = System.getenv();
		StringBuilder sb = new StringBuilder("Greetings from Spring Boot!");
		String initialstatus = System.getenv("EUREKA_INSTANCE_INITIALSTATUS");
		if (initialstatus != null){
			String state = (initialstatus.equals("UP")) ? "Active" : "Staging";
			sb.append(state);
		}
		
		sb.append("<hr />");
		for (String envName : env.keySet()) {
			sb.append(envName);
			sb.append("=");
			sb.append(env.get(envName));
			sb.append(" ~~~~ ");
		}
		return sb.toString();
	}

}
