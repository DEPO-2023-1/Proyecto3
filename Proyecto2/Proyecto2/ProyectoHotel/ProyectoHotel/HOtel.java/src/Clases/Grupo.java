package Clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class Grupo implements Serializable{

    //atributos clase//
    private ArrayList<Huesped> huespedes;
    private String IDHabitacion;
    private Date reservaInicio;
    private Date reservaFinal;
    
    //constructor//
    public Grupo(String IDHabitacion, Date reservaInicio, Date reservaFinal) {
        this.IDHabitacion = IDHabitacion;
        this.reservaInicio = reservaInicio;
        this.reservaFinal = reservaFinal;
        this.huespedes = new ArrayList<Huesped>();
    }
    
    // metodos//
    
    public void addHuesped(String nombre, int cedula, int edad, String correo) {
    	Huesped huesped = new Huesped(nombre, cedula, correo, edad);
    	huespedes.add(huesped);
    }
    
    public ArrayList<String> getNombresHuespedes() {
    	ArrayList<String> resultado = new ArrayList<>();
    	for (Huesped h:huespedes) {
    		resultado.add(h.getNombre());
    	}
    	return resultado;
    }
    
    public String getIDHabitacion() {
        return IDHabitacion;
    }
    
    public void setIDHabitacion(String IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }
    
    public ArrayList<Huesped> getGrupo() {
        return huespedes;
    }
    
    public void setGrupo(ArrayList<Huesped> grupo) {
        this.huespedes = grupo;
    }

	public Date getReservaInicio() {
		return reservaInicio;
	}

	public Date getReservaFinal() {
		return reservaFinal;
	}
}
