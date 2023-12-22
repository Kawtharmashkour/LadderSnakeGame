package ladderAndSnake;

import java.util.Arrays;
import java.util.Scanner;

public interface Checker {

	public static int trialInputCheck(){
		int i;
		final int trials = 4;
		double num;

		Scanner sc = new Scanner(System.in);

		for(i=0; i<trials; i++) {
			
			System.out.print("Enter number: ");
			num = sc.nextDouble();
		
			if((num%1 > 0)){
				System.out.printf("Bad Attempt %d: the number should be integer \n",(i+1));
			}else if(num>=2 && num<=6){
				return ((int)num);
			}else {
				System.out.printf("Bad Attempt %d: number out of range [2-6].\n",(i+1));
			}

		}
		
		System.out.println("Error: you did 4 trials, access game denied!");
		return 1;
	}
	
	public static int[] findDuplicates(int[] arr) {
		boolean foundDuplicate;
		int[] duplicates = new int[0];
		
		for(int i=0; i<arr.length; i++) {
			foundDuplicate = false;
			
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i] == arr[j]) {
					duplicates = Arrays.copyOf(duplicates, duplicates.length+1);
					duplicates[duplicates.length-1] = j+1; //  j+1 represent the player number
					foundDuplicate = true;
				}
			}
				
			if(foundDuplicate) {
				duplicates = Arrays.copyOf(duplicates, duplicates.length+1);
				duplicates[duplicates.length-1] = i+1; //  i+1 represent the player number; 
			}
		}
		
		return duplicates;
	}
	
	
//	public static int[] removeElementFromArray(int[] arr, int index) {
//		int[] newArr = new int[arr.length - 1];
//		int newArrIndex = 0;
//        // Copy elements from the original array to the new array, excluding the element to remove
//        
//        for (int i = 0; i < arr.length; i++) {
//            if (i != index) {
//                newArr[newArrIndex] = arr[i];
//                newArrIndex++;
//            }
//        }
//
//        return newArr;
//	}
	

}
