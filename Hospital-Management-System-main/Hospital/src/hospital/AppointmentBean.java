package hospital;

import java.time.LocalDate;

public class AppointmentBean {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDate date;

    public AppointmentBean() {}

    public AppointmentBean(int appointmentId, int patientId, int doctorId, LocalDate date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getAppointmentId() 
    { 
    	return appointmentId; 
    }
    public void setAppointmentId(int appointmentId) 
    {
    	this.appointmentId = appointmentId; 
    }

    public int getPatientId() 
    { 
    	return patientId; 
    }
    public void setPatientId(int patientId) 
    {
    	this.patientId = patientId; 
    }

    public int getDoctorId() 
    {
    	return doctorId; 
    }
    public void setDoctorId(int doctorId) 
    {
    	this.doctorId = doctorId; 
    }
 
    public LocalDate getDate() 
    {
    	return date; 
    }
    public void setDate(LocalDate date) 
    { 
    	this.date = date; 
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", PatientID=" + patientId +
               ", DoctorID=" + doctorId + ", Date=" + date + "]";
    }
}

