package jay.fishcatchmonitoringsystem.Fisherman.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Fisherman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
