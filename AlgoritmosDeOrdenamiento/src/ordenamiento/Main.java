package ordenamiento;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicio = System.currentTimeMillis();
		int n = 600000;
		int q = 1;
		double e = 0;
		int[] arreglo = new int[n];
		Random r1 = new Random();
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = r1.nextInt(1000);
		}
		int[] arre = new int[n];

		OrdenarArreglo orAr = new OrdenarArreglo();

		/*
		 * System.out.println( e=orAr.burbuja(arreglo));
		 * System.out.println(e=orAr.burbujaDoble(arreglo));
		 * System.out.println(e=orAr.insercion(arreglo));
		 * System.out.println(e=orAr.seleccion(arreglo));
		 * System.out.println(e=orAr.shellSort(arreglo));
		 */

		switch (q) {

			case 1 :
				e = orAr.burbuja(arreglo);
				break;
			case 2 :
				e = orAr.burbujaDoble(arreglo);
				break;
			case 3 :
				e = orAr.insercion(arreglo);
				break;
			case 4 :
				e = orAr.seleccion(arreglo);
				break;
			case 5 :
				e = orAr.shellSort(arreglo);
				break;
			case 6 :
				orAr.bucketSort(arreglo, 2);
				break;
			case 7 :
				orAr.recursiveInsertionSort(arreglo, n);
				break; // maximo 11498, laura 11229
			case 8 :
				orAr.mergeSort(arreglo);
				break;
			case 9 :
				orAr.QuickSort(arreglo);
				break;
			case 10 :
				orAr.stoogeSort(arreglo);
				break; // lento
			case 11 :
				orAr.heapSort(arreglo);
				break;
			case 12 :
				orAr.bitonicSort(arreglo);
				break;
			case 13 :
				orAr.GnomeSort(arreglo);
				break;
				
			case 14 :
				orAr.BinaryInsertionSort(arreglo);
				break;
				
			case 15 :
				orAr.strandSort(arreglo);
				break; //1058
				
			case 16 :
				orAr.radixSort(arreglo);
				break;

			default :
				break;

		}
		long finInicio = System.currentTimeMillis();
		e = (finInicio - tiempoInicio) / 1000.0;
		System.out.println(e);

	}
}