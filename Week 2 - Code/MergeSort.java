package week.two;

public class MergeSort {
	static int A[] = {5,3,6,7,2,10,15,12,4};
	
	public static void mergeSort(int[] A, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;

			mergeSort(A, lo, mid);
			mergeSort(A, mid+1, hi);
			merge(A, lo, mid, hi);
		}
	}
	
	public static void merge(int[] A, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		int k = lo;
		int[] b = new int[100];
		
		while (i <= mid && j <= hi) {
			if (A[i] <= A[j]) {
				b[k] = A[i];
				++i;
			} else {
				b[k] = A[j];
				++j;
			}
			++k;
		}
		while (i <= mid) {
			b[k] = A[i];
			++k;
			++i;
		}
		
		while (j <= hi) {
			b[k] = A[j];
			++k;
			++j;
		}
		for (i = lo; i <= hi; ++i) {
			A[i] = b[i];
		}
	}
	
	
	public static void main(String[] args) {
		
		mergeSort(A, 0, A.length-1);

		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}
		
	}

}
