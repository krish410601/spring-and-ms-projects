package com.wipro.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ams.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

}
