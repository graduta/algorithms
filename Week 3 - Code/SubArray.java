package week.three;

public class SubArray {
	static int[] S = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
	static int n;
	
	/**
	 * O(n^3)
	 */
	public static void subArrayOn3() {
		int bestSum = - 10000;
		int indStart = 0;
		int indEnd = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				int sum = 0;
				for (int k = i; k <= j; ++k) sum += S[k];
				if (sum > bestSum) {
					bestSum = sum;
					indStart = i;
					indEnd = j;
				}
			}
		}
		
		for (int i = indStart; i <= indEnd; ++i) {
			System.out.print(S[i] + " ");
		}
	}
	/**
	 * O(n^2)
	 */
	public static void subArrayOn2() {
		int bestSum = - 10000;
		int indStart = 0;
		int indEnd = 0;
		for (int i = 0; i < n; ++i) {
			int sum = 0;
			for (int j = i; j < n; ++j) {
				sum += S[j];
				if (sum > bestSum) {
					bestSum = sum;
					indStart = i;
					indEnd = j;
				}
			}
		}
		
		for (int i = indStart; i <= indEnd; ++i) {
			System.out.print(S[i] + " ");
		}
	}
	
	/**
	 * O(n)
	 */
	public static void subArrayOn() {
		int bestSum = -10000;
		int min = S[0], indStart = 0, indEnd = 0, index = 0;
		int[] sums = new int[100];
		
		//Calculate the sum from position 0 to position i;
		sums[0] = S[0];
		for (int i = 1; i < n; ++i) {
			//Calculate the sum from position 0 to position i;
			sums[i] = S[i] + sums[i-1];
			if (bestSum < sums[i] - min) {
				bestSum = sums[i] - min;
				indStart = index + 1;
				indEnd = i;
			}
			if (min > sums[i]) {
				min = sums[i];
				index = i;
			}
			System.out.println(bestSum + " " + indStart + " " + indEnd + " " + min + " " + index);
		}
		for (int i = indStart; i <= indEnd; ++i) {
			System.out.print(S[i] + " ");
		}
	}
	
	/**
	 * Dynamic Programming - O(n)
	 */
	public static void subArrayDynamic() {
		int bestSum = -10000;
		int min = 0, sum = 0, indStart = 0, indEnd = 0, index = 0;
		
		for (int i = 0; i < n; ++i) {
			if (sum < 0) {
				sum = S[i];
				index = i;
			} else {
				sum += S[i];
			}
			if (bestSum < sum) {
				bestSum = sum;
				indStart = index;
				indEnd = i;
			}
		}
		
		for (int i = indStart; i <= indEnd; ++i) {
			System.out.print(S[i] + " ");
		}
		
	}
	public static void main(String[] args) {
		n = S.length;
		
		subArrayOn3();
		System.out.println();
		
		subArrayOn2();
		System.out.println();
		
		subArrayOn();
		System.out.println();
		
		subArrayDynamic();
	}

}
