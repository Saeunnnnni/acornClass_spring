package com.example.boot03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody//리턴하는 문자열이 바로 클라이언트한테 갈 수 있게 하는 어노테이션 
	@RequestMapping("/hello")
	public String hello() {
		return "Nice to meet you!";
	}
}
