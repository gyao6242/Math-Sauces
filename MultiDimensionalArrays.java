import java.util.Arrays;

public class MultiDimensionalArrays {
	public static void main(String[] args) {
		//Test cases
		int[][] test = {{1,2,3,},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(test));
		System.out.println(Arrays.toString(columnSum(test)));
		System.out.println(Arrays.toString(rowSum(test)));
		System.out.println(topLeftDiagSum(test));
		System.out.println(topRightDiagSum(test));
		transpose(test);
		System.out.println(Arrays.deepToString(test));
		verticalReflect(test);
		System.out.println(Arrays.deepToString(test));
		horizontalReflect(test);
		System.out.println(Arrays.deepToString(test));
	}
	/*
	 * Prints a 2d matrix
	 */
	public static void printMatrix(int [][] matrix) {
		for(int[] row : matrix) {
			for(int value : row) {
				System.out.print( value + " ");
			}
		System.out.println();	
		}
	}
	/*
	 * Receives an 2d matrix and returns an array containing the sums of each column
	 */
	public static int[] columnSum(int[][] matrix) {
		int[] sums = new int[matrix[0].length];
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				sums[col] += matrix[row][col];
			}
		}
		return sums;
	}
	/*
	 * Receives an 2d matrix and returns an array containing the sums of each row
	 */
	public static int[] rowSum(int[][] m) {
		int [] sums = new int [m[0].length];
		for(int row = 0; row < m.length; row++) {
			for(int col = 0; col < m[row].length; col++) {
				sums[col] += m[col][row];
			}
		}
		return sums;
	}
	public static int topLeftDiagSum(int[][] m) {
		int sum = 0;
		for(int row = 0; row < m.length; row++) {
					sum += m[row][row];
		}
		return sum;
	}
	public static int topRightDiagSum(int[][] m) {
		int sumTRD = 0;
		for(int row = 0; row < m.length; row++) {
					sumTRD += m[row][m.length - row - 1];
		}
		return sumTRD;
	}
/*
 * Receive a square matrix and modify it to its transpose (reflects diagonally)
 */
	public static void transpose(int[][] m) {
		for(int row = 1; row < m.length; row++) {
			for(int col = 0; col < row; col++) {
				int temp = m[row][col];
				m[row][col] = m[col][row];
				m[col][row] = temp;
			}
		}
	}
	/*
	 * vertical reflection of a matrix
	 */
	public static void verticalReflect(int[][]m) {
		for(int row = 0; row < m.length / 2; row++) {
			for(int col = 0; col < m[row].length; col++) {
				int temp = m[row][col];
				m[row][col] = m[m.length - 1 - row][col];
				m[m.length - 1 - row][col] = temp;
			}
			
		}
	}
	/*
	 * horizontal reflection of a matrix
	 */
	public static void horizontalReflect(int[][]m) {
		for(int row = 0; row < m.length; row++) {
			for(int col = 0; col < m[row].length / 2; col++) {
				int temp = m[row][col];
				int colIndex = m[row].length - 1 - col;
				m[row][col] = m[row][colIndex];
				m[row][colIndex] = temp;
			}
			
		}
	}
}
