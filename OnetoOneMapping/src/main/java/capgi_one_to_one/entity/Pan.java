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
public class Pan {
    @Id
    private int panNumber;
    private String PanAddress;

    @OneToOne
    private Person1 person1;

}
