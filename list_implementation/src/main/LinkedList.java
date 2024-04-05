package main;

import java.util.HashSet;

public class LinkedList<T extends Comparable<T>> implements List<T>{

	// this is a headed list
	private Node<T> head = new Node<T>(null);
	
	//class variable for keeping track of the size of the list
	private int length = 0;
	
	//class variable for keeping track of the sorted state
	private boolean isSorted = true;
	
	public LinkedList() {
	}
	
	public boolean add(T element) {
		// don't add null elements to the list
		if(element == null) {
			return false;
		}
		
		if(length == 0) { 
			head.setNext(new Node<T>(element));
			length++;
			return true;
		}
		
		Node<T> n = head;
		
		// iterate through the linked list until the final node is reached
		while(n.getNext() != null) { 
			n = n.getNext();
		}
		
		// set the pointer of the final node to a new node with input data
		n.setNext(new Node<T>(element)); 
		length++;
		
		// see if the list is sorted
		checkSorted();
		return true;
	}

	public boolean add(int index, T element) {
		// don't add null elements to the list, make sure index is within range
		if(index > length || index < 0 || element == null) {
			return false;
		}
		
		int count = 0;
		Node<T> n = head;
		
		// iterate through the linked list until the node before desired index is reached
		while(count < index) {
			n = n.getNext();
			count++;
		}
		
		Node<T> temp = new Node<T>(element);
		temp.setNext(n.getNext());
		n.setNext(temp);
		
		length++;
		
		// see if the list is sorted
		checkSorted();
		
		return true;
	}

	
	public void clear() {
		head.setNext(null);
		isSorted = true;
		length = 0;
	}

	
	public T get(int index) {
		// make sure index is within range
		if(index >= length || index < 0) {
			return null;
		}
		
		Node<T> current = head;
	    for (int i = 0; i < index; i++) {
	        current = current.getNext();
	    }
	    
	    return current.getNext().getData();
	}
	
	public Node<T> getNode(int index) {
		// make sure index is within range
		if(index > length-1 || index < 0) {
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
		
		int counter = 0;
		Node<T> curr = head.getNext();
		
		while(curr != null) {
			if(element.equals(curr.getData())) {
				return counter;
			}
			
			counter++;
			curr = curr.getNext();
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
		if(length < 1) {
			return;
		}
		
		// create new chain of nodes that will be in sorted order
		Node<T> sortedHead = new Node<T>(null);
		
		Node<T> curr = head.getNext();
		
		// create the first element in the sorted list
		sortedHead.setNext(new Node<T>(curr.getData()));
		
		//keeps track of current node in the sorted list
		Node<T> sortedCurr = sortedHead.getNext();
		
		curr = curr.getNext();
		
		while(curr != null) {
			
			// set the sorted current back to the start of list
			sortedCurr = sortedHead.getNext();
			
			// if the current node is smaller than first element in sorted list, insert at the start
			if(curr.getData().compareTo(sortedCurr.getData()) < 0) {
				sortedHead.setNext(new Node<T>(curr.getData()));
				sortedHead.getNext().setNext(sortedCurr);
			} 
			
			else {
				
				// iterate through the sorted list until the current node is less than the next sorted node
				// if the current node is larger than everything in the sorted list, it gets added at the end
				while(sortedCurr.getNext() != null && curr.getData().compareTo(sortedCurr.getNext().getData()) > 0) {
					sortedCurr = sortedCurr.getNext();
				}

				// insert current node into sorted list
				Node<T> temp = sortedCurr.getNext();
				sortedCurr.setNext(new Node<T>(curr.getData()));
				sortedCurr.getNext().setNext(temp);
			}
			
			curr = curr.getNext();
		}
		
		// replace the chain of nodes after this lists head with the new sorted list
		head.setNext(sortedHead.getNext());
		
		isSorted = true;
	}

	
	public T remove(int index) {
		// make sure index is within range
		if(index >= length || index < 0) {
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
		
		checkSorted();
		
		return temp.getData();
	}

	
	public void removeDuplicates() {
		// create new linkedlist to keep track of element occurances
		LinkedList<T> occurances = new LinkedList<>();
		
		Node<T> curr = head.getNext();
		occurances.add(curr.getData());
		
		while(curr != null && curr.getNext() != null) {
			
			// if the occurances list contains the next node
			if(occurances.indexOf(curr.getNext().getData()) != -1) {
				
				//remove the next node
				curr.setNext(curr.getNext().getNext());
				length--;
			}
			// if the occurances list doesn't contain the next node
			else {
				// add the next node to occurances, not using add method for increased O(1) runtime
				Node<T> temp = occurances.getHead().getNext();
				occurances.getHead().setNext(new Node<T>(curr.getNext().getData()));
				occurances.getHead().getNext().setNext(temp);
				curr = curr.getNext();
			}
		}
		
		checkSorted();
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
			checkSorted();
		}
		
	}

	
	public void exclusiveOr(List<T> otherList) {
		if(otherList.equals(null)) {
			return;
		}
		
		// remove any duplicates from both lists
		this.removeDuplicates();
		otherList.removeDuplicates();
		
		// for every element in the other list
		for(int i = 0; i < otherList.size(); i++) {
			int containsIndex = this.indexOf(otherList.get(i));
			
			//if this list doesn't contain the element in the other list, add it
			if(containsIndex == -1) {
				this.add(otherList.get(i));
			}
			else {
				// if it does, remove it from this list
				this.remove(containsIndex);
			}
		}
		
		// sort this list
		this.sort();
	}

	
	public T getMin() {
		if(length > 0) {
			
			// if the list is sorted, return head of list
			if(isSorted) {
				return head.getNext().getData();
			}
			
			T min = (T) head.getNext().getData();
			Node<T> n = head.getNext();
			
			while(n != null) {
				
				// if current node is less than current min, set current min to current node
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
				
				// if current node is more than current max, set current max to current node
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
	
	// helper method to check if the list is sorted
	private void checkSorted() {
		// if length = 0;
		if(head.getNext() == null) {
			isSorted = true;
			return;
		}
		
		Node<T> curr = head.getNext();
		while(curr.getNext() != null) {
			
			// if the current node is more than the node after it the list is not sorted
			if(curr.getData().compareTo(curr.getNext().getData()) > 0) {
				isSorted = false;
				return;
			}
			
			curr = curr.getNext();
		}
		isSorted = true;
	}
	
	
	// helper method that returns this list as a chain of nodes instead of a linkedlist object
	public Node<T> getHead(){
		return head.getNext();
	}

}
