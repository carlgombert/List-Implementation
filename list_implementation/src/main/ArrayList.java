package main;

import java.util.HashSet;

public class ArrayList<T extends Comparable<T>> implements List<T>{

	private T[] a;
	private int length = 0;
	
	private boolean isSorted = true;
	
	public ArrayList() {
		a = (T[]) new Comparable[2];
	}
	
	public boolean add(T element) {
		if(element == null) {
			return false;
		}
		if(length == a.length) {
			grow();
		}
		a[length] = element;
		length++;
		checkSorted();
		return true;
	}

	
	public boolean add(int index, T element) {
		if(index > length || index < 0 || element == null) {
			return false;
		}
		if(length == a.length) {
			grow();
		}
		for(int i = length-1; i > index-1; i--) {
			a[i+1] = a[i];

		}
		a[index] = element;
		length++;
		checkSorted();
		return true;
	}

	
	public void clear() {
		a = (T[]) new Comparable[2];
		isSorted = true;
		length = 0;
	}

	
	public T get(int index) {
		if(index > length-1 || index < 0) {
			return null;
		}
		return a[index];
	}

	
	public int indexOf(T element) {
		for(int i = 0; i < length; i++) {
			if(element.equals(a[i])) {
				return i;
			}
		}
		return -1;
	}

	
	public boolean isEmpty() {
		return length == 0;
	}

	
	public int size() {
		return length;
	}

	
	public void sort() {
		if(!isSorted) {
			for (int i = 0; i < length - 1; i++) {
				int minIndex = i;
				for (int j = i+1; j < length; j++) {
					if (a[j].compareTo(a[minIndex]) < 0) {
						minIndex = j;
					}
				}
				T temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
			isSorted = true;
		}
	}

	
	public T remove(int index) {
		if(index > length-1 || index < 0) {
			return null;
		}
		T val = a[index];
		length--;
		for(int i = index; i < length; i++) {
			a[i] = a[i+1];
		}
		checkSorted();
		return val;
	}

	
	public void removeDuplicates() {
		HashSet<T> occurances = new HashSet<T>();
		for(int i = 0; i < length; i++) {
			if(occurances.contains(a[i])){
				remove(i);
				i--;
			}
			else {
				occurances.add(a[i]);
			}
					
		}
		checkSorted();
	}

	
	public void reverse() {
		int k = 0;
		int j = length - 1;
		while(k < j) {
			T temp = a[k];
			a[k] = a[j];
			a[j] = temp;
			k++;
			j--;
		}
		checkSorted();
		
	}

	
	public void exclusiveOr(List<T> otherList) {
		this.removeDuplicates();
		if(otherList.equals(null)) {
			return;
		}
		otherList.removeDuplicates();
		
		for(int i = 0; i < otherList.size(); i++) {
			int containsIndex = this.indexOf(otherList.get(i));
			if(containsIndex == -1) {
				this.add(otherList.get(i));
			}
			else {
				this.remove(containsIndex);
			}
		}
		
		this.sort();
		
	}

	
	public T getMin() {
		int minIndex = 0;
		for(int i = 0; i < length; i++) {
			if (a[i].compareTo(a[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return a[minIndex];
	}

	
	public T getMax() {
		int maxIndex = 0;
		for(int i = 0; i < length; i++) {
			if (a[i].compareTo(a[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return a[maxIndex];
	}

	
	public boolean isSorted() {
		return isSorted;
	}
	
	private void grow() {
		T[] newArr = (T[]) new Comparable[a.length*2];
		for(int i = 0; i < a.length; i++) {
			newArr[i] = a[i];
		}
		a = newArr;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < length; i++) {
			str += a[i];
			str += "\n";
		}
		return str;
	}
	
	public void checkSorted() {
		isSorted = true;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i+1; j < length; j++) {
				if (a[j].compareTo(a[i]) < 0) {
					isSorted = false;
					return;
				}
			}
		}
	}

}
