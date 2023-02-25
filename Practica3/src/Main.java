// Autor Alejandro Pulido Sánchez

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = null;
		String primera_entrada = "";
		String [] datos = null; 
		double [][] matriz = null;
		if(args.length>0) {							//Implementamos el codigo necesario para porder obtener los datos desde un txt.
			try {
				in = new Scanner(new File(args[0]));
				primera_entrada = in.nextLine();
				datos = primera_entrada.split(" "); //Utilizamos la función split para separar los datos introducidos
				matriz = new double [Integer.parseInt(datos[0])][Integer.parseInt(datos[1])];
			}catch(FileNotFoundException A){
				System.out.println("Archivo no encontrado.");
			}
		}else {
			System.out.println("Introduzca el número de alumnos que se va a evaluar y el número de preguntas del examen separados por un espacio: ");
			in = new Scanner(System.in);
			primera_entrada = in.nextLine();
			datos = primera_entrada.split(" "); //Utilizamos la función split para separar los datos introducidos
			matriz = new double [Integer.parseInt(datos[0])][Integer.parseInt(datos[1])];

		}

		for(int i =0;i<matriz.length;i++) {	//Bucle utilizado para obtener todos los datos de la matriz
			double nota = 0;
			System.out.println("Introduzca las notas de cada pregunta del alumno "+i+" separadas por un espacio: ");
			String entradas_alumno = in.nextLine();
			String [] notas = entradas_alumno.split(" ");
			for(int j =0;j<matriz[i].length;j++) {
				nota = nota + Double.parseDouble(notas[j]);
			}
			if (nota>10) {
				System.out.println("Nota superior a diez, debido al error toda la puntuacion del alumno "+ (i+1)+" será igual a cero.");
				for(int j =0;j<matriz[i].length;j++) {
					matriz[i][j]=0;
				}

			}else {
				for(int j =0;j<matriz[i].length;j++) {
					matriz[i][j]=Double.parseDouble(notas[j]);
				}
			}
		}
		//Imprime todos los rango de todas las preguntas
		for(int j =0;j<matriz[0].length;j++) {
			System.out.print("Rango de notas de la pregunta "+(j+1)+" : ");
			System.out.print(rango_notas(matriz,j)[0]);
			System.out.print("-");
			System.out.println(rango_notas(matriz,j)[1]);
		}
		//Imprime todas las medias de las preguntas
		System.out.println("");
		for(int j =0;j<matriz[0].length;j++) {
			System.out.print("La nota media de la pregunta número "+ (j+1) +" es: ");
			System.out.println(media_notas(matriz,j));
		}
		//Imprime todas las notas de los alumnos
		System.out.println("");
		for(int j =0;j<matriz.length;j++) {
			System.out.print("La nota obtenida por el alumno" + (j +1) + " en el examen sobre 10 ha sido: ");
			System.out.println(nota_alumno(matriz,j));
		}
		//Imprime la nota demia del examen
		System.out.println("");
		System.out.println("La nota media obtenida en el exmane es de: "+media_notas_alumnos(matriz)+" puntos");
		System.out.println("");
		System.out.print("Las tres mejores notas obtenidas en el examen han sido: ");
		for(int j =0;j<3;j++) { //Imprime las 3 mejores notas
			System.out.print(" " +mejores_notas(matriz)[j]+ ",");
		}
		System.out.println("");
		System.out.println("");
		//Imprime la desviación típica de cada alumno
		System.out.println("La desviacion tipica de los alumnos ha sido de "+desviacion_tipica(matriz));
	}
	//Devuelve un vector de 2 posiciones, en la primera se encuentra el menor número de una columna y en el segundo el mayor.
	public static double [] rango_notas(double [][] matriz, int pregunta) {
		double menor=10,mayor=0;
		double [] resultado = new double[2];
		for(int j =0;j<matriz.length;j++) {
			if(matriz[j][pregunta]<menor) {
				menor =matriz[j][pregunta];
			}
			if (matriz[j][pregunta]>mayor) {
				mayor = matriz[j][pregunta];
			}
		}
		resultado[0] = menor;
		resultado[1] = mayor;
		return resultado;
	}
	//Devuelve el double resultante de calcular la media de una pregunta(columna)
	public static double media_notas(double [][] matriz, int pregunta) {
		double resultado,suma = 0.0;
		for(int j =0;j<matriz.length;j++) {
			suma = suma + matriz[j][pregunta];
		}
		resultado =suma/matriz.length; 
		return resultado;
	}
	//Devuelve la nota obtenida por un alumno(fila)
	public static double nota_alumno(double [][] matriz, int alumno) {
		double resultado=0;
		for(int j =0;j<matriz[alumno].length;j++) {
			resultado = resultado + matriz[alumno][j];
		}
		return resultado;
	}
	//Devuelve el double resultante de calcular la media de notas de todos los examenes
	public static double media_notas_alumnos(double [][] matriz) {
		double suma = 0.0,resultado;
		for(int j =0;j<matriz.length;j++) {
			suma = suma +nota_alumno(matriz,j);
		}
		resultado =suma/matriz.length; 
		return resultado;
	}
	//Devuelve un vector con las tres mejores notas 
	public static double[] mejores_notas(double [][] matriz) {
		double nota1=0,nota2=0,nota3=0;
		double [] notas = new double [3];
		for(int j =0;j<matriz.length;j++) {
			if(nota_alumno(matriz,j)>nota1) {
				nota3=nota2;
				nota2=nota1;
				nota1=nota_alumno(matriz,j);
			}else if(nota_alumno(matriz,j)>nota2){
				nota3=nota2;
				nota2=nota_alumno(matriz,j);
			}else if(nota_alumno(matriz,j)>nota3){
				nota3=nota_alumno(matriz,j);
			}
		}
		notas[0]=nota1;
		notas[1]=nota2;
		notas[2]=nota3;
		return notas;
	}
	//Calcula la desviación típica de cada alumno en el examen
	public static double desviacion_tipica(double [][] examen) {
		double [] notas = new double[examen.length]; 
		int contador=0;
		double desviacion_tipica=0,numerador=0,suma=0, suma_notas = 0,media=0;
		for (int i = 0;i<examen.length ;i++) {
			contador++;
			suma = 0;
			for (int j = 0;j<examen[i].length ;j++) {
				suma =examen[i][j]+suma;
			}
			notas[i] = suma;
			suma_notas = suma_notas + suma;
		}
		media=suma_notas/contador;
		for (int i = 0;i<examen.length ;i++) {
			numerador=Math.pow(notas[i]-media,2)+numerador;
		}
		desviacion_tipica=Math.sqrt(numerador/contador);
		return desviacion_tipica;
	}
}