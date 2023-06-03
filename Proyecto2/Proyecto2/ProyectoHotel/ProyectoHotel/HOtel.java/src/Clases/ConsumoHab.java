package Clases;

import java.io.Serializable;

public class ConsumoHab implements Serializable{

    


    //atributos//

    private String idHabitacion;
    private String tipo;
    private String servicio;

    //constructor//

    public ConsumoHab(String idHabitacion, String tipo, String servicio){

        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.servicio = servicio;


    }

    //metodos//

    public String getIdHabitacion(){
        return idHabitacion;
    }


    public String getServicio(){
        return servicio;
    }

    public String getTipo(){
        return tipo;
    }
    
}
