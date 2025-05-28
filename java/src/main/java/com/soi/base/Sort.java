package com.soi.base;

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
		System.out.println("QuickSort: ---");
		quickSort(array);
		System.out.println("MergeSort: ---");
		mergeSort(array);
		System.out.println("HeapSort: ---");
		heapSort(array);
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
		int minIndex;// Index�� ����
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
					int temp = narr[j];
					narr[j] = narr[j - 1];
					narr[j - 1] = temp;
				}
			}
		}
		print(narr);
	}

	static void mergeSort(int[] narr) {
		int[] arr = narr.clone();
		mergeSort(arr, 0, arr.length - 1);
		print(arr);
	}

	static void mergeSort(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int[] L = Arrays.copyOfRange(arr, left, mid + 1);
		int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
		int i = 0, j = 0, k = left;
		int ll = L.length, rr = R.length;
		while (i < ll && j < rr) {
			if (L[i] <= R[j]) {
				arr[k] = L[i++];
			} else {
				arr[k] = R[j++];
			}
			k++;
		}
		while (i < ll) {
			arr[k++] = L[i++];
		}
		while (j < rr) {
			arr[k++] = R[j++];
		}

	}

	/**
	 * �߿�
	 */
	static void quickSort(int[] narr) {
		int[] arr = narr.clone();
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}

	static void quickSort(int[] arr, int left, int right) {
		int part = partition(arr, left, right);
		if (left < part - 1) {
			quickSort(arr, left, part - 1);
		}
		if (right > part) {
			quickSort(arr, part, right);
		}
	}

	static int partition(int[] arr, int left, int right) {
		int p = arr[(left + right) / 2]; // �ǹ��� �߾Ӱ����� ��´�
		while (left <= right) {
			while (arr[left] < p) // ���ʿ��� �ǹ����� ū ���� ã�´�
				left++;
			while (arr[right] > p) // �����ʿ��� �ǹ����� ���� ���� ã�´�
				right--;
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

	static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i > 0; i--) { // �θ��常 Ž��
			heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) { // �����Һ��� swap�ϸ� �ٽ� heap�Ѵ�
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
		print(arr);
	}

	static void heapify(int[] arr, int n, int i) {
		int p = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if (l < n && arr[p] < arr[l]) {
			p = l;
		}
		if (r < n && arr[p] < arr[r]) {
			p = r;
		}
		if (i != p) {
			swap(arr, p, i);
			heapify(array, n, p);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
