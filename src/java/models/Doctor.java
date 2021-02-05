package models;

public class Doctor {

    private int hospitalcod;
    private int doctornro;
    private String apellido;
    private String especialidad;
    private int salario;

    public Doctor() {
    }

    public Doctor(int cod, int nro, String ape, String esp, int sal) {
        this.hospitalcod = cod;
        this.doctornro = nro;
        this.apellido = ape;
        this.especialidad = esp;
        this.salario = sal;
    }

    public int getHospitalcod() {
        return hospitalcod;
    }

    public void setHospitalcod(int hospitalcod) {
        this.hospitalcod = hospitalcod;
    }

    public int getDoctornro() {
        return doctornro;
    }

    public void setDoctornro(int doctornro) {
        this.doctornro = doctornro;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
