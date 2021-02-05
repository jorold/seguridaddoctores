package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Doctor;
import oracle.jdbc.OracleDriver;

public class RepositoryDoctores {

    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public ArrayList<Doctor> getDoctores() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Doctor> lista = new ArrayList<>();
        while (rs.next()) {
            int cod = rs.getInt("HOSPITAL_COD");
            int nro = rs.getInt("DOCTOR_NO");
            String ape = rs.getString("APELLIDO");
            String esp = rs.getString("ESPECIALIDAD");
            int sal = rs.getInt("SALARIO");
            Doctor doc = new Doctor(cod, nro, ape, esp, sal);
            lista.add(doc);
        }
        rs.close();
        cn.close();
        return lista;
    }

    public Doctor existeDoctor(String apellido, int doctornro) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor where apellido=?"
                + "and doctor_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, apellido);
        pst.setInt(2, doctornro);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int cod = rs.getInt("HOSPITAL_COD");
            int nro = rs.getInt("DOCTOR_NO");
            String ape = rs.getString("APELLIDO");
            String esp = rs.getString("ESPECIALIDAD");
            int sal = rs.getInt("SALARIO");
            Doctor doc = new Doctor(cod, nro, ape, esp, sal);
            rs.close();
            cn.close();
            return doc;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }
}
