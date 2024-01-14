package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;

    private String name;

    private String description;

    private Timestamp dateBeginning;

    private Timestamp dateEnding;

    private Boolean isActive;
}
