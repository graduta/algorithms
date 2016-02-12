package week.three;

/**
 * We are going to mark our matrix as follows : 
 * -starting point will have the value 0 : a[si][sj] = 0;
 * -obstacles or borders will be marked with -1
 * -free zones(cells that we can visit) will be marked with 10000
 *
 */
public class LeeAlgorithm {

	// Structure to use for our labyrinth
	static int[][] matrix;
	static int n = 10;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	
	/**
	 * Check if we are inside the labyrinth or if there is an obstalce
	 * @param x - coordinate
	 * @param y - coordinate
	 * @return - boolean
	 */
	public static boolean check(int x, int y) {
		return (matrix[x][y] == -1);
	}
	
	/**
	 * Initialize the borders of the matrix to make sure we are not getting errors such as : "IndexOutOfBounds"
	 * @param n - int representing how big our matrix is
	 */
	public static void setBorders(int n) {
		for (int i = 0; i <= n + 1; ++i) {
			matrix[0][i] = -1;
			matrix[i][0] = -1;
			matrix[n][i] = -1;
			matrix[i][n] = -1;
		}
	}

	/**
	 * Method to print the whole matrix
	 * @param n
	 */
	public static void printLabyrinth(int n) {
		for (int i = 0; i <= n + 1; ++i) {
			for (int j = 0; j <= n + 1; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Lee Function
	 */
	public static void lee() {
		int xx, yy, i;
		//xx and yy are variables to store the coordinates of future positions
		boolean ok = true;
		while (ok == true) {
			ok = false;
			for (int x = 1; x <= n; ++x) {
				for (int y = 1; y <= n; ++y) {
					if (matrix[x][y] == 10000 || matrix[x][y] == -1) continue;
					for (i = 0; i < 8; ++i) {
						xx = x + dx[i];
						yy = y + dy[i];
						if (check(xx,yy)) continue;
						if (matrix[xx][yy] > matrix[x][y] + 1) {
							matrix[xx][yy] = matrix[x][y] + 1;
							ok = true;
						}
					}
					// Uncomment if you want to see the matrix at each step
//					printLabyrinth(5);
				}
			}
		}
	}

	public static void main(String[] args) {
		matrix = new int[100][100];

		//set the value of each element to 10000 so that we know it is a free zone
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				matrix[i][j] = 10000;
			}
		}
		setBorders(n);
		
		//State where do you want to have your starting point. In this case is position(5,5)
		matrix[5][5] = 0;
		lee();
		
		printLabyrinth(n);
	}

}
