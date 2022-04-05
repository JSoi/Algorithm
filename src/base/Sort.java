package base;

import java.util.Arrays;

public class Sort {
	static int[] array = { 7, 5, 9, 0, 3, 1, 6, 2, 6, 4, 8 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort(array);

		System.out.println("selectionSort: ---");
		selectionSort(array);
		System.out.println("InsertionSort: ---");
		insertionSort(array);
	}

	static void bubbleSort(int[] arr) {
		int[] narr = arr.clone();
		for (int i = 0; i < narr.length - 1; i++) {
			for (int j = i + 1; j < narr.length; j++) {
				if (narr[i] > narr[j]) {
					int temp = narr[i];
					narr[i] = narr[j];
					narr[j] = temp;
				}
			}
		}
		print(narr);
	}

	static void selectionSort(int[] arr) {
		int[] narr = arr.clone();
		int minIndex;// Index로 정렬
		for (int i = 0; i < narr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < narr.length; j++) {
				if (narr[minIndex] > narr[j]) {
					minIndex = j;
				}
			}
			int temp = narr[i];
			narr[i] = narr[minIndex];
			narr[minIndex] = temp;
		}
		print(narr);
	}

	static void insertionSort(int[] arr) {
		int[] narr = arr.clone();
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (narr[j] < narr[j - 1]) {
					int temp = narr[i];
					narr[i] = narr[j];
					narr[j] = temp;
				}
			}
		}
		print(narr);
	}

	static void mergeSort(int[] arr) {

	}

	/**
	 * 중요
	 */
	static void quickSort(int[] arr) {

	}

	static void heapSort() {

	}

	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
