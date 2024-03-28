package main;

import java.util.HashSet;

public class LinkedList<T extends Comparable<T>> implements List<T>{

	private Node head = new Node(null); // dummy head
	private int length = 0;
	
	private boolean isSorted = true;
	
	public LinkedList() {
	}
	
	public boolean add(T element) {
		if(length < 1) {
			head.setNext(new Node<T>(element));
			length++;
			return true;
		}
		Node<T> n = head;
		while(n.getNext() != null) {
			n = n.getNext();
		}
		n.setNext(new Node<T>(element));
		length++;
		return true;
	}

	
	public boolean add(int index, T element) {
		if(index > length) {
			return false;
		}
		int count = 0;
		Node<T> n = head;
		while(count < index) {
			n = n.getNext();
			count++;
		}
		Node temp = new Node<T>(element);
		temp.setNext(n.getNext());
		n.setNext(temp);
		length++;
		return true;
	}

	
	public void clear() {
		
		
	}

	
	public T get(int index) {
		if(index > length-1) {
			return null;
		}
		int count = 0;
		Node<T> n = head;
		while(count < index) {
			n = n.getNext();
			count++;
		}
		return n.getNext().getData();
	}
	
	public Node<T> getNode(int index) {
		if(index > length-1) {
			return null;
		}
		int count = 0;
		Node<T> n = head;
		while(count < index) {
			n = n.getNext();
			count++;
		}
		return n.getNext();
	}

	
	public int indexOf(T element) {
		int count = 0;
		Node<T> n = head;
		while(n != null) {
			n = n.getNext();
			if(n.getData().equals(element)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	
	public boolean isEmpty() {
		if(length == 0) {
			return true;
		}
		return false;
	}

	
	public int size() {
		return length;
	}

	
	public void sort() {
		if(!isSorted) {
			for (int i = 0; i < length - 1; i++) {
				int minIndex = i;
				for (int j = i+1; j < length; j++) {
					if (get(j).compareTo(get(minIndex)) < 0) {
						minIndex = j;
					}
				}
				T temp = get(minIndex);
				remove(minIndex);
				add(minIndex, get(i));
				remove(i);
				add(i, temp);
			}
			isSorted = true;
		}
	}

	
	public T remove(int index) {
		if(index > length) {
			return null;
		}
		int count = 0;
		Node<T> n = head;
		while(count < index) {
			n = n.getNext();
			count++;
		}
		Node<T> temp = n.getNext();
		n.setNext(n.getNext().getNext());
		length--;
		return temp.getData();
	}

	
	public void removeDuplicates() {
		HashSet<T> occurances = new HashSet<T>();
		Node<T> n = head;
		while(n.getNext() != null) {
			n = n.getNext();
			occurances.add(n.getData());
			while(n.getNext() != null && occurances.contains(n.getNext().getData())) {
				n.setNext(n.getNext().getNext());
				length--;
			}
		}
		
	}

	
	public void reverse() {
		if(length > 1) {
			Node<T> n = head;
			int count = 0;
			while(count < length-1) {
				add(length-count, n.getNext().getData());
				n.setNext(n.getNext().getNext());
				length--;
				count++;
			}
		}
		
	}

	
	public void exclusiveOr(List otherList) {
		
		
	}

	
	public T getMin() {
		if(length > 0) {
			T min = (T) head.getNext().getData();
			Node<T> n = head.getNext();
			while(n != null) {
				if(n.getData().compareTo(min) < 0) {
					min = n.getData();
				}
				n = n.getNext();
			}
			return min;
		}
		return null;
	}

	
	public T getMax() {
		if(length > 0) {
			T max = (T) head.getNext().getData();
			Node<T> n = head.getNext();
			while(n != null) {
				if(n.getData().compareTo(max) > 0) {
					max = n.getData();
				}
				n = n.getNext();
			}
			return max;
		}
		return null;
	}

	
	public boolean isSorted() {
		return isSorted;
	}
	
	public String toString() {
		String str = "";
		Node<T> n = head;
		while(n.getNext() != null){
			n = n.getNext();
			str += n.getData();
			str += "\n";
		}
		return str;
	}

}
