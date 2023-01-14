package huffman.application;

public class HuffmanTree {
	private Node root;
	private String[] codes;
	private PriorityQueue pq;
	
	public HuffmanTree(int[] freqs) {
		codes=new String[freqs.length];
		pq = new PriorityQueue();
		
		buildTree(freqs);
		codes(root, "");
	}

	private void buildTree(int[] frequencies) {
		/*
		 * Build the priority queue of the frequencies array
		 * Remove the two nodes with the lowest frequencies
		 * Create a new internal node with these two nodes, the sum of their frequencies as the frequency
		 * Add the new node to the priority queue
		 * Repeat until there is only one node in the queue and it's the root
		 */
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] > 0) {
				pq.add(new Node(frequencies[i], (char)i));
				//System.out.println((char) i +"->"+ frequencies[i]);
			}
		}
		while (pq.size() > 1) {
			Node left = pq.remove();
			Node right = pq.remove();
			Node parent = new Node(left.getFreq() + right.getFreq(), left, right);
			pq.add(parent);
		}
		setRoot(pq.remove());
	}

	private void codes(Node root, String str) {
		if (root == null) {
			return;
		}
		if (root.isLeaf() ) {
			codes[root.getCh()] = (char)root.getCh() +"="+ str;
		} else {
			codes(root.getLeft(), str + "0");
			codes(root.getRight(), str + "1");
		}
	}
	
	public char getChar(String code) {
	    Node currentNode = root;
	    for (int i = 0; i < code.length(); i++) {
	        if (code.charAt(i) == '0') {
	            currentNode = currentNode.left;
	        } else {
	            currentNode = currentNode.right;
	        }
	    }
	    return (char)currentNode.getCh();
	}

	
	public boolean isCode(String code) {
	    return isCode(this.root, code);
	}

	private boolean isCode(Node current, String code) {
	    // base case: code has been fully traversed and a leaf node has been reached
	    if (code.length() == 0 && current.isLeaf()) {
	        return true;
	    }
	    // base case: code has been fully traversed but no leaf node has been reached
	    if (code.length() == 0 && !current.isLeaf()) {
	        return false;
	    }
	    // recursive case: traverse left if next character in code is '0', right if it is '1'
	    if (code.charAt(0) == '0') {
	        return isCode(current.left, code.substring(1));
	    } else {
	        return isCode(current.right, code.substring(1));
	    }
	}

	/*
	 * Getters and Setters
	 */
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public String[] getCodes() {
		return codes;
	}
	public void setCodes(String[] codes) {
		this.codes = codes;
	}
}