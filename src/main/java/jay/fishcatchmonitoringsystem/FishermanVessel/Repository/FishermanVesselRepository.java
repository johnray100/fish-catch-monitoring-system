package jay.fishcatchmonitoringsystem.FishermanVessel.Repository;

import jay.fishcatchmonitoringsystem.FishermanVessel.Model.FishermanVessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermanVesselRepository extends JpaRepository<FishermanVessel, Long> {
}
