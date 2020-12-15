
public class SelectionSort extends SortAlgorithm{
	public SelectionSort(int speed, int arraySize) {
		super(speed, arraySize);
		// TODO Auto-generated constructor stub
	}

	public void sort() {
		int n = array.length; 

		for (int i = 0; i < n-1; i++) 
		{ 
			// Find the minimum element in unsorted array 
			int min_idx = i; 
			for (int j = i+1; j < n; j++) 
				if (array[j] < array[min_idx]) 
					min_idx = j; 

			// Swap the found minimum element with the first 
			// element 
			swap(min_idx, i);
			//					for(int e : array) {
			//						System.out.print(e + ", ");
			//					}
		}

	}  

}
