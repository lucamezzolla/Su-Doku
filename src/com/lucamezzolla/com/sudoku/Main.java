package com.lucamezzolla.com.sudoku;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Sudoku sudouku = new Sudoku();
		int[][] grid = sudouku.getGrid();
		SudokuFrame sf = new SudokuFrame(grid);
	}

}