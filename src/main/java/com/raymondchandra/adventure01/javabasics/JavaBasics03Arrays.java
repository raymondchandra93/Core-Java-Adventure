package com.raymondchandra.adventure01.javabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaBasics03Arrays {

	public static void main(String[] args) {
		// Arrays
		// -- Create
		int[] nums = new int[3];
		int[] nums2 = {1, 2, 3};
		
		// -- Add
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		
		// -- Copy
		int[] nums3 = new int[3];
		System.arraycopy(nums2, 0, nums3, 0, 3);
		
		// -- Read
		System.out.println("First number from nums3: " + nums3[0]);
		
		// -- Read All
		System.out.println("Numbers:");
		System.out.println(Arrays.toString(nums3));
		for (int num : nums3) {
			System.out.println(num);
		}
	}

}
