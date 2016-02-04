package week.two;

/**
 * Merging 2 sortes lists
 *
 */
public class Collation {

	public static void main(String[] args) {
		
		int[] A = {1,3,4,5,7,9};
		int[] B = {2,6,8,10, 11, 12};
		
		//The third list in which we do the merge
		int[] C = new int[A.length + B.length + 1];
		
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		
		while (indexA < A.length && indexB < B.length) {
			if (A[indexA] < B[indexB]) {
				C[indexC] = A[indexA];
				indexA++;
			} else {
				C[indexC] = B[indexB];
				indexB++;
			}
			indexC++;
		}
		
		while (indexA < A.length) {
			C[indexC] = A[indexA];
			indexA++;
			indexC++;
		}
		while (indexB < B.length) {
			C[indexC] = B[indexB];
			indexB++;
			indexC++;
		}
		for (int i = 0; i < indexC; ++i) {
			System.out.print(C[i] + " ");
		}
	}

}
