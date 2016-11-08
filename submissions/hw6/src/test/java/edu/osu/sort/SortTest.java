package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortTest  {



    private static List<Integer> randomIntegerArray(int n){
	List numbers = new ArrayList();
	int r_number = 0;
//for loop to add random numbers to the list
	for(int i=0; i<n; i++){
		r_number = ((int) (Math.random() * (n*2)));
		numbers.add(r_number);
	}

	return null;
    }

    /*
    @Test // This test is an example template using an oracle
    public void randomTestExample() {
	int n_runs = 10;
	for(int i=0;i<n_runs;i++){
	    
	    // Generate a random array of size 10
	    List<Integer> sorted = randomIntegerArray(10);

	    // Copy the sorted array before sorting it 
	    List<Integer> original = new ArrayList(sorted);

	    // Sort it
	    Sort.sort(sorted);

	    // Test the result 
	    assertTrue(SortOracle.isSorted(original,sorted));
	}
    }
    
    */
    @Test
    public void randomTestOracle() {    

	int list_size = 0;
	for(int i = 0; i<100; i++){
		list_size = ((int) (Math.random() * (1000)));
		
		List<Integer> sorted = randomIntegerArray(list_size);
		List<Integer> original = new ArrayList(sorted);
		
		//Sort using sort
		Sort.sort(sorted);

		//Sort using SortOracle
		assertTrue(SortOracle.isSorted(original, sorted));

	}
    }

    @Test
    public void randomTestAssertion() {    
	//five test
	int list_size = 100;

	List<Integer> sorted = randomIntegerArray(list_size);
	List<Integer> original = new ArrayList(sorted);

	//for testing the size before and after the sort
	int before_sort = original.size();
	int after_sort = 0;

	//sort using sort and sortOracle
	Sort.sort(sorted);
	if(SortOracle.isSorted(original, sorted) == false){
		System.out.println("error\n");
		return;
	}
   
	//this is for testing the size before the sort
	after_sort = original.size(); 

	//Test 1: that elements are the same in both
	assertTrue(SortOracle.isSorted(original, sorted));

	//Test 2: that elements are of correct size
	assertEquals(before_sort, after_sort);

	//Test 3: This checks that the elements are in different order
	assertTrue(original.get(3) <= original.get(20));

	//test 4: this checks that the last element in the array is the largest
	for(int j =0; j<list_size; j++){
		assertTrue(original.get(j) <= original.get(list_size - 1));
	}

	//Test 5: checks that the 1st elements in the array is the smallest
	for(int k=0; k<list_size; k++){
		assertTrue(original.get(0) <= original.get(k));
	}
    }
}
