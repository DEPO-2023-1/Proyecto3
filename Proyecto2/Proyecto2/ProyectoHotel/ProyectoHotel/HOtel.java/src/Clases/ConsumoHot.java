package Clases;

import java.io.Serializable;

public class ConsumoHot implements Serializable{

    //atributos//
    private String IDHabitacion;
    private String tipo;
    private String servicio;
    
    //constructor//
    public ConsumoHot(String IDHabitacion, String tipo, String servicio) {
        this.IDHabitacion = IDHabitacion;
        this.tipo = tipo;
        this.servicio = servicio;
    }
    
    //metodos//
    public String getIDHabitacion() {
        return IDHabitacion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getServicio() {
        return servicio;
    }
    
    public void setIDHabitacion(String IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
