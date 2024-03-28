package main;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(2);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(4);
		
		System.out.println(list.toString());
		
		list.removeDuplicates();
		
		System.out.println();
		System.out.println(list.toString());
		
		System.out.println();
		System.out.println(list.isSorted());
		
		list.sort();
		
		System.out.println();
		System.out.println(list.toString());
		
		System.out.println();
		System.out.println(list.isSorted());
		
		System.out.println(list.getMin());
		System.out.println(list.getMax());
	}
}
