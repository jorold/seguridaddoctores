package controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import models.Doctor;
import repositories.RepositoryDoctores;

public class ControllerLogin {

    HttpSession session;
    RepositoryDoctores repo;

    public ControllerLogin() {
        this.repo = new RepositoryDoctores();
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public boolean existeDoctor(String apellido, int doctornro) throws SQLException {
        Doctor doc = this.repo.existeDoctor(apellido, doctornro);
        if (doc == null) {
            return false;
        } else {
            session.setAttribute("DOCTOR", doc);
            return true;
        }
    }

    public void cerrarSesion() {
        session.setAttribute("DOCTOR", null);
        session.invalidate();
    }

}
