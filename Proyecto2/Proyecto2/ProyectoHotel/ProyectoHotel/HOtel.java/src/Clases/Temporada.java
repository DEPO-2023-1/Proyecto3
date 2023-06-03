package Clases;
	
import java.io.Serializable;
import java.util.Date;

public class Temporada implements Serializable{
    
    //atributos//

    private Date fechaIn;
    private Date fechaFin;
    private float aumento;

    //constructor//

    public Temporada (Date fechaIn, Date fechaFin, float aumento){
        fechaIn = this.fechaIn;
        fechaFin = this.fechaFin;
        aumento = this.aumento;
    }

    //metodos//

    public Date getFechaIn(){
        return fechaIn;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public float getAumento(){
        return aumento;
    }
    public void setAumento(float aumento){
        this.aumento = aumento;
    }
}
