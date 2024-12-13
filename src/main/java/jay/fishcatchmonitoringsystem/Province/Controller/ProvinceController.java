package jay.fishcatchmonitoringsystem.Province.Controller;

import jay.fishcatchmonitoringsystem.City.Service.CityService;
import jay.fishcatchmonitoringsystem.Province.Model.Province;
import jay.fishcatchmonitoringsystem.Province.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProvinceController {

    @Autowired
    CityService cityService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    //LIST
    @GetMapping(value = "/province")
    public String listIndex(Model model) {
        model.addAttribute("province", provinceService.getProvinceList());
        model.addAttribute("city", cityService.getCityList());
        return "views/backend/province/index";
    }

    @PostMapping(value = "/create-province")
    public String createProvince(Province province, RedirectAttributes redirectAttributes) {
        provinceService.saveProvince(province);
        redirectAttributes.addFlashAttribute("message", "Saved Successfully");
        return "redirect:/province";
    }

    @RequestMapping(value = "/province/findById")
    @ResponseBody
    public Optional<Province> findById(Long id) {
        return provinceService.getProvinceById(id);
    }

    @RequestMapping(value = "/update-province", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateProvince(Province province, RedirectAttributes redirectAttributes) {
        provinceService.updateProvince(province);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/province";
    }

    //DELETE BY ID
    @RequestMapping("/delete-province/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (provinceService.deleteProvinceById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/province";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/province";
    }
}
