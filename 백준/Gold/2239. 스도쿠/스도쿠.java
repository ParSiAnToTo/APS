import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static boolean esc;
	static int[][] sudoku;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sudoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = line.charAt(j) - '0';
			}
		}

		puzzle(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			if (i != 8) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());

	} // end of main

	static void puzzle(int idx) {
		if (idx == 81) {
			esc = true;
			return;
		}
		
		int r = idx / 9;
		int c = idx % 9;

		if (sudoku[r][c] != 0) {
			puzzle(idx + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (!puzzleCheck(r, c, i)) {
					continue;
				}
				sudoku[r][c] = i;
				puzzle(idx + 1);

				if (esc) { // func exit
					return;
				}
				sudoku[r][c] = 0;

			}
		}

	} // end of puzzle

	static boolean puzzleCheck(int r, int c, int num) {
		boolean chk = true;
		// line check
		for (int i = 0; i < 9; i++) {
			if (sudoku[r][i] == num || sudoku[i][c] == num) {
				return false;
			}
		}

		// 3x3 check
		int row = (r / 3) * 3;
		int col = (c / 3) * 3;
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	} // end of puzzleCheck

} // end of class
