package com.egfavre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by user on 6/21/16.
 */
@Controller
public class MicroblogController {
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String home(HttpSession session){
        String username = (String) session.getAttribute("username");

        if (username == null){
            return "login";
        }
        return "home";
    }
}
