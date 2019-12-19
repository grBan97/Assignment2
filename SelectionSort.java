import java.io.File;
import java.util.Scanner;
class SelectionSort 
{ 
    // Driver code to test above 
    public static void main(String args[]) 
    { 
		System.out.println("Selection Sort: ");
		System.out.println("Before sorting: ");
		int[] arr = readFile("D:/algo/data.txt");
        SelectionSort ob = new SelectionSort(); 
        //int arr[] = {64,25,12,22,11}; 
        ob.sort(arr); 
        System.out.println("Sorted array"); 
        ob.printArray(arr); 
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
	
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        long startTime = System.nanoTime() ;
		
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("Running time for Selection Sort start : " + startTime);
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
        long endTime = System.nanoTime() ;
		System.out.println("Running time for Selection Sort end : " + endTime);
		
		long runTime = endTime - startTime ;
        System.out.println("Running time for Selection Sort : " + runTime + " nanoseconds");
		System.out.println(" ");
    } 
  
    // Prints the array 
    void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  

} 