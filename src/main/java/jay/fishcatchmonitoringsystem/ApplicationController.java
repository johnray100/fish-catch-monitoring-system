package jay.fishcatchmonitoringsystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String dashboard(Model model){

        return "views/backend/dashboard/index";
    }
}
