package week.three;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
	// Structure to use for our field
	static int[][] matrix;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void setBorders(int n) {
		// Border
		n = n + 2;
		for (int i = 0; i < n; ++i) {
			matrix[0][i] = -2;
			matrix[n - 1][i] = -2;
			matrix[i][0] = -2;
			matrix[i][n - 1] = -2;
		}
	}

	public static void printLabyrinth(int n) {
		for (int i = 0; i < n + 2; ++i) {
			for (int j = 0; j < n + 2; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void generateRandomBombs(int n) {
		Random r = new Random();
		while (n > 0) {
			int i = r.nextInt(5) + 1;
			int j = r.nextInt(5) + 1;
			if (matrix[i][j] == 0) {
				matrix[i][j] = 9;
				n--;
			}
		}
	}
	
	public static void countNeighbours(int n) {
		for (int x = 1; x < n + 2; ++x) {
			for (int y = 1; y < n + 2; ++y) {
				for (int i = 0; i < dx.length; ++i) {
						System.out.println(x + " " + y);
						if (matrix[x + dx[i]][y + dy[i]] == 9 && matrix[x][y] != 9 && matrix[x][y] != -2) {
							matrix[x][y]++;
						} else {
						}
					}
			}
		}
	}
	
	public static void expand(int i, int j) {
		//your turn
	}
	
	public static void main(String[] args) {
		matrix = new int[100][100];
		int n = 5;
		setBorders(n);
		generateRandomBombs(n);
		countNeighbours(n);
		printLabyrinth(n);
		
		Scanner in = new Scanner(System.in);
		
		expand(in.nextInt(), in.nextInt());
		
		
		
		

	}

}
