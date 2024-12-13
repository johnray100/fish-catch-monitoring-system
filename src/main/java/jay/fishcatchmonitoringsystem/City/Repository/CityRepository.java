package jay.fishcatchmonitoringsystem.City.Repository;

import jay.fishcatchmonitoringsystem.City.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
