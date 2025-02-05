package com.mk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/session")
public class TestSessionController {

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/set/{name}")
    public String test1(HttpServletRequest request,@PathVariable("name") String name){
        request.getSession().setAttribute("User", name);
        System.out.println(request);
        return "Set Session OK !";
    }
    @GetMapping("/get")
    public String getSession(HttpServletRequest request){
        Object user = request.getSession().getAttribute("User");
        if (user != null)
            return user.toString();
        return "未登录";
    }
}
