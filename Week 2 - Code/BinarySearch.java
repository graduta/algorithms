package week.two;

/**
 * Binary Search using Recursion
 *
 */
public class BinarySearch {
	public static int binarySearch(int x, int lo, int hi, int[] A) {
		if (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (x == A[mid]) {
				return mid;
			} else if (x < A[mid]) {
				return binarySearch(x, lo, mid-1, A);
			} else {
				return binarySearch(x, mid+1 , hi, A);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {3,7,8,11,21,39,40,100,101};
		
		int x = 22;
		
		int pos = binarySearch(x, 0, 9, A);
		System.out.println("Element is on position: " + pos);
	}
}
