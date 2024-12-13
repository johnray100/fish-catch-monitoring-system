package jay.fishcatchmonitoringsystem.FishermanVessel.Model;


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
public class FishermanVessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vesselName")
    private String vesselName;

    @Column(name = "description")
    private String description;

    @Column(name = "fishermanOwner")
    private String fishermanOwner;

    @Column(nullable = true, length = 64)
    private String photo;

    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Transient
    public String getPhotosImagePath() {
        if (photo == null) return null;
        return "/user-photos/" + id + "/" + photo;
    }
}
