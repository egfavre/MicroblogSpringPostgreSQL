package com.egfavre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by user on 6/21/16.
 */
@Controller
public class MicroblogController {
    @Autowired
    UserRepository users;
    @Autowired
    MessageRepository messages;

    @RequestMapping(path="/", method= RequestMethod.GET)
    public String home(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        if (username == null){
            return "login";
        }
        Iterable<Message>msgs = messages.findAll();
        model.addAttribute("msgs", msgs);
        return "home";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws Exception {
        if (username.isEmpty() || password.isEmpty()){
            throw new Exception("You did not enter username and password");
        }

        User user = users.findByUsername(username);
        if (user == null){
            user = new User(username, password);
            users.save(user);
        }
        if (!user.password.equals(password)){
            throw new Exception("wrong password");
        }
        session.setAttribute("username", username);

        return "redirect: /";
    }

    @RequestMapping(path="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path="/create-message", method = RequestMethod.POST)
    public String create(HttpSession session, String message){
        Message msg = new Message (message);
        messages.save(msg);
        return "redirect:/";
    }

    @RequestMapping(path="/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int id){
        messages.delete(id);
        return "redirect:/";
    }
}
