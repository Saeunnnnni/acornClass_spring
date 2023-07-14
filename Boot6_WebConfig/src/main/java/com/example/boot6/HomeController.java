package com.example.boot6;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   @GetMapping("/")
   public String home(HttpServletRequest request) {
      List<String> noticeList = new ArrayList<>();
      noticeList.add("Spring Boot 시작");
      noticeList.add("드르렁");
      noticeList.add("Spring Boot 낙오");
      
      request.setAttribute("noticeList", noticeList);
      
      return "home";
   }
   
   
}