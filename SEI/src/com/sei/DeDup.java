package com.sei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 *  - removeDups2 method uses LinkedHashSet to take care of point #4 [retain the input order]
 *  - removeDups1 and removeDups2 methods takes more memory due to the use of HashSet and LinkedHashSet 
 *  - removeDups3 uses sort which has runtime of nlogn
 *  
 *  - Answer to 5a --> choose one the methods depending on acceptable big O runtime and memory space usage
 */

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public int[] removeDups1(final int[] randomIntegers) {

		if (randomIntegers == null || randomIntegers.length == 0)
			return new int[0];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			set.add(randomIntegers[i]);
		}

		int[] ints = new int[set.size()];
		int index = 0;
		for (Object i : set) {
			ints[index++] = (Integer) i;
		}

		return ints;
	}
	
	public int[] removeDups2(final int[] randomIntegers) {

		if (randomIntegers == null || randomIntegers.length == 0)
			return new int[0];
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			set.add(randomIntegers[i]);
		}

		int[] ints = new int[set.size()];
		int index = 0;
		for (Object i : set) {
			ints[index++] = (Integer) i;
		}

		return ints;
	}
	
	public int[] removeDups3(final int[] randomIntegers) {

		if (randomIntegers == null || randomIntegers.length == 0)
			return new int[0];
		
		Arrays.sort(randomIntegers);
		
		
		   //compact the array into the result.
	    int[] intermediateResult = new int[randomIntegers.length];
	    int count = 0;
	    int prev = Integer.MIN_VALUE;
	    for( int i = 0; i < randomIntegers.length; i++ ){
	        if( randomIntegers[i] != prev ){
	            intermediateResult[count] = randomIntegers[i];
	            count++;
	        }
	        prev = randomIntegers[i];
	    }

	    int[] result = new int[count];
	    System.arraycopy(intermediateResult, 0, result, 0, count);

	    return result;
	    
	}

	public static void main(String[] args) {

		DeDup test = new DeDup();
		int[] intArray1 = test.removeDups1(test.randomIntegers);

		for (int j = 0; j < intArray1.length; j++) {
			System.out.print(intArray1[j] + " ");
		}

		
		System.out.println();
		
		int[] intArray2 = test.removeDups2(test.randomIntegers);

		for (int j = 0; j < intArray2.length; j++) {
			System.out.print(intArray2[j] + " ");
		}
		
		
		System.out.println();
		
		int[] intArray3 = test.removeDups3(test.randomIntegers);

		for (int j = 0; j < intArray3.length; j++) {
			System.out.print(intArray3[j] + " ");
		}
	}
}
