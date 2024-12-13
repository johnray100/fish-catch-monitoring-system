package jay.fishcatchmonitoringsystem.Fisherman.Repository;

import jay.fishcatchmonitoringsystem.Fisherman.Model.Fisherman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, Long> {

    @Query("SELECT f FROM Fisherman f WHERE f.status = 'Active' or f.status='Inactive' ")
    List<Fisherman> getFishermanStatusList();

}
