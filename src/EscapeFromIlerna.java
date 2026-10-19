import java.util.Scanner;

public class EscapeFromIlerna {

	public static void main(String[] args) {

		int ele = 0;
		int vidas = 3;
		boolean jugando = true;

		///////// COLORES Y COMBINACIONES
		String cr = "\u001B[31m"; // rojo
		String cg = "\u001B[32m"; // verde
		String cy = "\u001B[33m"; // amarillo
		String ca = "\u001B[34m"; // azul
		String re = "\u001B[0m"; // reset (predeterminado)
		String bk = "\u001B[1m"; // negrita
		String sb = "\u001B[4m"; // subrayado
		String cv = "\u001B[3m"; // cursiva
		String oc = "\u001B[8m"; // texto oculto
		String tc = "\u001B[9m"; // tachado
		///////////////////////////////////////////

		////////// INTRO ////////////
		Scanner scan = new Scanner(System.in);
		
		System.out.println(cy + bk + "|| ESCAPA DE ILERNA ||" + re);
		System.out.println();
		System.out.println("Introduce tu nombre: ");
		String user = scan.nextLine();
		System.out.println();
		System.out.println(
				"Bienvenido, " + user + ". Es viernes, son las 19:50 y tu turno en el trabajo empieza a las 20:00. ");
		System.out.println(
				"Pero estás en clase de Bases de Dades y la profesora ha decidido repasar SQL “cinco minutitos más”. ");
		System.out.println("Tu misión: salir del aula antes de que sea demasiado tarde. En cada prueba tendrás " + cg
				+ "3 intentos. " + re + "Si los gastas todos, tu jefe te despedirá.");
		System.out.println();
		///////////////////////

		System.out.println(cy + bk + "| INICIO |" + re);
		System.out.println();
		System.out.println(bk + "La puerta está justo delante ¿Qué haces?" + re);
		System.out.println(" 1. Intentas escabullirte cuando la profe mira la pizarra");
		System.out.println(" 2. Levantas la mano y pides permiso para ir al baño");
		System.out.println(" 3. Abres la ventana y saltas ");

		if (scan.hasNextInt()) { // es un numero entero?
			ele = scan.nextInt(); // si sí, léelo
			scan.nextLine();
		} else {
			scan.nextLine(); // si no, lee y tira la línea
		}

		///////// NIVEL 0

		if (ele == 1) {
			System.out.println(
					"La puerta estaba cerrada con llave y la manilla hace ruido. La profe se gira y dice: ¡Siéntate, "
							+ user + "!" + cr + " FIN DEL JUEGO." + re);
			jugando = false;
		} else if (ele == 2) { // CORRECTA
			System.out.println(
					"La profe dice: Vale, pero la puerta está bloqueada con el panel de seguridad. Primero tendrás que resolver un ejercicio en SQL.");

			System.out.println();
			System.out.println(cy + bk + "| NIVEL 1 |" + re);
			System.out.println();
			System.out.println("La profe te dio una tabla llamada " + sb + "PUERTAS" + re + " con los siguientes datos:");
			System.out.println();
			System.out.println(bk + "id | aula | estado  | codigo" + re);
			System.out.println("1  | B1   | cerrada | 1200");
			System.out.println("2  | B3   | abierta | 700");
			System.out.println("3  | B3   | cerrada | 1550");
			System.out.println("4  | B2   | cerrada | 900");
			System.out.println("5  | B3   | cerrada | 2000");
			System.out.println();
			System.out.println(bk + "SELECT SUM(codigo)");
			System.out.println("FROM puertas");
			System.out.println("WHERE aula = 'B3' AND estado = 'cerrada';" + re);
			System.out.println();
			System.out.println("El panel pide el resultado de la consulta para abrirse. Introduce el código:");

		} else if (ele == 3) {
			jugando = false;
			System.out.println(
					"Estás en el tercer piso. Aterrizas rompiéndote una pierna y sin trabajo. ¿Se considera accidente laboral? "
							+ cr + "FIN DEL JUEGO." + re);
		} else {
			System.out.println(
					"Te quedas dudando tanto que suena el timbre... y sigues dentro. " + cr + " FIN DEL JUEGO." + re);
			jugando = false;
		}

		//////// NIVEL 1
		

		boolean acertado = true;
		int codigo = 3550;
		
		while (jugando && acertado && vidas > 0) {

			ele = 0;
			
			if (scan.hasNextInt()) {
				ele = scan.nextInt();
				scan.nextLine();
			} else {
				scan.nextLine();
			}
			

			if (ele == codigo) {
				System.out.println(cg + "Has acertado!" + re + " La puerta se abre, pero el pasillo acaba en otra puerta con una cerradura digital...");
				acertado = false;
				System.out.println();
				System.out.println(cy + bk + "| NIVEL 2 |" + re);
				System.out.println();
				System.out.println("La cerradura de la salida tiene grabado un programa, averigua cómo encontrarla... ");
				System.out.println();
				System.out.println(oc + bk + "int n = 1                     ");
				System.out.println("for (int i = 1; i <= 4; i++) {");
				System.out.println("    n = n * 2;                ");
				System.out.println("}                             ");
				System.out.println(re);
				System.out.println("Para abrir, introduce el valor final de n:");
				
				
			} else if (ele == 4250) {
				System.out.println("¡Ups te has equivocado! pista: fijate en el 'AND' ");
				vidas = vidas - 1;
				System.out.println(cr + "Te quedan " + vidas + " intentos!" + re);
				System.out.println("Vuelve a intentarlo:");
			} else {
				System.out.println("¡Ups, te has equivocado!");
				vidas = vidas - 1;
				System.out.println(cr + "Te quedan " + vidas + " intentos!" + re);
				System.out.println("Vuelve a intentarlo:");
			}
		}
		if (jugando && acertado && vidas == 0) {
			System.out.println("Te quedaste sin intentos! La profesora está decepcionada " + cr + "FIN DEL JUEGO" + re);
			jugando = false;

		}
		
		/////// NIVEL 2
		
		vidas = 3;
		
		while (jugando && !acertado && vidas > 0) {
			
			ele = 0;
			
			if (scan.hasNextInt()) {
				ele = scan.nextInt();
				scan.nextLine();
			} else {
				scan.nextLine();
			}
			
			if (ele == 16) {
				System.out.println(cg + "¡Has acertado!" + re);

				jugando = false;
			} else {
				System.out.println("¡Ups, te has equivocado!");
				vidas = vidas - 1;
				System.out.println(cr + "Te quedan " + vidas + " intentos!" + re);
				System.out.println("Vuelve a intentarlo:");
			}
			if (jugando && !acertado && vidas == 0) {
				System.out.println("Te quedaste sin intentos! La profesora está decepcionada " + cr + "FIN DEL JUEGO" + re);
				jugando = false;
			}
		}
		
	}
}
