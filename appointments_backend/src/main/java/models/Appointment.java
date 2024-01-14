package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.security.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ap_appointment")
public class Appointment extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_beginning")
    private Timestamp dateBeginning;

    @Column(name = "date_ending")
    private Timestamp dateEnding;

    @Column(name = "is_active")
    private Boolean isActive;
}
