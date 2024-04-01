package main;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(5);
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
		list.add(1);
		
		System.out.println();
		System.out.println(list.toString());
		
		list.removeDuplicates();
		
		System.out.println();
		System.out.println(list.toString());
		
		list.sort();
		
		System.out.println();
		System.out.println(list.toString());
		
		list.reverse();
		
		System.out.println();
		System.out.println(list.toString());
	}
}
