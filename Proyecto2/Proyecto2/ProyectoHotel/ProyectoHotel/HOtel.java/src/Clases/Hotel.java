package Clases;
import java.util.Date;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;



public class Hotel implements Serializable{
	

	private ArrayList<Grupo> grupos;
    private ArrayList<Servicio> servicios;
    private ArrayList<ConsumoHot> consumosHotel;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Inventario> inventarios;
    private ArrayList<MenuRestaurante> productos;
 
    
  //public static Frame frame;

    public Hotel(){
    	this.grupos = new ArrayList<Grupo>();
    	this.servicios = new ArrayList<Servicio>();
    	this.consumosHotel = new ArrayList<ConsumoHot>();
    	this.habitaciones = new ArrayList<Habitacion>();
    	this.inventarios = new ArrayList<Inventario>();
    	
    }

    public boolean seleccionarUsuario(String login, String contraseña, int usuario){
		String direccion = "";
		boolean result = false;
		try{
			
			if (usuario == 1){
				direccion = "ProyectoHotel/ProyectoHotel/HOtel.java/data/admins.txt";
			}
			else if (usuario == 2){
				direccion = "ProyectoHotel/ProyectoHotel/HOtel.java/data/recepcionistas.txt";
			}
			else if (usuario == 3){
				direccion = "ProyectoHotel/ProyectoHotel/HOtel.java/data/empleado.txt";
			}
			FileReader fileReader = new FileReader(direccion);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(login) && parts[1].equals(contraseña)) {
                    result = true;
                    break;
				}
			}
            
			bufferedReader.close();
		}
		catch (Exception e) {
			System.out.println("error al leer el archivo " + direccion);
		}
		return result;
    }

    public String [] agregarConsumo(String IDHabitacion, String servicio, int menu_o_servicio){
    	int valor=0;
    	//String IDHabitacion = frame.getIDHabitacion();
    	//String servicio = frame.getServicio();
    	// int menu_o_servicio = frame.getTipo();
    	//String IDHabitacion = input("Ingrese la habitacion");
    	//String servicio = input("Ingrese el servicio consumido");
    	//int menu_o_servicio = Integer.parseInt(input("Ingrese 1 si su servicio es de ¨Menu Restaurante¨, de lo contrario ingrese 2 si su servicio es de otra clase"));
    	
    	
    	
        String [] resultado = factura(IDHabitacion, servicio, menu_o_servicio);
        for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre.equals(IDHabitacion)) {
				h.agregarConsumo(IDHabitacion, servicio);
				break;
			}
    	}
        for(Inventario i:inventarios){
            if(servicio.equals(i.getProducto())){
                valor=i.getCantidad()-1;
                i.setCantidad(valor);
                ConsumoHot servicio1=new ConsumoHot(IDHabitacion, "consumo",servicio);
                consumosHotel.add(servicio1);
                if(i.getCantidad()==0){
                    inventarios.remove(i);
                }
                break;
            }
        }
    	return resultado;
    	
    }
    public void agregarPago(){
    	int valor=0;
    	//String IDHabitacion = frame.getIDHabitacion;
    	//String servicio = frame.getServicio;
    	//String menu_o_servicio = frame.getTipo;
    	
    	String IDHabitacion = input("Ingrese la habitacion");
    	String servicio = input("Ingrese el servcio consumido");
        int menu_o_servicio = Integer.parseInt(input("Ingrese 1 si su servicio es de ¨Menu Restaurante¨, de lo contrario ingrese 2 si su servicio es de otra clase"));
    	
        factura(IDHabitacion, servicio, menu_o_servicio);
    	for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre.equals(IDHabitacion)) {
				h.agregarPago(IDHabitacion, servicio);
				break;
			}
    	}
        for(Inventario i:inventarios){
            if(servicio.equals(i.getProducto())){
                valor=i.getCantidad()-1;
                i.setCantidad(valor);
                ConsumoHot servicio1=new ConsumoHot(IDHabitacion, "pago",servicio);
                consumosHotel.add(servicio1);
                if(i.getCantidad()==0){
                    inventarios.remove(i);
                break;
                }
            }
        }
    }
    
    public String[] factura(String IDHabitacion, String servicio, int menu_o_servicio) {
        
		float valor=0;
		/*
    	System.out.println("Gracias por su compra");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Detalles de compra:\n");
        System.out.println("Habitacion........................................"+IDHabitacion+"\n");
        System.out.println("Servicio..........................................Valor");*/
        if(menu_o_servicio==1){
            for(MenuRestaurante m: productos){
                if(servicio.equals(m.getNombre())){
                    valor = m.getPrecio();
                }
            }
        }else if(menu_o_servicio==2){
            for(Servicio s: servicios){
                if(servicio.equals(s.getNombre())){
                    valor = s.getPrecio();
                }
            }
        }
        String valors = Float.toString(valor);
        //System.out.println(servicio+".........................................."+valors);
        //System.out.println("Proceso exitoso");
		String[] resultado = {valors, IDHabitacion};
		return resultado;
    }

	public String consultarHabitacion(int opcion, String IDHabitacion, int inicialAnio, int inicialMes, int inicialDia){
		
		String resultado = "No se encontro la habitacion";    	

		if (opcion == 1){
			for(Grupo g: grupos) {
				String nombre = g.getIDHabitacion();
				if (nombre.equals(IDHabitacion)) {

					Date reservaInicio = g.getReservaInicio();
					Date reservaFinal = g.getReservaFinal();

			        @SuppressWarnings("deprecation")
					Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);

			        if ((reservaInicio.before(inicialDate)) && (reservaFinal.after(inicialDate))) {
			        	ArrayList<String> nombresList = g.getNombresHuespedes();
						resultado = "Los huespeds que ocupan esta habitacion en esta fecha son:\n";
			        	for(String s: nombresList) {
			        		resultado += "\n" + s ;
			        	}
			        }
			        
				}
			}
		}

		else if (opcion == 2){
			for (Habitacion h:habitaciones) {
				String nombre = h.getIdHabitacion();
				if (nombre.equals(IDHabitacion)) {
					resultado = "Esta es la informacion de la habitacion: ";
					resultado += "\nUbicacion-----------------------------" + h.getUbicacion();
					resultado += "\nTipo----------------------------------" + h.getTipo();
					resultado += "\nCapacidad Niños-----------------------" + h.getCapacidadNino();
					resultado += "\nCapacidad Adultos---------------------" + h.getCapaciodadAdulto();
					resultado += "\nBalcon--------------------------------" + h.getBalcon();
					resultado += "\nCocina--------------------------------" + h.getCocina();
					resultado += "\nVista---------------------------------" + h.getVista();
					resultado += "\nPrecio--------------------------------" + h.getPrecioF();
				}	
			}
		}

		return resultado;

	}

	public String consultarInventario(int opcion, String producto){

		String resultado =  "";
    	

    	if (opcion == 1) {
    		
    		resultado += "\nEl inventario es el siguiente:\n"
    				+"\nProducto-------------cantidad\\n";

    		for (Inventario i: inventarios) {
    			String nombre = i.getProducto();
    			int cantidad = i.getCantidad();
    			resultado += nombre+"-------------"+cantidad;
    		}

    	}

    	else if (opcion == 2) {
    		for (Inventario i: inventarios) {
    			String nombre = i.getProducto();
    			if (nombre.equals(producto)) {
    				int cantidad = i.getCantidad();
    				resultado += "La cantidad de su producto es: "+cantidad;
    			}
    		}
    	}
    	return resultado;

	}
	
	public Grupo newGrupo(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion){
		@SuppressWarnings("deprecation")
		Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
        @SuppressWarnings("deprecation")
		Date finalDate = new Date(finalAnio, finalMes, finalDia);
    	
    	Grupo grupo = new Grupo(IDHabitacion, inicialDate, finalDate);
    	
    	return grupo;
	}
	
    public void crearReserva(Grupo grupo, int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion ){
    	
    	@SuppressWarnings("deprecation")
		Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
        @SuppressWarnings("deprecation")
		Date finalDate = new Date(finalAnio, finalMes, finalDia);
    	
    	
        grupos.add(grupo);
        agregarReserva(grupo, inicialDate, finalDate, IDHabitacion);
	        
        
    }

    public String[] reservaDisponible(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, int canNinos, int canAdultos){
		
    	String precioFinal = "";
    	
        @SuppressWarnings("deprecation")
		Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
        @SuppressWarnings("deprecation")
		Date finalDate = new Date(finalAnio, finalMes, finalDia);
    	
    	String respuesta = "no";
    	
        for (Habitacion h: habitaciones) {
			int maxNinos = h.getCapacidadNino();
			int maxAdultos = h.getCapaciodadAdulto();
			boolean disponible = h.disponibleEnFecha(inicialDate, finalDate);
			
			if (disponible && maxNinos >= canNinos && maxAdultos >= canAdultos) {
				respuesta = h.getIdHabitacion();
				float precioIntermedio = h.getPrecioF();
				precioFinal = Float.toString(h.calcularPrecioTotal(precioIntermedio, inicialDate, finalDate));
				break;
			}
		}
        
        String[] resultado = {respuesta, precioFinal};
        return resultado;
        
    }

    public void agregarHuespedGrupo(Grupo grupo, String nombre, int cedula, int edad, String correo){
    	
		grupo.addHuesped(nombre, cedula, edad, correo);
		
    }

    private void agregarReserva(Grupo grupo, Date inicialDate, Date finalDate, String IDHabitacion){
    	
    	for (Habitacion h: habitaciones) {
    		String nomHabitacion = h.getIdHabitacion();
    		if (IDHabitacion.equals(nomHabitacion)) {
    			h.addGrupo(grupo);
    			h.addReserva(inicialDate, finalDate);
    		}
    	}
    	
    }

    public void cancelarReserva(int inicialAnio, int inicialMes, int inicialDia, int finalAnio, int finalMes, int finalDia, String IDHabitacion){
    	
    	boolean verdad = Boolean.parseBoolean(input("Ingrese true si su reserva se hizo hace mas de 48 horas, si no ingrese false"));
    	if (verdad) {
    		
            @SuppressWarnings("deprecation")
    		Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
            @SuppressWarnings("deprecation")
    		Date finalDate = new Date(finalAnio, finalMes, finalDia);
            
            for (Habitacion h: habitaciones) {
            	String nombre = h.getIdHabitacion();
            	if (nombre.equals(IDHabitacion)) {
            		h.delreserva(inicialDate, finalDate);
            	}
            }
            
            for (Grupo g: grupos) {
            	String nombre2 = g.getIDHabitacion();
            	Date dateInicio = g.getReservaInicio();
    			Date dateFinal = g.getReservaFinal();;
    			if ((nombre2.equals(IDHabitacion))&&(dateInicio.equals(inicialDate)) && (dateFinal.equals(finalDate))) {
    				grupos.remove(g);
    			}
            }
    	}
    
    }

    public String checkOut(String id){
        float valor =0;
        float valorFinal = 0;
        
        
        String respuesta = "Hubo un error";
        
        for(Habitacion h: habitaciones){
            if(id.equals(h.getIdHabitacion())){
            	respuesta = "Gracias por su estadía\n"
                		+ "----------------------------------------------\n"
                		+ "Servicio.....................................Valor\n";
                for(ConsumoHab ch: h.getConsumos()){
                    for(Servicio s: servicios){
                        if(ch.getServicio().equals(s.getNombre())){
                            valor=s.getPrecio();
                            valorFinal += valor;
                            String valors=Float.toString(valor);
                            respuesta += ch+".........................................."+valors + "\n\n";
                            break;
                        }
                    }
                    respuesta += "TOTAL.........................................."+valorFinal;
                    h.getConsumos().remove(ch);
                    
                }
                
                break;
            }
        }
        return respuesta;

    }


    public ArrayList<Integer> listaFechas(){
    	ArrayList<Integer> lista = new ArrayList<>();
    	
    	for (Habitacion h: habitaciones) {
    		ArrayList<Reserva> reservas = h.getReservas();
    		for (Reserva r: reservas) {
    			Date inicioD = r.getFechaFin();
    			Date finalD = r.getFechaFin();
    			
    			Calendar calendar = Calendar.getInstance();
    			calendar.setTime(inicioD);
    			int valor1 = calendar.get(Calendar.DAY_OF_YEAR);
    			calendar.setTime(finalD);
    			int valor2 = calendar.get(Calendar.DAY_OF_YEAR);
    			
    			for (int i = valor1; i <= valor2; i++) {
    			    lista.add(i);
    			}
    			
    			
    		}
    	}
    	return lista;
    }
    

    public void cargarHotel(String habitaciones, String inventario, String servicio, String restaurante, String temporada) throws IOException{


    	
    	cargarHabitacion(habitaciones);
    	cargarInventario(inventario);
    	cargarServicio(servicio);
    	cargarRestaurante(restaurante);
    	cargarTemporada(temporada);
		
    	
    }

    public void cargarHabitacionesManual(String idHabitacion,String tipo,String ubicacion, int capacidadNino, int capaciodadAdulto, Boolean balcon, Boolean cocina, Boolean vista, float PrecioI){
	
			//String idHabitacion = frame.getIDHabitacion();
			//String tipo = frame.getTipo();
			//String ubicacion = frame.getHubicacion();
			//String capacidadNino = frame.getcapacidadNino();
			//String capaciodadAdulto = frame.getCapaciodadAdulto();
			//String balcon = frame.getBalcon();
			//String cocina = frame.getCocina();
			//String vista = frame.getVista();
			//String PrecioI = frame.getPrecioI();
			//String ubicacion = input("Ingrese la ubicacion de la habitacion");
			//int capacidadNino = Integer.parseInt(input("Ingrese la cantidad maxima de niños de la habitacion"));
			//int capaciodadAdulto = Integer.parseInt(input("Ingrese la cantidad maxima de adultos de la habitacion"));
			//Boolean balcon = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Balcon, si no ingrese false"));
			//Boolean cocina = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Cocina, si no ingrese false"));
			//Boolean vista = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Vista, si no ingrese false"));
			//float PrecioI = Float.parseFloat(input("Ingrese el precio base de la habitacion"));

			if (tipo.equals("Standar")) {
				Standard habitacion = new Standard(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);

			}
			else if (tipo.equals("Suite")) {
				Suite habitacion = new Suite(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);

			}
			else if (tipo.equals("SuitDoble")) {				
				SuitDoble habitacion = new SuitDoble(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
			}
	}

		
			
	public void cargarServiciosManual(String tipo, String nombre, float precio, String horaInicio, String horaFinal){		
			//String tipo = frame.getTipo();
			//String nombre = frame.getNombre();
			//String precio = frame.getPrecio);
			//String horaInicio = frame.getHoraInicio();
			//String horaFinal = frame.getHoraFinal();
			
			//String tipo = input("Ingrese si es menu del comedor o del servicio a la habitacion");
			//String nombre = input("Ingrese el nombre del producto");
			//float precio = Float.parseFloat(input("Ingrese el precio base del producto"));
			//String horaInicio = input("Ingrese el la hora de inicio de disponibilidad del producto");
			//String horaFinal = input("Ingrese el la hora final de disponibilidad del producto");


			if (tipo.equals("Comedor")) {
				Comedor producto = new Comedor(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);

			}
			if (tipo.equals("ServicioHabitacion")) {
				ServicioHab producto = new ServicioHab(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);
			}

		}
	

    public void actualizarInformacion(){

		String respuesta = "Hubo un error";
		boolean aceptado = false;
		System.out.println("Ingrese la opcion que quiere actualizar");
		System.out.println("1- Actualizar informaicon habitaciones");
		System.out.println("2- Actualizar informaicon tarifas en temporadas");
		System.out.println("3- Actualizar informaicon servicios");
		System.out.println("4- Actualizar informaicon productos de los menú");
		int opcion = Integer.parseInt(input(""));

		if (opcion == 1) {
			System.out.println("\nIngrese la opcion que quiere actualizar");
			System.out.println("1- Actualizar capacidad maxima de niños");
			System.out.println("2- Actualizar capacidad maxima de adultos");
			System.out.println("3- Actualizar precio por tipo de habitacion");
			int eleccion = Integer.parseInt(input(""));
			
			if (eleccion == 3) {
				//String tipo = frame.getTipo();
				//float cambio = frame.getCambio();
				String tipo = input("\nIngrese el tipo de la habitacion");
				float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));
				for(Habitacion h: habitaciones) {
					String tipo2 = h.getTipo();
					if (tipo.equals(tipo2)) {
						h.setPrecioI(cambio);
						aceptado = true;
					}
				}
			}

			else {
				//String IDHabitacion = frame.getIDHabitacion();
				
				String IDHabitacion = input("\nIngrese el ID de la habitacion");
				for(Habitacion h: habitaciones) {
					String nombre = h.getIdHabitacion();
					if (nombre.equals(IDHabitacion)) {
						if (eleccion == 1) {
							//int cambio = frame.getCambio();
							int cambio = Integer.parseInt(input("Ingrese la nueva cantidad"));
							h.setCapacidadNino(cambio);
						}
						if (eleccion == 2) {
							//int cambio = frame.getCambio();
							int cambio = Integer.parseInt(input("Ingrese la nueva cantidad"));
							h.setCapaciodadAdulto(cambio);
						}
						aceptado = true;
						break;
					}

				}
			}
		}

		else if (opcion == 2) {
			//String IDHabitacion = frame.getHabitacion();
			String tipo = input("\nIngrese el tipo de la habitacion");
			for(Habitacion h: habitaciones) {
				String tipo2 = h.getTipo();
				if (tipo.equals(tipo2)) {

					//int inicialanio = frame.getIniclaAnio();
					//int inicialMes = frame.getInicialMes();
					//int inicialDia = frame.getInicialDia();
					//int finalAnio = frame.getfinalAnio();
					//int finalMes = frame.finalMes();
					//int finalDia = frame.getFinalDia();
					int inicialAnio = Integer.parseInt(input("Ingrese el año del dia de inicio de la temporada"));
					int inicialMes = Integer.parseInt(input("Ingrese el mes de día del inicio de la temporada"));
					int inicialDia = Integer.parseInt(input("Ingrese el día del inicio de la temporada"));
					int finalAnio = Integer.parseInt(input("Ingrese el año del dia del final de la temporada"));
					int finalMes = Integer.parseInt(input("Ingrese el mes de día del final de la temporada"));
					int finalDia = Integer.parseInt(input("Ingrese el día del final de la temporada"));

					float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));

					@SuppressWarnings("deprecation")
					Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
					@SuppressWarnings("deprecation")
					Date finalDate = new Date(finalAnio, finalMes, finalDia);

					h.setPrecioTemporada(inicialDate, finalDate, cambio);
					aceptado = true;
				}
			}
		}

		else if (opcion == 3) {
			//string servicio = frame.getServicio();
			String servicio = input("Ingrese el servicio que quiere actualizar");
			for (Servicio s: servicios) {
				String servicio2 = s.getNombre();
				if (servicio.equals(servicio2)) {
					//float cambio = frame.getCambio();
					float cambio = Float.parseFloat(input("Ingrese el nuevo precio del servicio"));
					s.setPrecio(cambio);
					aceptado = true;
					break;
				}
			}
		}

		else if (opcion == 4) {
			
			//string tipo = frame.getTipo();
			String tipo = input("Ingrese el tipo de menú de su producto al que quiere modificar (ServicioHabitacion o Comedor)");

			for(MenuRestaurante r: productos) {
				String tipo2 = r.getTipo();
				if (tipo.equals(tipo2)) {
					System.out.println("\nIngrese la opcion que quiere actualizar");
					System.out.println("1- Actualizar precio del producto");
					System.out.println("2- Actualizar hora de inicio de disponibilidad del producto");
					System.out.println("3- Actualizar hora del final de la disponibilidad del producto");
					int eleccion = Integer.parseInt(input(""));
					//int cambio = frame.getCambio();

					if (eleccion == 1) {
						float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));
						r.setPrecio(cambio);
					}
					else if (eleccion == 2) {
						String cambio = input("Ingrese la nueva hora");
						r.setHoraInicio(cambio);
					}
					else if (eleccion == 2) {
						String cambio = input("Ingrese la nueva hora");
						r.setHoraFinal(cambio);
					}
					aceptado = true;
					break;
				}
			}

		}


		if (aceptado) {
			System.out.println(respuesta);
		}
		else {
			System.out.println("Hubo un error, no se pudo hacer el cambio");
		}

	}

    

    private void cargarHabitacion(String rutHabitaciones) throws IOException{
    	
    	File archivo = new File(rutHabitaciones);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String idHabitacion = datos[0];
			String tipo = datos[1];
			String ubicacion = datos[2];
			int capacidadNino = Integer.parseInt(datos[3]);
			int capaciodadAdulto = Integer.parseInt(datos[4]);
			Boolean balcon = Boolean.parseBoolean(datos[5]);
			Boolean cocina = Boolean.parseBoolean(datos[6]);
			Boolean vista = Boolean.parseBoolean(datos[7]);
			float PrecioI = Float.parseFloat(datos[8]);
			
			if (tipo.equals("Standar")) {
				Standard habitacion = new Standard(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo.equals("Suite")) {
				Suite habitacion = new Suite(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo.equals("SuitDoble")) {				SuitDoble habitacion = new SuitDoble(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
			}
        }
		lector.close();
    }
    	

    private void cargarInventario(String inventario) throws IOException{
    	
    	File archivo = new File(inventario);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String producto = datos[0];
			int cantidad = Integer.parseInt(datos[1]);
			
			
			
			Inventario inventario1 = new Inventario(producto, cantidad);
			inventarios.add(inventario1);
			
			
			
			linea = lector.readLine();
		}
		lector.close();
    	
    }
    
    private void cargarServicio(String Servicio) throws IOException{
    	
    	File archivo = new File(Servicio);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String nombre = datos[0];
			String tipo = datos[1];
			int cantidad = Integer.parseInt(datos[2]);
			
			Servicio inventario1 = new Servicio(nombre, tipo, cantidad);
			servicios.add(inventario1);
			
			linea = lector.readLine();
		}
		lector.close();
    	
    	
    }
    

	private void cargarRestaurante(String rutRestaurante) throws IOException{

    	File archivo = new File(rutRestaurante);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");

			String tipo = datos[0];
			String nombre = datos[1];
			float precio = Float.parseFloat(datos[2]);
			String horaInicio = datos[3];
			String horaFinal = datos[4];


			if (tipo.equals("Comedor")) {
				Comedor producto = new Comedor(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);

			}
			if (tipo.equals("ServicioHabitacion")) {
				ServicioHab producto = new ServicioHab(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);
			}

			linea = lector.readLine();
		}
		lector.close();
	}
    private void cargarTemporada(String temporada) throws IOException {
    	
		File archivo = new File(temporada);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			String [] dateInicial = datos[0].split(":");
			int inicialAnio = Integer.parseInt(dateInicial[0]);
			int inicialMes = Integer.parseInt(dateInicial[1]);
			int inicialDia = Integer.parseInt(dateInicial[2]);
			String [] dateFinal = datos[1].split(":");
			int finalAnio = Integer.parseInt(dateFinal[0]);
			int finalMes = Integer.parseInt(dateFinal[1]);
			int finalDia = Integer.parseInt(dateFinal[2]);
			
			@SuppressWarnings("deprecation")
			Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
			@SuppressWarnings("deprecation")
			Date finalDate = new Date(finalAnio, finalMes, finalDia);

			float aumento = Float.parseFloat(datos[2]);
			
			for (Habitacion h: habitaciones){
				h.addTemporada(inicialDate, finalDate, aumento);
			}
			
			linea = lector.readLine();
		}
		lector.close();


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





}
