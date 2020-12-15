
public class MergeSort extends SortAlgorithm{

	public MergeSort(int speed, int arraySize) {
		super(speed, arraySize);
		// TODO Auto-generated constructor stub
	}
	
	Thread sortingThread;

	public void sort(int arr[], int l, int r) {
		System.out.println("Creating Sorting Thread");
		sortingThread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	System.out.println("Start Sorting");
		    	if (l < r) {
		            // Find the middle point
		            int m = (l + r) / 2;
		 
		            // Sort first and second halves
		            sort(arr, l, m);
		            sort(arr, m + 1, r);
		 
		            // Merge the sorted halves
		            merge(arr, l, m, r);
		        }
		    }
		});  
		sortingThread.start();
		
	}
	
	void merge(int array[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */
		System.out.println("Merging Temp Arrays");

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}
	
	

	@Override
	public void run() {
		sort(array, 0, array.length - 1);

	}

}
