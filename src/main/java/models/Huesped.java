 package models;

import java.sql.Date;

public class Huesped {
	private int id;
	private String nombre;
	private String apellido;
	private Date FECHA_NACIMIENTO;
	private String nacionalidad;
	private Integer telefono;
	private Integer ID_RESERVA;
	
	//Constructor
	public Huesped(String nombre, String apellido, Date fECHA_NACIMIENTO, String nacionalidad, Integer telefono, Integer iD_RESERVA) {
		this.nombre = nombre;
		this.apellido = apellido;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		ID_RESERVA = iD_RESERVA;
	}
	public Huesped(Integer id, String nombre, String apellido, Date fECHA_NACIMIENTO, String nacionalidad, Integer telefono, Integer iD_RESERVA) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		ID_RESERVA = iD_RESERVA;
	}

	
	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}

	public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
		this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getID_RESERVA() {
		return ID_RESERVA;
	}

	public void setID_RESERVA(Integer iD_RESERVA) {
		ID_RESERVA = iD_RESERVA;
	}


	@Override
	public String toString() {
		return "Huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", FECHA_NACIMIENTO="
				+ FECHA_NACIMIENTO + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", ID_RESERVA="
				+ ID_RESERVA + "]";
    }
}