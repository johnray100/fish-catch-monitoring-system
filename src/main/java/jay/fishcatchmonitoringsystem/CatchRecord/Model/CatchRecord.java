package jay.fishcatchmonitoringsystem.CatchRecord.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fishermanName")
    private String fishermanName;

    @Column(name = "vesselName")
    private String vesselName;

    @Column(name = "fishName")
    private String fishName;

    @Column(name = "catchInKilogram")
    private String catchInKilogram;

    @Column(name = "fishingLocation")
    private String fishingLocation;

    @Column(name = "dispatch")
    private String dispatch;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfNow;

    @Column(name = "timeAt")
    private String timeAt;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
