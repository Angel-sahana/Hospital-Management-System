package hospital;

import java.time.LocalDate;
import java.util.List;

public class HospitalService {
    private PatientDao patientDao = new PatientDao();
    private DoctorDao doctorDao = new DoctorDao();
    private AppointmentDao appointmentDao = new AppointmentDao();

    public boolean registerPatient(PatientBean patient) { 
        return patientDao.addPatient(patient) > 0;
    }

    public boolean registerDoctor(DoctorBean doctor) {
        return doctorDao.addDoctor(doctor) > 0;
    }

    public boolean bookAppointment(int appId, int patientId, int doctorId, LocalDate date) {
        AppointmentBean app = new AppointmentBean(appId, patientId, doctorId, date);
        return appointmentDao.addAppointment(app) > 0;
    }

    public List<PatientBean> getAllPatients() { //getallpatient()- method
    	return patientDao.getAllPatients(); 
    	}
    
    public List<DoctorBean> getAllDoctors() {
    	return doctorDao.getAllDoctors(); 
    	}
    
    public List<AppointmentBean> getAllAppointments() { 
    	return appointmentDao.getAllAppointments(); 
    	}
}
