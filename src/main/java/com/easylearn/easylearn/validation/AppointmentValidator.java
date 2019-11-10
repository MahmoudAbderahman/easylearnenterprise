package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.repository.AppointmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AppointmentValidator extends BaseValidator<Appointment> {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentValidator(AppointmentRepository appointmentRepository)
    {
        super(Appointment.class);
        this.appointmentRepository = appointmentRepository;
    }
}
/*
package com.uptown.uptown.validation;

import com.uptown.uptown.entity.Program;
import com.uptown.uptown.repository.ProgramRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public final class ProgramValidator extends BaseValidator<Program> {
    private ProgramRepository programRepository;

    @Autowired
    public ProgramValidator(ProgramRepository programRepository) {
        super(Program.class);
        this.programRepository = programRepository;
    }
}

 */