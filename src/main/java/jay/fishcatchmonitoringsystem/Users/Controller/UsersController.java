package jay.fishcatchmonitoringsystem.Users.Controller;

import jay.fishcatchmonitoringsystem.Users.Dto.UsersRegistrationDto;
import jay.fishcatchmonitoringsystem.Users.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("users")
    public UsersRegistrationDto userRegistrationDto() {
        return new UsersRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "views/frontend/user-registration/index";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UsersRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
