package ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenarArreglo {
	private int temp = 0;
	long tiempoInicio = System.currentTimeMillis();

	public long burbuja(int[] arreglo) {

		for (int j = 1; j < arreglo.length; j++) {
			for (int i = 0; i < arreglo.length - 1; i++) {
				if (arreglo[i] > arreglo[i + 1]) {
					temp = arreglo[i];
					arreglo[i] = arreglo[i + 1];
					arreglo[i + 1] = temp;

				}
			}
		}
		long tiempoFin = System.currentTimeMillis();
		return (tiempoFin - tiempoInicio);
	}

	public long burbujaDoble(int arreglo[]) {

		{
			int aux, primero = 1, ultimo = arreglo.length - 1,
					dir = arreglo.length - 1;
			while (ultimo >= primero) {
				for (int i = ultimo; i >= primero; i--) {
					if (arreglo[i - 1] > arreglo[i]) {
						aux = arreglo[i - 1];
						arreglo[i - 1] = arreglo[i];
						arreglo[i] = aux;
						dir = i;
					}
				}
				primero = dir + 1;
				for (int i = primero; i <= ultimo; i++) {
					if (arreglo[i - 1] > arreglo[i]) {
						aux = arreglo[i - 1];
						arreglo[i - 1] = arreglo[i];
						arreglo[i] = aux;
						dir = i;
					}
				}
				ultimo = dir - 1;
			}
		}
		long tiempoFin = System.currentTimeMillis();
		return (tiempoFin - tiempoInicio);
	}

	public long seleccion(int arreglo[]) {
		int i, j, k, menor;
		i = 0;
		while (i < arreglo.length - 1) {
			menor = arreglo[i];
			k = i;
			for (j = i + 1; j < arreglo.length; j++) {

				if (arreglo[j] < menor) {

					menor = arreglo[j];
					k = j;

				}

			}
			arreglo[k] = arreglo[i];
			arreglo[i] = menor;
			i++;
		}
		long tiempoFin = System.currentTimeMillis();
		return (tiempoFin - tiempoInicio);
	}

	public long insercion(int arreglo[]) {

		int i, llave;
		for (int j = 1; j < arreglo.length; j++) {

			llave = arreglo[j];
			i = j - 1;
			while (i >= 0 && arreglo[i] > llave) {

				arreglo[i + 1] = arreglo[i];
				i--;

			}
			arreglo[i + 1] = llave;

		}
		long tiempoFin = System.currentTimeMillis();
		return (tiempoFin - tiempoInicio);

	}

	public long shellSort(int arreglo[]) {
		for (int incr = arreglo.length / 2; incr > 0; incr /= 2) {

			for (int i = incr; i < arreglo.length; i++) {

				int j = i - incr;
				while (j >= 0) {
					if (arreglo[j] > arreglo[j + incr]) {

						int T = arreglo[j];
						arreglo[j] = arreglo[j + incr];
						arreglo[j + incr] = T;
						j -= incr;

					} else {

						j = -1;

					}
				}
			}

		}
		long tiempoFin = System.currentTimeMillis();
		return (tiempoFin - tiempoInicio);
	}
	public void bucketSort(int[] array, int bucketSize) {
		if (array.length == 0) {
			return;
		}

		// Encuentra el valor mínimo y máximo en el array
		int minValue = array[0];
		int maxValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			} else if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		// Calcula la cantidad de baldes necesarios y crea los baldes
		int bucketCount = (maxValue - minValue) / bucketSize + 1;
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		// Coloca cada elemento en su balde correspondiente
		for (int i = 0; i < array.length; i++) {
			int bucketIndex = (array[i] - minValue) / bucketSize;
			buckets.get(bucketIndex).add(array[i]);
		}

		// Ordena cada balde usando InsertionSort
		for (int i = 0; i < bucketCount; i++) {
			ArrayList<Integer> bucket = buckets.get(i);
			Collections.sort(bucket);
		}

		// Combina los baldes ordenados en el array original
		int index = 0;
		for (ArrayList<Integer> bucket : buckets) {
			for (int value : bucket) {
				array[index++] = value;
			}
		}
	}

	/*
	 * public void sort(int[] arr) { if (arr == null || arr.length < 2) {
	 * return; } recursiveInsertionSort(arr, arr.length); }
	 * 
	 * private void recursiveInsertionSort(int[] arr, int n) { if (n <= 1) {
	 * return; } recursiveInsertionSort(arr, n-1); int last = arr[n-1]; int j =
	 * n-2; while (j >= 0 && arr[j] > last) { arr[j+1] = arr[j]; j--; } arr[j+1]
	 * = last; }
	 */
	public void recursiveInsertionSort(int[] arr, int n) {
		// Base case
		if (n <= 1)
			return;

		// Sort first n-1 elements
		recursiveInsertionSort(arr, --n);

		// Insert last element at its correct position
		int last = arr[n - 1];
		int j = n - 2;

		// Shift all elements greater than last to the right
		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j--;
		}

		// Insert last element in correct position
		arr[j + 1] = last;
	}
	/*
	 * Este método utiliza la recursión para ordenar los primeros n-1 elementos
	 * del arreglo, y 7 luego inserta el último elemento en su posición correcta
	 * en el arreglo ordenado. La complejidad de este algoritmo es O(n^2), pero
	 * en la práctica puede ser más rápido que otros algoritmos de ordenamiento
	 * como Bubble Sort o Selection Sort debido a su uso de inserciones en lugar
	 * de intercambios.
	 */

	public void mergeSort(int[] array) {
		int length = array.length;
		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[length - mid];
		for (int i = 0; i < mid; i++) {
			leftArray[i] = array[i];
		}
		for (int i = mid; i < length; i++) {
			rightArray[i - mid] = array[i];
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}

	private void merge(int[] leftArray, int[] rightArray, int[] result) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				result[k] = leftArray[i];
				i++;
			} else {
				result[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < leftArray.length) {
			result[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightArray.length) {
			result[k] = rightArray[j];
			j++;
			k++;
		}

	}
	public void QuickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private void sort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition(array, start, end);
		sort(array, start, pivot - 1);
		sort(array, pivot + 1, end);
	}

	private int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void stoogeSort(int[] array) {
		stoogeSort(array, 0, array.length - 1);
	}

	private void stoogeSort(int[] array, int start, int end) {
		if (array[start] > array[end]) {
			swapstoogeSort(array, start, end);
		}
		if (end - start + 1 > 2) {
			int k = (end - start + 1) / 3;
			stoogeSort(array, start, end - k);
			stoogeSort(array, start + k, end);
			stoogeSort(array, start, end - k);
		}
	}

	private void swapstoogeSort(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void heapSort(int[] array) {
		int n = array.length;
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(array, n, i);
		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// call max heapify on the reduced heap
			heapify(array, i, 0);
		}
	}

	private void heapify(int[] array, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2
		// If left child is larger than root
		if (l < n && array[l] > array[largest])
			largest = l;
		// If right child is larger than largest so far
		if (r < n && array[r] > array[largest])
			largest = r;
		// If largest is not root
		if (largest != i) {
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;
			// Recursively heapify the affected sub-tree
			heapify(array, n, largest);
		}
	}

	public void bitonicSort(int[] array) {
		bitonicSort(array, 0, array.length, true);
	}

	private void bitonicSort(int[] array, int start, int size,
			boolean ascending) {
		if (size > 1) {
			int middle = size / 2;
			// Sort first half in ascending order
			bitonicSort(array, start, middle, true);
			// Sort second half in descending order
			bitonicSort(array, start + middle, middle, false);
			// Merge the two halves
			bitonicMerge(array, start, size, ascending);
		}
	}

	private void bitonicMerge(int[] array, int start, int size,
			boolean ascending) {
		if (size > 1) {
			int middle = size / 2;
			for (int i = start; i < start + middle; i++) {
				if ((array[i] > array[i + middle]) == ascending) {
					swapbitonicSort(array, i, i + middle);
				}
			}
			bitonicMerge(array, start, middle, ascending);
			bitonicMerge(array, start + middle, middle, ascending);
		}
	}

	private void swapbitonicSort(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void GnomeSort(int[] array) {
		int index = 0;
		while (index < array.length) {
			if (index == 0 || array[index] >= array[index - 1]) {
				index++;
			} else {
				int temp = array[index];
				array[index] = array[index - 1];
				array[index - 1] = temp;
				index--;
			}

		}

	}

	public void BinaryInsertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);
			System.arraycopy(array, j, array, j + 1, i - j);
			array[j] = key;
		}
	}
	
	public static int[] strandSort(int[] arr) {
	    List<Integer> sorted = new ArrayList<>();
	    List<Integer> subList = new ArrayList<>();
	    
	    while (arr.length > 0) {
	        subList.add(arr[0]);
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] >= arr[i-1]) {
	                subList.add(arr[i]);
	            } else {
	                break;
	            }
	        }
	        for (int i : subList) {
	            arr = removeElement(arr, i);
	        }
	        sorted = merge(sorted, subList);
	        subList.clear();
	    }
	    
	    int[] sortedArray = new int[sorted.size()];
	    for (int i = 0; i < sorted.size(); i++) {
	        sortedArray[i] = sorted.get(i);
	    }
	    
	    return sortedArray;
	}

	private static int[] removeElement(int[] arr, int element) {
	    int[] newArr = new int[arr.length - 1];
	    int j = 0;
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] != element) {
	            newArr[j] = arr[i];
	            j++;
	        }
	    }
	    return newArr;
	}

	private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
	    List<Integer> mergedList = new ArrayList<>();
	    int i = 0;
	    int j = 0;
	    
	    while (i < list1.size() && j < list2.size()) {
	        if (list1.get(i) < list2.get(j)) {
	            mergedList.add(list1.get(i));
	            i++;
	        } else {
	            mergedList.add(list2.get(j));
	            j++;
	        }
	    }
	    
	    while (i < list1.size()) {
	        mergedList.add(list1.get(i));
	        i++;
	    }
	    
	    while (j < list2.size()) {
	        mergedList.add(list2.get(j));
	        j++;
	    }
	    
	    return mergedList;
	}
	
	public static void radixSort(int[] arr) {
	    int max = getMax(arr);
	    for (int exp = 1; max / exp > 0; exp *= 10) {
	        countSort(arr, exp);
	    }
	}

	private static int getMax(int[] arr) {
	    int max = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	        if (arr[i] > max) {
	            max = arr[i];
	        }
	    }
	    return max;
	}

	private static void countSort(int[] arr, int exp) {
	    int[] output = new int[arr.length];
	    int[] count = new int[10];
	    for (int i = 0; i < arr.length; i++) {
	        count[(arr[i] / exp) % 10]++;
	    }
	    for (int i = 1; i < 10; i++) {
	        count[i] += count[i - 1];
	    }
	    for (int i = arr.length - 1; i >= 0; i--) {
	        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	        count[(arr[i] / exp) % 10]--;
	    }
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = output[i];
	    }
	}

}