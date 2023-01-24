package jdbc.modelo;

import java.sql.Date;

//MODELIZACIÓN
public class Huespedes {
	
//	ATRIBUTOS
//	NO ES NECESARIO QUE SE LLAMEN EXACTAMENTE COMO LOS CAMPOS DE SQL
	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer IdReserva;
	
//	CONSTRUCTOR
	public Huespedes(String nombre, String apellido,  Date fechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		IdReserva = idReserva;
	}
	
//	CONSTRUCTOR
	public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		IdReserva = idReserva;
	}

	
//	GETTERS Y SETTERS

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Integer getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(Integer idReserva) {
		IdReserva = idReserva;
	}
	
}
