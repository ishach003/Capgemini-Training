package capgi_one_to_one.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Passport {
    @Id
    private  int passportId;
    private  String country;

    private  int passportNumber;

    @OneToOne(mappedBy = "passport")
    private Human human;
}
