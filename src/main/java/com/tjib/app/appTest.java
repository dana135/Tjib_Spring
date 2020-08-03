package com.tjib.app;

import java.util.ArrayList;
import java.util.Arrays;

public class appTest {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		int[] arr1 = {1,2,5};
		ArrayList<int[]> dates = null;
		if(dates == null) {
			dates = new ArrayList<>();
			dates.add(arr);
			dates.add(arr1);
		}
		
		for(int[] array : dates) {
		    System.out.println(Arrays.toString(array));
		}
	
	}
}
