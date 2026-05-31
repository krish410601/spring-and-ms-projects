package com.wipro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

}
