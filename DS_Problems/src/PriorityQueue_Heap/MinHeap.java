package PriorityQueue_Heap;

import java.util.Arrays;

public class MinHeap {

	int index;
	int[] arr;

	public MinHeap(int n) {
		arr = new int[n];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public boolean isFull() {
		return index == arr.length;
	}

	public int getMin() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return arr[0];
	}

	public void insert(int ele) {
		if (isFull())
			return;
		int c = index;
		int p = (c - 1) / 2;
		arr[index++] = ele;
		while (p >= 0 && arr[p] > arr[c]) {
			swap(c, p);
			c = p;
			p = (c - 1) / 2;
		}
	}

	public int deleteMin() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int val = arr[0];
		arr[0] = arr[--index];
		int p = 0;
		int c1 = (p * 2) + 1;
		int c2 = (p * 2) + 2;
		while (c1 <= index) {
			int c1Value = (c1 <= index) ? arr[c1] : Integer.MAX_VALUE;
			int c2Value = (c2 <= index) ? arr[c2] : Integer.MAX_VALUE;
			int min = Math.min(c1Value, c2Value);
			if (arr[p] > min) {
				if (min == c1Value) {
					swap(c1, p);
					p = c1;
				} else {
					swap(c2, p);
					p = c2;
				}
				c1 = (p * 2) + 1;
				c2 = (p * 2) + 2;
			} else
				break;
		}
		return val;
	}

	private void swap(int child, int parent) {
		int temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
	}

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(12);
		heap.insert(5);
		heap.insert(3);
		heap.insert(7);
		heap.insert(-5);
		heap.insert(2);
		heap.insert(8);
		heap.insert(9);
		heap.insert(0);
		heap.insert(-21);
		heap.insert(-55);
		heap.insert(-38);
		heap.insert(6);
		heap.insert(50);
		System.out.println(Arrays.toString(heap.arr));
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());
		System.out.println(heap.deleteMin());

	}

}
