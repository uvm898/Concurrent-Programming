package rs.ac.bg.etf.kdp.urosm8;

public class simpleCLH {

	class Node {
		private Thread t = null;
		private Node next = null;

		public Node(Thread t) {
			this.t = t;
			this.next = null;
		}

		public Thread getT() {
			return t;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	private Node head = null;
	private Node tail = null;

	public void put(Thread t) {
		Node new_node = new Node(t);
		if (tail == null)
			head = new_node;
		else
			tail.setNext(new_node);
		tail = new_node;
	}

	public void remove() {
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
	}

	public Thread firstThread() {
		return head.getT();
	}

}
