package huffman.application;

class PriorityQueue {
	private Node[] heap;
	private int size;

	public PriorityQueue() {
		heap = new Node[16];
		size = 0;
	}

	public void add(Node node) {
		if (size >= heap.length) {
			resize();
		}
		heap[size] = node;
		size++;
		heapifyUp();
	}

	public Node remove() {
		Node min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
		return min;
	}

	private void heapifyUp() {
		int index = size - 1;
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (heap[index].compareTo(heap[parentIndex]) >= 0) {
				break;
			}
			swap(index, parentIndex);
			index = parentIndex;
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (index * 2 + 1 < size) {
			int minIndex = index * 2 + 1;
			if (index * 2 + 2 < size && heap[index * 2 + 2].compareTo(heap[minIndex]) < 0) {
				minIndex = index * 2 + 2;
			}
			if (heap[index].compareTo(heap[minIndex]) <= 0) {
				break;
			}
			swap(index, minIndex);
			index = minIndex;
		}
	}

	private void swap(int i, int j) {
		Node temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void resize() {
		Node[] newHeap = new Node[heap.length * 2];
		System.arraycopy(heap, 0, newHeap, 0, heap.length);
		heap = newHeap;
	}

	public int size() {
		return size;
	}
}