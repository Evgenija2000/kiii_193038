package services.impl;

import dtos.AppointmentDTO;
import models.Appointment;
import org.springframework.stereotype.Service;
import repository.AppointmentRepository;
import services.interfaces.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    public final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentDTO> findAllAppointments() {
        return modelToDto(appointmentRepository.findAll());
    }

    @Override
    public AppointmentDTO modelToDto(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setName(appointment.getName());
        appointmentDTO.setDescription(appointment.getDescription());
        appointmentDTO.setDateBeginning(appointment.getDateBeginning());
        appointmentDTO.setDateBeginning(appointment.getDateEnding());
        appointmentDTO.setIsActive(appointment.getIsActive());
        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> modelToDto(List<Appointment> appointments) {
        return appointments.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) {
       Appointment appointment = new Appointment();
       appointment.setName(appointmentDTO.getName());
       appointment.setDescription(appointmentDTO.getDescription());
       appointment.setDateBeginning(appointmentDTO.getDateBeginning());
       appointment.setDateEnding(appointmentDTO.getDateEnding());
       appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        Long id = appointmentDTO.getId();
        Appointment appointment = this.appointmentRepository.findById(id).get();
        appointment.setName(appointmentDTO.getName());
        appointment.setDescription(appointmentDTO.getDescription());
        appointment.setDateBeginning(appointmentDTO.getDateBeginning());
        appointment.setDateEnding(appointmentDTO.getDateEnding());
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
