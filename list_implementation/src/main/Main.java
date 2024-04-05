package main;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<>();
		
		list.add(21);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(12);
		list.add(21);
		list.add(9);
		
		list.sort();
		list.removeDuplicates();
		
		System.out.println(list.toString());
		
		
		
	}
	
	public static String[] generateRandomStringArray(int size) {
        String[] array = new String[size];
        Random random = new Random();
        String[] possibleStrings = new String[] { "One Piece", "Fullmetal Alchemist", "Attack On Titan", "Tokyo Ghoul",
                "Haikyuu!!", "Mob Psycho", "Hunter x Hunter",
                "The Promised Neverland", "Solo Leveling", "The Breaker", "One Punch Man", "Dragon Ball Z",
                "JoJo's Bizarre Adventure", "Yuri!!! on ICE" };
        
        for (int i = 0; i < size; i++) {
            // Generate a random index to pick a string from possibleStrings array
            int randomIndex = random.nextInt(possibleStrings.length);
            array[i] = possibleStrings[randomIndex];
        }
        for(int n = 0; n < array.length; n++) {
    		System.out.println(array[n]);
    	}
        System.out.println();
        return array;
    }
}
