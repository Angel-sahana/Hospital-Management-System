package hospital;

import java.sql.*;
import java.util.*;

public class AppointmentDao {
	
    public int addAppointment(AppointmentBean appointment) {
        int status = 0;   //edhuvum add pannatha naala
     
        try (Connection con = HospitalUtil.getConnection()) //invoke getconnection method from hospital util class
        {
            String sql = "INSERT INTO appointment VALUES (?, ?, ?, ?)"; //?-placeholder
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, appointment.getAppointmentId());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getDoctorId());
            ps.setDate(4, java.sql.Date.valueOf(appointment.getDate()));
            status = ps.executeUpdate(); //ps.executeUpdate will perform the actual add operation into the database. once that op is suuccesful status will get updated to 1.
            
        } 
        catch (Exception e) //to print any errors occur in the console
        {
        	e.printStackTrace(); 
        }
        return status;
    }

    public List<AppointmentBean> getAllAppointments() {
        List<AppointmentBean> list = new ArrayList<>();
        
        try (Connection con = HospitalUtil.getConnection()) {
        	
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM appointment");
            while (rs.next()) //more than one row. next-to move row by row
            {
                list.add(new AppointmentBean(
                    rs.getInt(1), rs.getInt(2), rs.getInt(3),
                    rs.getDate(4).toLocalDate()  //already db la store pannatha again read panni adha list la add pandrom
                ));
            }
        }
        catch (Exception e) {
        	e.printStackTrace(); 
        }
        return list; //returns the list
    }
}

