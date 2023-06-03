package Clases;
import java.io.Serializable;


public class Servicio implements Serializable{

    //atributos//
    private String nombre;
    private String tipo;
    private float precio;
    
    //constructor//
	public Servicio(String nombre, String tipo, float precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}

	
	//metodos//
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getTipo(){
		return tipo;
	}
    
    
    
    
}