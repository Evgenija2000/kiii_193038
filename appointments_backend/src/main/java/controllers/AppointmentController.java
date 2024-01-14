package controllers;

import dtos.AppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import services.interfaces.AppointmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/appointments")
public class AppointmentController {

    public final AppointmentService appointmentService;

    @GetMapping("/getAll")
    public List<AppointmentDTO> findAllAppointments(){return appointmentService.findAllAppointments();}

    @PostMapping("/addAppointment")
    public void addAppointment(@RequestBody AppointmentDTO appointmentDTO){appointmentService.addAppointment(appointmentDTO);}

    @PostMapping("/updateAppointment")
    public void updateAppointment(@RequestBody AppointmentDTO appointmentDTO){appointmentService.updateAppointment(appointmentDTO);}

    @DeleteMapping("/deleteAppointment/{id}")
    public void deleteProject(@PathVariable("id") Long id){appointmentService.deleteAppointment(id);}
}
