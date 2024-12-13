package jay.fishcatchmonitoringsystem.Users.Controller;

import jay.fishcatchmonitoringsystem.Users.Models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersLoginController {

    @GetMapping(value = "/login")
    public String login(Model model, Users user){
        model.addAttribute("user", user);
        return "views/frontend/login/index";
    }
}
