/* 
 * Class for holding the sudoku grid and inserting the starting numbers
 * @author Even Berge Sandvik
 */
public class Sudoku {

	String sudokuInput = "001000000" + "30760510" + "90500100" + "80070403" + "01000900" + "05000109" + "08070040"
			+ "02006010" + "85063070" + "00000000";
	String sudokuInputEZ = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
	final int size = 9;
	int[][] grid = new int[size][size];

	public void feedSudoku() {
		int x = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = getSudokuNumbers(x);
				x++;
			}
		}
	}

	private int getSudokuNumbers(int x) {
		char[] c = sudokuInput.toCharArray();
		return (int) Character.getNumericValue(c[x]);
	}

	public int[][] getGrid() {
		return grid;
	}

	public int getSize() {
		return size;
	}
}
