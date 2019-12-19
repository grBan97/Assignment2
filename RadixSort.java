import java.io.File;
import java.io.*; 
import java.util.*; 
  
class Radix { 
	
    /*Driver function to check for above function*/
    public static void main (String[] args) throws FileNotFoundException
    { 
		System.out.println("Radix Sort: ");
		System.out.println("Before sorting: ");
		int[] arr = readFile("D:/algo/data.txt");
        int n = arr.length; 
        radixsort(arr, n); 
		System.out.println("After sorting: ");
        print(arr, n); 
    } 
    
	@SuppressWarnings("resource")
	public static int[] readFile(String f) {
		
		try {
			
		
		File file = new File (f);
		Scanner sc = new Scanner(file);
		int length=0;
		
		
		while(sc.hasNext()) {
			int arr = sc.nextInt();
			System.out.print(arr + " ");
			length++;
		}
		int[] arr = new int[length];
		
		Scanner sc1 = new Scanner(file);
		

		for(int i = 0 ; i<arr.length ; i++)
			arr[i] = sc1.nextInt();
		return arr;
		
		}
		catch (Exception e) {
			return null;
		}
		
	}
  
    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixsort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
    	long startTime = System.nanoTime() ;
		
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("Running time for Radix Sort start : " + startTime);
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
        
        long endTime = System.nanoTime() ;
		System.out.println("Running time for Radix Sort end : " + endTime);
		
		long runTime = endTime - startTime ;
        System.out.println("Running time for Radix Sort : " + runTime + " nanoseconds");
		System.out.println(" ");
    } 
  
    // A utility function to print an array 
    static void print(int arr[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
    } 
  
  

} 