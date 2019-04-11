package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.POJO.Gender;
import pl.coderslab.model.POJO.UserDto;
import pl.coderslab.model.entities.User;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String getRegistrationForm(Model model){
        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.FEMALE);
        genders.add(Gender.MALE);

        model.addAttribute("genders",genders);
        model.addAttribute("user",new UserDto());
        return "/user/registrationForm";
    }

    @PostMapping("/register")
    public String processForm(@ModelAttribute("user") @Valid UserDto user, BindingResult br, Model model ){
        if(br.hasErrors()){
            model.addAttribute("user", user);
            return "user/registrationForm";
        }
        User u = new User(user);

        this.userRepository.save(u);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new UserDto());
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String processLogForm(UserDto loginData, Model m, HttpSession s){
        User user = this.userRepository.findByEmail(loginData.getEmail());
        if(user==null){
            m.addAttribute("user", loginData);
            m.addAttribute("msg", "User not found");
            return "user/loginForm";
        }

        if(!user.isPasswordCorrect(loginData.getPassword())){
            m.addAttribute("user", loginData);
            m.addAttribute("msg", "Wrong password");
            return "user/loginForm";
        }

        s.setAttribute("loggedInUser", user);

        return "redirect:/schedule";
    }


    @GetMapping("/logout")
    public String logout(HttpSession s){
        s.removeAttribute("loggedInUser");

        return "redirect:login";
    }

}
