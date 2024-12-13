package jay.fishcatchmonitoringsystem.CatchRecord.Repository;

import jay.fishcatchmonitoringsystem.CatchRecord.Model.CatchRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatchRecordRepository extends JpaRepository<CatchRecord, Long> {
}
