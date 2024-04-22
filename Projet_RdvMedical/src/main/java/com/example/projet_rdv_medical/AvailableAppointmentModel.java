package com.example.projet_rdv_medical;

import java.sql.Time;
import java.util.Date;

public class AvailableAppointmentModel {
    protected int id;
    protected int doctorId;
    protected Date date;
    protected Time time;

    public AvailableAppointmentModel(int id, int doctorId, Date date, Time time) {
        this.id = id;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
