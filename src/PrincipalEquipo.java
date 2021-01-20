
public class PrincipalEquipo {

	public static void main(String[] args) {

		crearPartidos();

	}
	
/***
 * Método para crear los objetos
 * 
 */
	public static void crearPartidos() {
		boolean hayError;
		
		Equipo betis = new Equipo("BETIS", "Benito Villamarin", "SEVILLA");
		Equipo sevilla = new Equipo("SEVILLA", "Sánchez Pijuán", "SEVILLA");

		try {
			Partido partido1 = new Partido(2, betis, sevilla);
			partido1.ponerResultado("1-2");
			System.out.println(partido1);
		} catch (PartidoException e) {
			e.printStackTrace();
		}

		do {
			try {
				Partido partido2 = new Partido(3, betis, sevilla);
				partido2.ponerResultado("0-0");
				System.out.println(partido2);
				Partido partido3 = new Partido(4, betis, sevilla);
				partido3.ponerResultado("1-2");
				System.out.println(partido3);
				hayError = false;
			} catch (PartidoException e) {
				e.printStackTrace();
				hayError = true;
			}
		} while (hayError == true);


	}

}
