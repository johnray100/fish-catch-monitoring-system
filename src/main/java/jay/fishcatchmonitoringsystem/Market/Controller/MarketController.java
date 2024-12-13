package jay.fishcatchmonitoringsystem.Market.Controller;

import jay.fishcatchmonitoringsystem.City.Service.CityService;
import jay.fishcatchmonitoringsystem.Market.Models.Market;
import jay.fishcatchmonitoringsystem.Market.Service.MarketService;
import jay.fishcatchmonitoringsystem.Province.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ProvinceService provinceService;


    @GetMapping(value = "/markets")
    public String listIndex(Model model) {
        model.addAttribute("markets", marketService.getMarketList());
        model.addAttribute("city", cityService.getCityList());
        model.addAttribute("province", provinceService.getProvinceList());
        return "views/backend/market/index";
    }

    @PostMapping(value = "/create-market")
    public String createMarket(Market market, RedirectAttributes redirectAttributes) {
        marketService.createMarket(market);
        redirectAttributes.addFlashAttribute("message", "Save success");
        return "redirect:/markets";
    }

    @RequestMapping(value = "/markets/findById")
    @ResponseBody
    public Optional<Market> findById(Long id){
        return marketService.getMarketById(id);
    }


    @RequestMapping(value = "/update-markets", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateMarket(Market market) {
        marketService.createMarket(market);
        return "redirect:/markets";
    }

    //DELETE BY ID
    @RequestMapping("/delete-markets/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (marketService.deleteMarketById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/province";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/province";
    }
}
