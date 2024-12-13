package jay.fishcatchmonitoringsystem.CatchRecord.Controller;

import jay.fishcatchmonitoringsystem.CatchRecord.Model.CatchRecord;
import jay.fishcatchmonitoringsystem.CatchRecord.Service.CatchRecordService;
import jay.fishcatchmonitoringsystem.Fisherman.Service.FishermanService;
import jay.fishcatchmonitoringsystem.FishermanVessel.Service.FishermanVesselService;
import jay.fishcatchmonitoringsystem.Province.Model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CatchRecordController {

    @Autowired
    private CatchRecordService catchRecordService;

    @Autowired
    private FishermanService fishermanService;

    @Autowired
    private FishermanVesselService fishermanVesselService;


    //LIST
    @GetMapping("/catchRecord")
    public String listIndex(Model model){
        model.addAttribute("catchRecord", catchRecordService.getCatchRecordList());
        model.addAttribute("fisherman", fishermanService.getFishermanList());
        model.addAttribute("fishermanVessel", fishermanVesselService.getFishermanVesselList());
        return "views/backend/catch-record/index";
    }

    //SAVE
    @PostMapping(value = "/create-catchRecord")
    public String create(CatchRecord catchRecord, RedirectAttributes redirectAttributes) {
        catchRecordService.saveCatchRecord(catchRecord);
        redirectAttributes.addFlashAttribute("message", "Saved Successfully");
        return "redirect:/catchRecord";
    }

    //GET BY UPDATE ID
    @RequestMapping(value = "/catchRecord/findById")
    @ResponseBody
    public Optional<CatchRecord> findById(Long id) {
        return catchRecordService.getCatchRecordById(id);
    }

    //UPDATE
    @RequestMapping(value = "/update-catchRecord", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCatchRecord(CatchRecord catchRecord, RedirectAttributes redirectAttributes) {
        catchRecordService.updateCatchRecord(catchRecord);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/catchRecord";
    }

    //DELETE BY ID
    @RequestMapping("/delete-catchRecord/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (catchRecordService.deleteCatchRecordById(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/catchRecord";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/catchRecord";
    }
}
