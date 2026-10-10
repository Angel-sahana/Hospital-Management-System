package hospital;

import java.sql.*;
import java.util.*;

public class DoctorDao {
    public int addDoctor(DoctorBean doctor) {
        int status = 0;
        try (Connection con = HospitalUtil.getConnection()) {
            String sql = "INSERT INTO doctor VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, doctor.getDoctorId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialization());
            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }

    public List<DoctorBean> getAllDoctors() {
        List<DoctorBean> list = new ArrayList<>();
        try (Connection con = HospitalUtil.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM doctor");
            while (rs.next()) {
                list.add(new DoctorBean(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}

