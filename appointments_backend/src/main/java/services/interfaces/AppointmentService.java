package services.interfaces;

import dtos.AppointmentDTO;
import models.Appointment;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> findAllAppointments();
    AppointmentDTO modelToDto(Appointment appointment);
    List<AppointmentDTO> modelToDto(List<Appointment> getAll);
    void addAppointment(AppointmentDTO appointmentDTO);
    void updateAppointment(AppointmentDTO appointmentDTO);
    void deleteAppointment(Long id);
}
