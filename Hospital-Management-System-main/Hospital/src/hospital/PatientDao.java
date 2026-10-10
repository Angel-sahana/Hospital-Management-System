package hospital;

import java.sql.*;
import java.util.*;

public class PatientDao {
    public int addPatient(PatientBean patient) {
        int status = 0;
        try (Connection con = HospitalUtil.getConnection()) {
            String sql = "INSERT INTO patient VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getGender());
            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }
    				
    public List<PatientBean> getAllPatients() {
        List<PatientBean> list = new ArrayList<>();
        try (Connection con = HospitalUtil.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM patient");
            while (rs.next()) {
                list.add(new PatientBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}

