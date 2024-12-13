package jay.fishcatchmonitoringsystem.Market.Repository;

import jay.fishcatchmonitoringsystem.Market.Models.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
