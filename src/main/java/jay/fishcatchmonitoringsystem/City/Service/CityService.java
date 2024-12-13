package jay.fishcatchmonitoringsystem.City.Service;

import jay.fishcatchmonitoringsystem.City.Model.City;
import jay.fishcatchmonitoringsystem.City.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCityList(){
        List<City> cityList = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cityList.add(city));

        return cityList;
    }

    public City getCityById(Long id){
        return cityRepository.findById(id).get();
    }

    public City save(City city){
        return cityRepository.save(city);
    }

    public boolean update(City city ) {
        City city1 = cityRepository.save(city);
        if (cityRepository.findById(city1.getId()).isEmpty()){
            return true;
        }
        return false;
    }

    public boolean deleteCityById(Long id){
        cityRepository.deleteById(id);
        if (cityRepository.findById(id).isEmpty()){
            return true;
        }
        return false;
    }
}
