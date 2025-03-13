
public class LinkedList<T extends Comparable<T>> {
	T data;
	Node<T> next;
	private Node<T> head;

	public void insertFirst(T data) { // unsorted
		Node<T> node = new Node<>(data);
		node.next = head;
		head = node;
	}

	public boolean search(T target)// unsorted
	{
		Node<T> curr = head;

		while (curr != null) {
			if (curr.data.compareTo(target) == 0) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	public void insert() {
		Node<T> Node = new Node<>(data);
		if (head == null) {
			head = Node;
		} else {
			Node<T> prev = null;
			Node<T> curr = head;
			while (curr != null) {
				if (curr.getData().compareTo(data) < 0) {
					prev = curr;
					curr = curr.getNext();
				} else
					break;
				if (curr == head) {
					Node.setNext(head);
					head = Node;
				} else if (curr == null) {
					prev.setNext(Node);
				} else {
					Node.setNext(curr);
					prev.setNext(Node);
				}
			}

		}
	}

	private boolean searchSorted(T target, Node<T> node) {
		if (node != null) {
			if (node.getData().compareTo(target) == 0)// found
				return true;

			if (node.getData().compareTo(target) > 0)// curr > target no need to cont.
				return false;

			return searchSorted(target, node.getNext());

		}
		return false;
	}

	public boolean searchSorted(T target) {
		return searchSorted(target, head);
	}

	@Override
	public String toString() {
		String s = "Head -->";
		Node<T> curr = head;
		while (curr != null) {
			s += curr;
			curr = curr.next;
		}
		return s + "Null";
	}

}
