package jay.fishcatchmonitoringsystem.Province.Repository;

import jay.fishcatchmonitoringsystem.Province.Model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
