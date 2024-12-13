package jay.fishcatchmonitoringsystem.Market.Service;

import jay.fishcatchmonitoringsystem.Market.Models.Market;
import jay.fishcatchmonitoringsystem.Market.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    public List<Market> getMarketList(){
        return marketRepository.findAll();
    }

    public Optional<Market> getMarketById(Long id) {
        return marketRepository.findById(id);
    }

    public void createMarket(Market market) {
        marketRepository.save(market);
    }

    public boolean deleteMarketById(Long id){
        marketRepository.deleteById(id);
        if (marketRepository.findById(id).isEmpty()){
            return true;
        }
        return false;
    }
}
