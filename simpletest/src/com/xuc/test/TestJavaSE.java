package com.xuc.test;

import org.junit.Test;

public class TestJavaSE {
	@Test
	public void test1() {

		int[] arr = { 4, 1, 6, 3, 9, 8 };

		
		System.out.println("nvnnvnnvnvndlsdfsfsdfdsf");
		System.out.println("=====what=====");
		System.out.println("othsre   say");
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];

					arr[i] = arr[j];
					arr[j] = temp;

				}

			}
		}

	}
}
