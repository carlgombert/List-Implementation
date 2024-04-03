package main;

public class Main {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();
		
		list1.add(2);
		list1.add(4);
		list1.add(8);
		list1.add(9);
		list1.add(10);
		list1.add(15);
		list1.add(17);
		list1.add(20);
		list1.add(24);
		list1.add(28);
		
		list2.add(3);
		list2.add(5);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		list2.add(10);
		list2.add(16);
		list2.add(17);
		list2.add(18);
		list2.add(19);
		
		list1.exclusiveOr(list2);
		
		System.out.println(list1.toString());
		
		list1.reverse();
		
		System.out.println();
		System.out.println(list1.toString());
	}
}
