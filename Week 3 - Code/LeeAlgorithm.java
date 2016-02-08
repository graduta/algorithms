package week.three;

public class LeeAlgorithm {

	// Structure to use for our labyrinth
	static int[][] matrix;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void setBorders(int n) {
		// Border
		n = n + 2;
		for (int i = 0; i < n; ++i) {
			matrix[0][i] = -1;
			matrix[n - 1][i] = -1;
		}
		for (int i = 0; i < n; ++i) {
			matrix[i][0] = -1;
			matrix[i][n - 1] = -1;
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

	public static void lee(int x, int y) {
		for (int i = 0; i < dx.length; ++i) {
			if (matrix[x + dx[i]][y + dy[i]] != -1
					&& (matrix[x + dx[i]][y + dy[i]] > matrix[x][y] + 1 || matrix[x
							+ dx[i]][y + dy[i]] == 0) && (x+dx[i] != 1 || y+dy[i] !=1)) {
				matrix[x + dx[i]][y + dy[i]] = matrix[x][y] + 1;
				printLabyrinth(5);
				lee(x + dx[i], y + dy[i]);
			} else {
			}
		}

	}

	public static void main(String[] args) {
		matrix = new int[100][100];

		setBorders(5);
		lee(1, 1);
		printLabyrinth(5);
	}

}
