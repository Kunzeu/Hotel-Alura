package models;

import java.sql.Date;

public class Reserva {
	private int id;
	private Date FECHA_ENTRADA;
	private Date FECHA_SALIDA;
	private long valor;
	private String forma_Pago;
	
	public Reserva(Date FECHA_ENTRADA, Date FECHA_SALIDA, long valor, String forma_Pago) {
		this.FECHA_ENTRADA = FECHA_ENTRADA;
		this.FECHA_SALIDA = FECHA_SALIDA;
		this.valor = valor;
		this.forma_Pago = forma_Pago;
	}
	public Reserva(Integer id, Date FECHA_ENTRADA, Date FECHA_SALIDA, long valor, String forma_Pago) {
		this.id = id;
		this.FECHA_ENTRADA = FECHA_ENTRADA;
		this.FECHA_SALIDA = FECHA_SALIDA;
		this.valor = valor;
		this.forma_Pago = forma_Pago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFECHA_ENTRADA() {
		return FECHA_ENTRADA;
	}

	public void setFECHA_ENTRADA(Date FECHA_ENTRADA) {
		this.FECHA_ENTRADA = FECHA_ENTRADA;
	}

	public Date getFECHA_SALIDA() {
		return FECHA_SALIDA;
	}

	public void setFECHA_SALIDA(Date FECHA_SALIDA) {
		this.FECHA_SALIDA = FECHA_SALIDA;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getForma_Pago() {
		return forma_Pago;
	}

	public void setForma_Pago(String forma_Pago) {
		this.forma_Pago = forma_Pago;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", FECHA_ENTRADA=" + FECHA_ENTRADA + ", FECHA_SALIDA=" + FECHA_SALIDA + ", valor="
				+ valor + ", forma_Pago=" + forma_Pago + "]";
	}
	
	
	
	

}
