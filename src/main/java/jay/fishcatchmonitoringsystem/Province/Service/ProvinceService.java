package jay.fishcatchmonitoringsystem.Province.Service;

import jay.fishcatchmonitoringsystem.Province.Model.Province;
import jay.fishcatchmonitoringsystem.Province.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> getProvinceList() {
        return provinceRepository.findAll();
    }

    public Optional<Province> getProvinceById(Long id) {
        return provinceRepository.findById(id);
    }

    public Province saveProvince(Province province) {
        return provinceRepository.save(province);
    }

    public boolean deleteProvinceById(Long id) {
        provinceRepository.deleteById(id);
        if (provinceRepository.findById(id).isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean updateProvince(Province province) {
        Province p = provinceRepository.save(province);
        if (provinceRepository.findById(p.getId()).isEmpty()) {
            return true;
        }
        return false;
    }
}
