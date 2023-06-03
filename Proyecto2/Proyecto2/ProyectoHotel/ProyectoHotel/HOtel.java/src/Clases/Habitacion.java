package Clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;



public abstract class Habitacion implements Serializable{
    
	//atributos clases//
	private ArrayList<Temporada> temporadas;
	private ArrayList<Reserva> reservas;
	private ArrayList<Grupo> grupos;
	private ArrayList<ConsumoHab> consumosHab;



	//atributos//
	
	
	private String idHabitacion;
	private String ubicacion;
	private String tipo;
	private int capacidadNino;
	private int capaciodadAdulto;
	private Boolean balcon;
	private Boolean cocina;
	private Boolean vista;
	private float precioI;
	private float precioF;

	//constructor//
	public Habitacion(String idHabitacion, String tipo,String ubicacion, int capacidadNino, int capaciodadAdulto,
	Boolean balcon, Boolean cocina, Boolean vista, float precioI){
		this.temporadas = new ArrayList<Temporada>();
		this.reservas = new ArrayList<Reserva>();
		this.grupos = new ArrayList<Grupo>();
		this.consumosHab = new ArrayList<ConsumoHab>();
		this.idHabitacion = idHabitacion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.capacidadNino = capacidadNino;
		this.capaciodadAdulto = capaciodadAdulto;
		this.balcon = balcon;
		this.cocina = cocina;
		this.vista = vista;
		this.precioI = precioI;
		float valorIntermedio = calcularPrecioIntermedio(capacidadNino, capaciodadAdulto, balcon, cocina,vista, precioI);
		this.precioF = valorIntermedio;
	}

    //metodos//
	
	public boolean disponibleEnFecha(Date inicialDate, Date finalDate) {
		
		boolean respuesta = true;
		for (Reserva r: reservas) {
			Date reservaInicio = r.getFechaInicio();
			Date reservaFinal = r.getFechaFin();
			if ((inicialDate.before(reservaInicio)&&finalDate.after(reservaInicio))||(inicialDate.before(reservaFinal)&&finalDate.after(reservaFinal))) {
				respuesta = false;
				break;
			}
		}
		return respuesta;
	}
	
	
	public void addTemporada(Date inicialDate, Date finalDate, float aumento) {
		
		Temporada temporada = new Temporada(inicialDate, finalDate, aumento);
		temporadas.add(temporada);
		
	}
	
	public void addReserva(Date inicialDate, Date finalDate) {
		Reserva reserva = new Reserva(inicialDate, finalDate);
		reservas.add(reserva);
	}
	
	public void addGrupo(Grupo grupo) {
		grupos.add(grupo);
	}
	
	public void agregarConsumo(String IdHabitacion, String servicio) {
		
		ConsumoHab consumo = new ConsumoHab(IdHabitacion, "consumo", servicio);
		consumosHab.add(consumo);
		
	}
	
	public void agregarPago(String IdHabitacion, String servicio) {
		
		ConsumoHab consumo = new ConsumoHab(IdHabitacion, "pago", servicio);
		consumosHab.add(consumo);
		
	}
	
	public void setPrecioTemporada(Date inicialDate, Date finalDate, float cambio) {
		for (Temporada t: temporadas) {
			Date temporadaInicio = t.getFechaIn();
			Date temporadaFinal = t.getFechaFin();
			if ((inicialDate.before(temporadaInicio)&&finalDate.after(temporadaInicio))||(inicialDate.before(temporadaFinal)&&finalDate.after(temporadaFinal))) {
				float aumento = t.getAumento();
				if (aumento > cambio) {
					t.setAumento(cambio);
					addTemporada(inicialDate, finalDate, cambio);
				}
				else if (aumento < cambio) {
					t.setAumento(cambio);
					addTemporada(inicialDate, finalDate, aumento);
				}
			}	
		}
		
	}
	
	public void delreserva(Date inicialDate, Date finalDate) {
		for (Reserva r: reservas) {
			Date dateInicio = r.getFechaInicio();
			Date dateFinal = r.getFechaFin();
			if ((dateInicio.equals(inicialDate)) && (dateFinal.equals(finalDate))) {
				reservas.remove(r);
			}
		}
	}
	
	
    public String getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public int getCapacidadNino() {
		return capacidadNino;
	}
	public void setCapacidadNino(int capacidadNino) {
		this.capacidadNino = capacidadNino;
	}
	public int getCapaciodadAdulto() {
		return capaciodadAdulto;
	}
	public void setCapaciodadAdulto(int capaciodadAdulto) {
		this.capaciodadAdulto = capaciodadAdulto;
	}
	public Boolean getBalcon() {
		return balcon;
	}
	public Boolean getCocina() {
		return cocina;
	}
	public Boolean getVista() {
		return vista;
	}
	public float getPrecioI() {
		return precioI;
	}
	public void setPrecioI(float precioI) {
		this.precioI = precioI;
	}
	public float getPrecioF() {
		return precioF;
	}
	public ArrayList<ConsumoHab> getConsumos(){
		return consumosHab;
	}
	public ArrayList<Reserva> getReservas(){
		return reservas;
	}

	public float calcularPrecioIntermedio(int capacidadNino, int capaciodadAdulto, Boolean balcon, Boolean cocina,
	Boolean vista, float precioI){

		float intermedio = precioI;
		if (capacidadNino >2){
			intermedio = (float) (intermedio + precioI*0.05);
		}
		if(capaciodadAdulto > 2){
			intermedio = (float) (intermedio + precioI*0.05);
		}
		if(balcon){
			intermedio = (float) (intermedio + precioI*0.05);
		}
		if(cocina){
			intermedio = (float) (intermedio + precioI*0.05);
		}
		if(vista){
			intermedio = (float) (intermedio + precioI*0.05);
		}
		return intermedio;
	}

	public int dayofWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public float calcularPrecioTotal(float precioIntermedio, Date inicialDate, Date finalDate){
		float aumento = 0;
		if(dayofWeek(inicialDate)==6 && dayofWeek(finalDate)==7){
			precioIntermedio = (float) (precioIntermedio*1.05);
		}
		else{
			float aumento1 = 0;
			float aumento2 = 0;
			for(Temporada t: temporadas) {
				Date fechaInicio = t.getFechaIn();
				Date fechaFinal = t.getFechaFin();
				if(inicialDate.after(fechaInicio) && inicialDate.before(fechaFinal)){
					aumento1 = t.getAumento();
				}
				if(finalDate.after(fechaInicio) && inicialDate.before(fechaFinal)){
					aumento2=t.getAumento();
				}
	
			}
	
			if(aumento1 > aumento2){
				aumento = aumento2;
	
			}else{
				aumento = aumento1;
			}
			
		}
		return precioIntermedio + aumento;
	}

	public void eliminarConsumos(){
		for(ConsumoHab ch: consumosHab){
			consumosHab.remove(ch);
		}
	}

	public String getTipo() {
		return tipo;
	}
}
