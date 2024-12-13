package jay.fishcatchmonitoringsystem.Fisherman.Service;

import jay.fishcatchmonitoringsystem.Fisherman.Model.Fisherman;
import jay.fishcatchmonitoringsystem.Fisherman.Repository.FishermanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishermanService {

    @Autowired
    private FishermanRepository fishermanRepository;

    public List<Fisherman> getFishermanList(){
        return fishermanRepository.getFishermanStatusList();
    }

    public Optional<Fisherman> getFishermanById(Long id){
        return fishermanRepository.findById(id);
    }

    public Fisherman saveFisherman(Fisherman fisherman){
        return fishermanRepository.save(fisherman);
    }

    public boolean deleteFishermanById(Long id){
        fishermanRepository.deleteById(id);
        if (fishermanRepository.findById(id).isEmpty()){
            return true;
        }
        return false;
    }

    public boolean updateFisherman(Fisherman fisherman){
        Fisherman f = fishermanRepository.save(fisherman);
        if (fishermanRepository.findById(f.getId()).isEmpty()){
            return true;
        }
        return false;
    }
}
