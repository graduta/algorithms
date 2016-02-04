package week.two;

public class QuickSortLomuto {

	public static void quicksortLomuto(int[] A, int lo, int hi) {
		if (lo <= hi) {
			int p = partition(A, lo, hi);
			quicksortLomuto(A, lo, p - 1);
			quicksortLomuto(A, p + 1, hi);
		}
	}
	
	public static int partition(int[] A, int lo, int hi) {
		int pivot = A[hi];
		int i = lo;
		for (int j = lo; j < hi; ++j) {
			if (A[j] < pivot) {
				int aux = A[j];
				A[j] = A[i];
				A[i] = aux;
				i++;
			}
			//Uncomment the lines below if you want to see all the steps
/*			for (int k = 0; k < A.length; ++k) {
//				System.out.print(A[k] + " ");
//			}
			System.out.println(); */
		}
		int aux = A[i];
		A[i] = A[hi];
		A[hi] = aux;
		return i;
	}

	
	public static void main(String[] args) {
			int[] A = {3, 4, 1, 2, 6, 3};
			
			//Lomuto
			quicksortLomuto(A, 0, A.length-1);

			for (int i = 0; i < A.length; ++i) {
				System.out.print(A[i] + " ");
			}
	}
}
