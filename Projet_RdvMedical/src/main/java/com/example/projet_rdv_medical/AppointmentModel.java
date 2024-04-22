package com.example.projet_rdv_medical;

import java.sql.Time;
import java.util.Date;

public class AppointmentModel extends AvailableAppointmentModel {
    private int patientId;

    public AppointmentModel(int id, int patientId, int doctorId, Date date, Time time) {
        super(id, doctorId, date, time);
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
