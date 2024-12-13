package jay.fishcatchmonitoringsystem.FishermanVessel.Service;

import jay.fishcatchmonitoringsystem.Fisherman.Model.Fisherman;
import jay.fishcatchmonitoringsystem.FishermanVessel.Model.FishermanVessel;
import jay.fishcatchmonitoringsystem.FishermanVessel.Repository.FishermanVesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishermanVesselService {

    @Autowired
    private FishermanVesselRepository fishermanVesselRepository;

    public List<FishermanVessel> getFishermanVesselList() {
        return fishermanVesselRepository.findAll();
    }

    public Optional<FishermanVessel> getFishermanVesselById(Long id) {
        return fishermanVesselRepository.findById(id);
    }

    public FishermanVessel saveFishermanVessel(FishermanVessel fishermanVessel) {
        return fishermanVesselRepository.save(fishermanVessel);
    }

    public boolean deleteFishermanVesselById(Long id) {
        fishermanVesselRepository.deleteById(id);
        if (fishermanVesselRepository.findById(id).isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean updateFishermanVessel(FishermanVessel fishermanVessel) {
        FishermanVessel f = fishermanVesselRepository.save(fishermanVessel);
        if (fishermanVesselRepository.findById(f.getId()).isEmpty()) {
            return true;
        }
        return false;
    }
}

