import java.util.Arrays;
import java.util.Random;

public class Assign4 {
	

	public static void main(String[] args)
	{
		
		int size = 11;
		Number arr[] = new Number[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        
        System.out.println("Array length = " + size);
        //Random Array
        for (int count = 10; count > 0; count = count - 5)
		{
			System.out.println(count + " items in array.");
			
         testSort(1, false, "selection sort", count, arr);
         testSort(2, false, "insertion sort", count, arr);
         testSort(3, false, "merge sort", count, arr);
         
		}
        
        //Array already sorted
        Arrays.sort(arr);
        for (int count = 10; count > 0; count = count - 5)
		{
			System.out.println(count + " items in array.");
			
         testSort(1, false, "selection sort", count, arr);
         testSort(2, false, "insertion sort", count, arr);
         testSort(3, false, "merge sort", count, arr);
         
		}

        //Array with reverse order
        for (int i = 0; i <= arr.length / 2; i++) {
            int t = (int) arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = t;
        }
        for (int count = 11; count > 0; count = count - 5)
		{
			System.out.println(count + " items in array.");
			
         testSort(1, false, "selection sort", count, arr);
         testSort(2, false, "insertion sort", count, arr);
         testSort(3, false, "merge sort", count, arr);
         
		}
        
        
        
        
        
	}
	
	public static void testSort(int sort, boolean print, String name, int n, Number arr[])
	{
		
		System.out.println("\nTesting " + name + ":");

		Number[] array = new Number[10];
      	copyArray(array, arr);
      	System.out.println("\nBefore sort:");
      	display(array, n);

		if (print)
		{
			System.out.println("\nBefore sort:");
			display(array, n);
		} // end if
		
		switch (sort)
		{
         case 1: SortArray.selectionSort(array, n); break;
         case 2: SortArray.insertionSort(array, n); break;
         case 3: SortArray.iterativeMergeSort(array, n); break;
         
		} // end switch
		
		if (print)
		{
			System.out.println("After sort:");
			display(array, n);
		} // end if
		
		check(array, n);
	} 
	
	public static void display(Object[] array, int n)
	{
		for (int index = 0; index < n; index++)
			System.out.println(array[index]);
		System.out.println();
	} // end display

	public static void copyArray(Object[] copy, Object[] array)
	{
		for (int index = 0; index < array.length; index++)
			copy[index] = (int)array[index];
	} // end copyArray
	
	public static void check(Number[] array, int n)
	{
		if (isSorted(array, n))
			System.out.println("Method works.\n");
		else
			System.out.println("Method DOES NOT work!!!!!!!!!!!!!!!!!!!!!!!!\n");		
	} // end check
	
	public static boolean isSorted(Number[] array, int n)
	{
		boolean sorted = true;
		for (int index = 0; sorted && (index < n - 1); index++)
		{
			if (array[index].compareTo(array[index + 1]) > 0)
				sorted = false;
		} // end for
		
		return sorted;
	}
}
