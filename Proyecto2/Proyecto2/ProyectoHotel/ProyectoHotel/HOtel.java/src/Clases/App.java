package Clases;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class App {
    
	public static Hotel hotel;
	
	//public static Frame frame;
	
	public App() {
		hotel = new Hotel();
	}

    public static boolean seleccionarUsuario(String login, String contraseña, int usuario){
    	boolean respuesta = hotel.seleccionarUsuario(login, contraseña, usuario);
    	return respuesta;
    }
    
    public String[] disponible(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, int canNinos, int canAdultos) {
    	String[] respuesta = hotel.reservaDisponible(inicialAnio, inicialMes, inicialDia, finalAnio, finalMes, finalDia, canNinos, canAdultos);
    	return respuesta;
    }
    
    public Grupo newGrupo(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion) {
   	 Grupo grupo = hotel.newGrupo(inicialAnio, inicialMes, inicialDia, finalAnio, finalMes, finalDia, IDHabitacion);
   	 return grupo;
    }
    
    public void agregarHuespedGrupo(Grupo grupo, String nombre, int cedula, int edad, String correo){
    	hotel.agregarHuespedGrupo(grupo, nombre, cedula, edad, correo);
    }
    
    public void crearReserva(Grupo grupo, int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion) {
    	hotel.crearReserva(grupo, inicialAnio, inicialMes, inicialDia, finalAnio, finalMes, finalDia, IDHabitacion);
    }
    
    public void cancelarReserva(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion) {
    	hotel.cancelarReserva(inicialAnio, inicialMes, inicialDia, finalAnio, finalMes, finalDia, IDHabitacion);
    }
    
    public String checkOut(String IDHabitacion) {
    	String respuesta = hotel.checkOut(IDHabitacion);
    	return respuesta;
    }
    
    public String consultarInventario(int opcion, String producto) {
    	String respuesta = hotel.consultarInventario(opcion, producto);
    	return respuesta;
    }
    public String consultarHabitacion(int opcion, String IDHabitacion, int inicialAnio, int inicialMes, int inicialDia) {
    	String respuesta = hotel.consultarHabitacion(opcion, IDHabitacion, inicialAnio, inicialMes, inicialDia);
    	return respuesta;
    }

    
    public ArrayList<Integer> listaFechas(){
    	return hotel.listaFechas();
    }
    

	public String[] agregarConsumo(String habitacion, String servicio, int tipo){
		String [] resultado = hotel.agregarConsumo(habitacion, servicio, tipo);
		return resultado;
	}
	
	public void cargarHotel(String habitaciones, String inventario, String servicio, String restaurante, String temporada){
		try {
			hotel.cargarHotel(habitaciones, inventario, servicio, restaurante, temporada);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void cargarHabitacionesManual(String idHabitacion,String tipo,String ubicacion, int capacidadNino, int capaciodadAdulto, Boolean balcon, Boolean cocina, Boolean vista, float PrecioI){
		hotel.cargarHabitacionesManual(idHabitacion, tipo, ubicacion, capacidadNino, capaciodadAdulto, balcon, cocina, vista, PrecioI);
	}
    public void cargarServiciosManual(String tipo, String nombre, float precio, String horaInicio, String horaFinal){
		hotel.cargarServiciosManual(tipo, nombre, precio, horaInicio, horaFinal);
	}

    
    public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
    

	public static void serializarObjeto(Hotel hotel) {
        try (FileOutputStream fos = new FileOutputStream("hotel.bin");
                ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static Hotel deserializarObjeto(Class<Hotel> claseObjetivo) {
        Hotel objeto = null;
        try (FileInputStream fis = new FileInputStream("hotel.bin");
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
            objeto = (Hotel) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }



/* 
    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
		
		Hotel h1 = deserializarObjeto(Hotel.class);

		if (h1 != null){
		hotel = h1;
		}
		else {

		Hotel hotel1 = new Hotel();
		hotel = hotel1;
		}
		
    	
		serializarObjeto(hotel);
		
	}	
*/
	
}
