package factory;

public class ValorReserva {
	private static final Long VALOR_RESERVA = 8000L;
	
	public static Long getValor(Long Fecha_Salida, Long Fecha_Entrada) {
		long diferenciaEnMilisegundos = Fecha_Salida - Fecha_Entrada;
    	long diferenciaEnDias = (diferenciaEnMilisegundos <= 0) ? 1 : (diferenciaEnMilisegundos / (24 * 60 * 60 * 1000)) + 1;
    	return diferenciaEnDias * VALOR_RESERVA;
	}

}
