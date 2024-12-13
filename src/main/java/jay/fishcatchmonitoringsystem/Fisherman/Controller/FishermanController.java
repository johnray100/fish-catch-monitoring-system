package jay.fishcatchmonitoringsystem.Fisherman.Controller;

import jay.fishcatchmonitoringsystem.City.Service.CityService;
import jay.fishcatchmonitoringsystem.Fisherman.Model.Fisherman;
import jay.fishcatchmonitoringsystem.Fisherman.Service.FishermanService;
import jay.fishcatchmonitoringsystem.Province.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FishermanController {

    @Autowired
    FishermanService fishermanService;

    @Autowired
    CityService cityService;

    @Autowired
    ProvinceService provinceService;

    @GetMapping(value = "/fisherman")
    public String listIndex(Model model) {
        model.addAttribute("fisherman", fishermanService.getFishermanList());
        model.addAttribute("city", cityService.getCityList());
        model.addAttribute("province", provinceService.getProvinceList());
        return "views/backend/fisherman/index";
    }


    @PostMapping("/create-fisherman")
    public String createFisherman(Fisherman fisherman, RedirectAttributes redirectAttributes){
        fishermanService.saveFisherman(fisherman);
        redirectAttributes.addFlashAttribute("message", "Saved Successfully");
        return "redirect:/fisherman";
    }

    @RequestMapping(value = "/fisherman/findById")
    @ResponseBody
    public Optional<Fisherman> findById(Long id) {
        return fishermanService.getFishermanById(id);
    }

    @RequestMapping(value = "/update-fisherman", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateFisherman(Fisherman fisherman, RedirectAttributes redirectAttributes) {
        fishermanService.updateFisherman(fisherman);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/fisherman";
    }

    //DELETE BY ID
    @RequestMapping("/delete-fisherman/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (fishermanService.deleteFishermanById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/fisherman";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/fisherman";
    }
}
