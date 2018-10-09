
/*
 * Class for solving the sudoku
 * @author Even Berge Sandvik
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Launcher {
	static Sudoku sudoku = new Sudoku();
	static int[][] sudokuGrid;
	static int size, x, i, j;
	static ArrayList[][] elementList;// saves checklists in grid's elements
	static ArrayList checkList = new ArrayList();

	public static void main(String args[]) {
		sudoku.feedSudoku();
		size = sudoku.getSize();
		sudokuGrid = sudoku.getGrid();
		elementList = new ArrayList[size][size];

		Solver();
		writeOutGrid();
	}

	private static void Solver() {
		for (int temp = 0; temp < 100; temp++) {// replace this line.
												// while(finished).
												// finished=false
			for (i = 0; i < size; i++) {
				for (j = 0; j < size; j++) {
					checkList.clear();// resets the checkList
					if (sudokuGrid[i][j] == 0) {
						// adds the numbers which are to be potentially checked
						// off
						Collections.addAll(checkList, 1, 2, 3, 4, 5, 6, 7, 8, 9);
						/*
						 * checks and removes the numbers which are horizontal
						 * and vertical to the current element
						 */
						checkHorizontalVertical(i, j);
						// checks the surounding square
						checkSquare(i, j);
						putElementIntoGrid();
					} else {
						Collections.addAll(checkList, 0);
					}
					// if only one solution, replace the element 0 with
					// remaining number
					System.out.println("i:" + i + " j:" + j + " " + checkList);
					elementList[i][j] = checkList;// TODO: error is here
					System.out.println("elementList " + elementList[i][j] + " i:" + i + " j:" + j);
					System.out.println(elementList[0][0]);// changes value to
															// newest
				}
			}
		}
		// make method which checks every elements checklist and looks for a
		// unique value
		checkElementsCheckList();
	}

	private static void putElementIntoGrid() {
		if (checkList.size() == 1) {
			sudokuGrid[i][j] = (int) checkList.get(0);
		}
	}

	private static void checkElementsCheckList() {
		System.out.println(elementList[0][0]);
		System.out.println(elementList[0][1]);
		System.out.println(elementList[1][1]);
		System.out.println(elementList[1][0]);
		System.out.println(elementList[2][1]);
		for (i = 0; i < size; i++) {
			for (i = 0; i < size; i++) {
				for (x = 0; x < elementList.length; x++) {
					if (x != j && x + j <= size) {
						System.out.println("#elementList i:" + i + " x:" + x);
						System.out.println(elementList[i][x]);
						System.out.println(elementList[i][j]);
						// elementList[i][j].removeAll(elementList[i][x]);
					}
					if (x != i && x + j <= size) {
						// elementList[i][j].removeAll(elementList[x][j]);
					}
				}
				putElementIntoGrid();
			}
		}

	}

	private static void checkSquare(int i, int j) {
		if (i < 3 && j < 3) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[0][0]);
			checkList.remove((Object) sudokuGrid[1][0]);
			checkList.remove((Object) sudokuGrid[2][0]);
			checkList.remove((Object) sudokuGrid[0][1]);
			checkList.remove((Object) sudokuGrid[1][1]);
			checkList.remove((Object) sudokuGrid[2][1]);
			checkList.remove((Object) sudokuGrid[0][2]);
			checkList.remove((Object) sudokuGrid[1][2]);
			checkList.remove((Object) sudokuGrid[2][2]);
		} else if (i >= 3 && i < 6 && j < 3) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[3][0]);
			checkList.remove((Object) sudokuGrid[4][0]);
			checkList.remove((Object) sudokuGrid[5][0]);
			checkList.remove((Object) sudokuGrid[3][1]);
			checkList.remove((Object) sudokuGrid[4][1]);
			checkList.remove((Object) sudokuGrid[5][1]);
			checkList.remove((Object) sudokuGrid[3][2]);
			checkList.remove((Object) sudokuGrid[4][2]);
			checkList.remove((Object) sudokuGrid[5][2]);
		} else if (i >= 6 && j < 3) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[6][0]);
			checkList.remove((Object) sudokuGrid[7][0]);
			checkList.remove((Object) sudokuGrid[8][0]);
			checkList.remove((Object) sudokuGrid[6][1]);
			checkList.remove((Object) sudokuGrid[7][1]);
			checkList.remove((Object) sudokuGrid[8][1]);
			checkList.remove((Object) sudokuGrid[6][2]);
			checkList.remove((Object) sudokuGrid[7][2]);
			checkList.remove((Object) sudokuGrid[8][2]);
		} else if (i < 3 && j < 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[0][3]);
			checkList.remove((Object) sudokuGrid[1][3]);
			checkList.remove((Object) sudokuGrid[2][3]);
			checkList.remove((Object) sudokuGrid[0][4]);
			checkList.remove((Object) sudokuGrid[1][4]);
			checkList.remove((Object) sudokuGrid[2][4]);
			checkList.remove((Object) sudokuGrid[0][5]);
			checkList.remove((Object) sudokuGrid[1][5]);
			checkList.remove((Object) sudokuGrid[2][5]);
		} else if (i >= 3 && i < 6 && j < 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[3][3]);
			checkList.remove((Object) sudokuGrid[4][3]);
			checkList.remove((Object) sudokuGrid[5][3]);
			checkList.remove((Object) sudokuGrid[3][4]);
			checkList.remove((Object) sudokuGrid[4][4]);
			checkList.remove((Object) sudokuGrid[5][4]);
			checkList.remove((Object) sudokuGrid[3][5]);
			checkList.remove((Object) sudokuGrid[4][5]);
			checkList.remove((Object) sudokuGrid[5][5]);
		} else if (i >= 6 && j < 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[6][3]);
			checkList.remove((Object) sudokuGrid[7][3]);
			checkList.remove((Object) sudokuGrid[8][3]);
			checkList.remove((Object) sudokuGrid[6][4]);
			checkList.remove((Object) sudokuGrid[7][4]);
			checkList.remove((Object) sudokuGrid[8][4]);
			checkList.remove((Object) sudokuGrid[6][5]);
			checkList.remove((Object) sudokuGrid[7][5]);
			checkList.remove((Object) sudokuGrid[8][5]);
		} else if (i < 3 && j > 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[0][6]);
			checkList.remove((Object) sudokuGrid[1][6]);
			checkList.remove((Object) sudokuGrid[2][6]);
			checkList.remove((Object) sudokuGrid[0][7]);
			checkList.remove((Object) sudokuGrid[1][7]);
			checkList.remove((Object) sudokuGrid[2][7]);
			checkList.remove((Object) sudokuGrid[0][8]);
			checkList.remove((Object) sudokuGrid[1][8]);
			checkList.remove((Object) sudokuGrid[2][8]);
		} else if (i >= 3 && i < 6 && j > 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[3][6]);
			checkList.remove((Object) sudokuGrid[4][6]);
			checkList.remove((Object) sudokuGrid[5][6]);
			checkList.remove((Object) sudokuGrid[3][7]);
			checkList.remove((Object) sudokuGrid[4][7]);
			checkList.remove((Object) sudokuGrid[5][7]);
			checkList.remove((Object) sudokuGrid[3][8]);
			checkList.remove((Object) sudokuGrid[4][8]);
			checkList.remove((Object) sudokuGrid[5][8]);
		} else if (i >= 6 && j > 6) {// hvert tredje element
			checkList.remove((Object) sudokuGrid[6][6]);
			checkList.remove((Object) sudokuGrid[7][6]);
			checkList.remove((Object) sudokuGrid[8][6]);
			checkList.remove((Object) sudokuGrid[6][7]);
			checkList.remove((Object) sudokuGrid[7][7]);
			checkList.remove((Object) sudokuGrid[8][7]);
			checkList.remove((Object) sudokuGrid[6][8]);
			checkList.remove((Object) sudokuGrid[7][8]);
			checkList.remove((Object) sudokuGrid[8][8]);
		}

	}

	private static void checkHorizontalVertical(int i, int j) {
		for (x = 0; x < size; x++) {
			if (sudokuGrid[x][j] != 0 && x != i) {// checks vertical
				checkList.remove((Object) sudokuGrid[x][j]);
			}
			if (sudokuGrid[i][x] != 0 && x != j) {// checks horizontal
				checkList.remove((Object) sudokuGrid[i][x]);
			}
		}
	}

	private static void writeOutGrid() {
		System.out.println("Solution: ");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(sudokuGrid[i][j]);
			}
			System.out.println();
		}
	}
}