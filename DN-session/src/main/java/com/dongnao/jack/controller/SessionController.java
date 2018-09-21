package com.dongnao.jack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/session")
public class SessionController {
    
    @RequestMapping("/login")
    public @ResponseBody Map login(HttpServletRequest request,
            HttpServletResponse response, @RequestBody String param, Map map,
            String param1) {
        HttpSession session = request.getSession();
        //        session.setAttribute("name", "jack");
        //        session.setAttribute("sex", 18);
        //        ModelAndView mv = new ModelAndView();
        //        mv.setViewName("index");
        Map retmap = new HashMap();
        retmap.put("name", "jack");
        retmap.put("age", "32");
        return retmap;
    }
    
    @RequestMapping("/login1")
    public String login1(HttpServletRequest request,
            HttpServletResponse response, @RequestBody String param, Map map,
            String param1) {
        return "index";
    }
}
