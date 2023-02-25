// AUTOR ALEJANDRO PULIDO SÁNCHEZ
package Practica;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("Introduzca tres valores para los lados de un triangulo: ");
		Scanner teclado = new Scanner(System.in);
		int a = teclado.nextInt();
		int b = teclado.nextInt();
		int c = teclado.nextInt();
		// Obtenemos los tres candidatos para formar un triangulo y comprobamos que sean positivos y mayores de 0
		if (a<1 || b<1 || c<1) {
			System.out.println("INCORRECTO");
		}
		// Si son positivos y mayores que cero se puede formar un triangulo
		// Para saber si el triangulo es rectangulo,obstusangulo o acutangulo llamamos a las funciones que se encargan de hacerlo
		// y así en el main solo imprimimos la respuesta
		if(triangulo(a,b,c) == true) {
			if(rectangulo(a,b,c) == true) {
				System.out.println("RECTANGULO");
			}else {
				if(acutangulo(a,b,c)==true) {
					System.out.println("ACUTANGULO");
				}else{
					if(obstusangulo(a,b,c) == true) 
						System.out.println("OBSTUSANGULO");
				}}}
		else {
			System.out.println("IMPOSIBLE");
		}
		teclado.close(); 
	}
	// DECLARACIÓN DE FUNCIONES
	// Función utilizada para saber si se puede formar o no un triangulo con tres números
	public static boolean triangulo(int x, int y, int z) {
		double xy, xz, yz;
		xy= x+y; xz= x+z; yz= y+z;

		boolean sepuede = true;
		if((z>xy)||(x>yz)||(y>xz)) {
			sepuede=false;
		}
		return sepuede;
	}
	// Función utilizada para hallar el número más grande de tres enteros
	public static int numgrande(int n1, int n2, int n3) {
		int g;
		if (n1 > n2) {
			if (n1 > n3) {
				g = n1;
			} else {
				g = n3;
			}
		} else if (n2 > n3) {
			g = n2;
		} else {
			g = n3;
		}
		return g;
	}
	// Comprueba si un triangulo es rectangulo, si lo es devuelve un true, si no un false
	public static boolean rectangulo(int a, int b, int c) {
		int g = numgrande(a,b,c);
		boolean rect = false;
		if(g==a) {
			g = g*g;
			b = b*b;
			c = c*c;
			if(g==b+c) {
				rect=true;
			}
		}if(g==b) {
			g = g*g;
			a = a*a;
			c = c*c;
			if(g==a+c) {
				rect=true;
			}
		}else {
			g = g*g;
			b = b*b;
			a = a*a;
			if(g==b+a) {
				rect=true;
			}
		}		
		return rect;
	}
	// Comprueba si un triangulo es obstusangulo, si lo es devuelve un true, si no un false
	public static boolean obstusangulo(int a, int b, int c) {
		int g = numgrande(a,b,c);
		boolean obs = false;
		if(g==a) {
			g = g*g;
			b = b*b;
			c = c*c;
			if(g>b+c) {
				obs=true;
			}
		}if(g==b) {
			g = g*g;
			a = a*a;
			c = c*c;
			if(g>a+c) {
				obs=true;
			}
		}else {
			g = g*g;
			b = b*b;
			a = a*a;
			if(g>b+a) {
				obs=true;
			}
		}
		return obs;
	}
	// Comprueba si un triangulo es acutangulo, si lo es devuelve un true, si no un false
	public static boolean acutangulo(int a, int b, int c) {
		int g = numgrande(a,b,c);
		boolean acu = false;
		if(g==a) {
			g = g*g;
			b = b*b;
			c = c*c;
			if(g<b+c) {
				acu=true;
			}
		}if(g==b) {
			g = g*g;
			a = a*a;
			c = c*c;
			if(g<a+c) {
				acu=true;
			}
		}else {
			g = g*g;
			b = b*b;
			a = a*a;
			if(g<b+a) {
				acu=true;
			}
		}
		return acu;
	}
}
