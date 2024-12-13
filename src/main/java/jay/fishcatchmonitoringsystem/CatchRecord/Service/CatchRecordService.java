package jay.fishcatchmonitoringsystem.CatchRecord.Service;

import jay.fishcatchmonitoringsystem.CatchRecord.Model.CatchRecord;
import jay.fishcatchmonitoringsystem.CatchRecord.Repository.CatchRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatchRecordService {

    @Autowired
    private CatchRecordRepository catchRecordRepository;

    public List<CatchRecord> getCatchRecordList(){
        return catchRecordRepository.findAll();
    }

    public Optional<CatchRecord> getCatchRecordById(Long id){
        return catchRecordRepository.findById(id);
    }

    public void saveCatchRecord(CatchRecord catchRecord){
        catchRecordRepository.save(catchRecord);
    }

    public boolean updateCatchRecord(CatchRecord catchRecord){
        catchRecordRepository.save(catchRecord);
        if (catchRecordRepository.findById(catchRecord.getId()).isEmpty()){
            return true;
        }
        return false;
    }

    public boolean deleteCatchRecordById(Long id){
        catchRecordRepository.deleteById(id);
        if (catchRecordRepository.findById(id).isEmpty()){
            return true;
        }
        return false;
    }
}
