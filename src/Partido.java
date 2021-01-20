
public class Partido {

	private static final int MAX_JORNADA = 38;
	private static final int MIN_JORNADA = 1;
	private static final String SEPARADOR = "-";
	private Equipo equipoLocal;
	private Equipo equipoVisitante;

	private int jornada;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	private boolean jugado;

	// CONSTRUCTOR

	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {

		jugado = false;

		if (jornada < MIN_JORNADA || jornada > MAX_JORNADA) {
			throw new PartidoException("La jornada introducida es incorrecta");
		}
		if (equipoVisitante.equals(equipoLocal)) {
			throw new PartidoException("Los equipos no pueden ser iguales");
		}
		this.jornada=jornada;
		this.equipoLocal=equipoLocal; 
		this.equipoVisitante=equipoVisitante;

	}

	// METODOS GET

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public int getJornada() {
		return jornada;
	}

	public int getGolesLocal() throws PartidoException{
		if(!jugado) {
			throw new PartidoException("Partido no jugado");
		}
		return golesLocal;
	}

	public int getGolesVisitante() throws PartidoException {
		if(!jugado) {
			throw new PartidoException("Partido no jugado");
		}
		return golesVisitante;
	}

	public char getResultadoQuiniela() throws PartidoException{
		if(!jugado) {
			throw new PartidoException("Partido no jugado");
		}
		return resultadoQuiniela;
	}

	// METODO STRING

	public String toString() {
		String info;

		if (this.jugado == false) {

			info = "El partido entre el equipo local " + this.equipoLocal.getNombreEquipo() + " y el equipo visitante " + 
			this.equipoVisitante.getNombreEquipo()+ " todavía no se ha jugado";

		} else {

			info = "Partido entre equipo local " + this.equipoLocal.getNombreEquipo() + " y el equipo visitante "
					+ this.equipoVisitante.getNombreEquipo() + " jugado en el estadio " + this.equipoLocal.getNombreEstadio()
					+ " de la ciudad " + this.equipoLocal.getCiudad() + " ha finalizado con " + this.golesLocal
					+ " goles de equipo local y " + this.golesVisitante + " goles de equipo visitante. "
					+ "Resultado quiniela= " + this.resultadoQuiniela;
		}
		return info;
	}

	// METODOS VOID

	public void ponerResultado(String resultado) throws PartidoException {
		
		jugado=true;

		String[] parts = resultado.split(SEPARADOR);
		String golLocal = parts[0];
		String golVisitante = parts[1];

		if (parts.length < 2 || parts.length>2) {
			throw new PartidoException("Dato incorrecto");
		}
		golesLocal = Integer.valueOf(golLocal);
		golesVisitante = Integer.valueOf(golVisitante);

		if (golesLocal < 0 || golesVisitante < 0) {
			throw new PartidoException("No puede tener un resultado negativo");
		}

		if (golesLocal > golesVisitante) {
			resultadoQuiniela = '1';
			equipoLocal.incrementarPartidosGanados();

		} else {
			resultadoQuiniela = '2';
			equipoVisitante.incrementarPartidosGanados();

			if (golesVisitante == golesLocal) {
				resultadoQuiniela = 'X';
			}
		}
	}

}
