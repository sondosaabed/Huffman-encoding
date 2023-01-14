package huffman.application;
class Node implements Comparable<Node> {
	char ch;
	int freq;
	Node left;
	Node right;

	public Node(int freq, char ch) {
		this.freq = freq;
		this.ch = ch;
		this.left = null;
		this.right = null;
	}
	  
	public Node(int freq, Node left, Node right) {
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [ch=" + ch + ", freq=" + freq + "]";
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	// Compare nodes based on their frequency
	public int compareTo(Node other) {
		return this.freq - other.freq;
	}

	public char getCh() {
		return ch;
	}

	public int getFreq() {
		return freq;
	}

	public Node getRight() {
		return right;
	}

	public Node getLeft() {
		return left;
	}
}