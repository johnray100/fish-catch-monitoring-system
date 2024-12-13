package jay.fishcatchmonitoringsystem.FishermanVessel.Controller;

import jay.fishcatchmonitoringsystem.Fisherman.Service.FishermanService;
import jay.fishcatchmonitoringsystem.FishermanVessel.Config.FileUploadUtil;
import jay.fishcatchmonitoringsystem.FishermanVessel.Model.FishermanVessel;
import jay.fishcatchmonitoringsystem.FishermanVessel.Service.FishermanVesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class FishermanVesselController {

    @Autowired
    private FishermanVesselService fishermanVesselService;

    @Autowired
    private FishermanService fishermanService;

    @GetMapping(value = "/fisherman-vessel")
    public String listIndex(Model model) {
        model.addAttribute("fishermanVessel", fishermanVesselService.getFishermanVesselList());
        return "views/backend/fisherman-vessel/index";
    }

    @GetMapping(value = "/add-fishermanVessel")
    public String addAlbum(Model model, FishermanVessel fishermanVessel) {
        model.addAttribute("fishermanVessel", fishermanVessel);
        model.addAttribute("fisherman", fishermanService.getFishermanList());

        return "views/backend/fisherman-vessel/create";
    }

    /*** SAVE DATA ***/
    @PostMapping("/create-fishermanVessel")
    public RedirectView saveFishermanVessel(@ModelAttribute("fishermanV") FishermanVessel vessel, @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttribute) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        vessel.setPhoto(fileName);
        FishermanVessel fishermanVessel = fishermanVesselService.saveFishermanVessel(vessel);
        String uploadDir = "user-photos/" + fishermanVessel.getId();
        FileUploadUtil.store(uploadDir, fileName, multipartFile);
        redirectAttribute.addFlashAttribute("message", "Save Success");

        return new RedirectView("/fishermanVessel", true);
    }

    @GetMapping("/edit-fishermanVessel/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute("message") String message, Model model) {
        FishermanVessel f = fishermanVesselService.getFishermanVesselById(id).get();
        model.addAttribute("fishermanVessel", f);
        model.addAttribute("message", message);
        model.addAttribute("fisherman", fishermanService.getFishermanList());

        return "views/backend/fisherman-vessel/update";
    }


    //DELETE BY ID
    @RequestMapping("/delete-fishermanVessel/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (fishermanVesselService.deleteFishermanVesselById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/fisherman-vessel";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/fisherman-vessel";
    }
}
