package jay.fishcatchmonitoringsystem.City.Controller;

import jay.fishcatchmonitoringsystem.City.Model.City;
import jay.fishcatchmonitoringsystem.City.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    //LIST
    @GetMapping(value = "/city")
    public String listIndex(@ModelAttribute("message") String message, Model model) {
        List<City> cityList = cityService.getCityList();
        model.addAttribute("city", cityList);
        model.addAttribute("message", message);

        return "views/backend/city/index";
    }

    //SHOW FORM
    @GetMapping("/add-city")
    public String addCity(@ModelAttribute("message") String message, Model model) {
        City cityList = new City();
        model.addAttribute("city", cityList);
        model.addAttribute("message", message);

        return "views/backend/city/create";
    }

    //SAVE
    @PostMapping("/create-city")
    public String create(@ModelAttribute("message") City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Save success");
        return "redirect:/city";
    }

    //EDIT BY ID
    @GetMapping("/edit-city/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute("message") String message, Model model) {
        City city = cityService.getCityById(id);
        model.addAttribute("city", city);
        model.addAttribute("message", message);
        return "views/backend/city/update";
    }

    //UPDATE
    @PostMapping("/update-city")
    public String update(@ModelAttribute("city") City city, RedirectAttributes redirectAttributes) {
        if (cityService.update(city)) {
            redirectAttributes.addFlashAttribute("message", "Update Successfully");
            return "redirect:/city";
        }
        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "views/backend/city/update" + city.getId();
    }

    //DELETE BY ID
    @RequestMapping("/delete-city/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (cityService.deleteCityById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/city";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/city";
    }

    /***
     * EXPORT DATA TO PDF FILE
     */
    @GetMapping("/pdfExport")
    public ModelAndView exportToPdf() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new CityDataPdfExport());
        List<City> list= cityService.getCityList();
        mav.addObject("city", list);
        return mav;
    }
}
