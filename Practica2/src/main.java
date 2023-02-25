import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int variable_aux=0;												//Inicializo una variable auxiliar donde "almacenaré" los datos que quiera imprimir
		System.out.println("Introduzca el primer numero: ");			//Pido los dos número que delimitan el rango donde buscar y los guardo en dos variables
		int primer_num = in.nextInt();
		System.out.println("Introduzca el segundo número: ");
		int segundo_num = in.nextInt();
		if((primer_num<segundo_num)&&(primer_num>0)) {					//Si el primer número del rango es mayor que el segundo o el primero es 0 devuelve un mensaje de error
			variable_aux = mayorFactores(primer_num,segundo_num);		//En la variable auxiliar guardo el índice del numero triangular con más número de factores
			System.out.println(variable_aux);								
			variable_aux = numeroTriangular(variable_aux);				//En la variable auxiliar guardo el número triangular del índice obtenido anteriormente
			System.out.println(variable_aux);
			variable_aux = numeroRectangular(variable_aux);				//En la variable auxiliar guardo el número de todas las posibles formaciones rectangulares del número triangular obtenido ántes
			System.out.println(variable_aux);
		}else
			System.out.println("El rango introducido es erroneo");
	}
	//Método que dados 2 números calcula el índice del que más factores tiene
	public static int mayorFactores (int primer_num,int segundo_num) {
		int x=0;
		int var=0;
		for(int i = primer_num;i<= segundo_num;i++) {
			int a = numeroTriangular(i);
			int b = factor(a);
			if(b>x) {
				x = b;
				var = i;
			}
		}return var;
	}
	//Cácula el número de factores que tiene "a"
	public static int factor(int a) {
		int cont = 0;
		int divi = 2;
		while(a!=1) {
			if(a%divi==0) {
				cont++;
				a = a/divi;
			}else {
				divi++;
			}
		} return cont;
	}
	// Cálcula el número triangular de "a"
	public static int numeroTriangular(int a) {
		a = (a*(a+1))/2;
		return a;
	}
	//Cálcula el número de todas las pposibles formaciones rectangulares de "a"
	public static int numeroRectangular(int a) {
		int cont=0;
		for (int i=1;i<=a;i++) {
			if(a%i==0) {
				cont++;
			}
		}
		return cont;
	}
}