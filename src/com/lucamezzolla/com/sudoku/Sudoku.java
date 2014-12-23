package com.lucamezzolla.com.sudoku;

public class Sudoku {

	int i0, j0, k0, x, y, z, w, x0, y0, z0, t, g;
	double pp = 0.45;
	int[][][] Q = new int[10][3][3];
	int[][] M = new int[10][10];
	int[][] MM = new int[10][10];
	int[][] grid = new int[10][10];

	public Sudoku() {
		init();
		latin(729);
		count();
		sudoku();
		makeGrid();
	}

	private void init() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 2; j++) {
				for (int k = 0; k <= 2; k++) {
					Q[i][j][k] = 0;
				}
			}
		}
		t = 81;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				M[i][j] = i + j + 1;
				MM[i][j] = 0;
				if (i + j + 1 > 9) {
					M[i][j] = M[i][j] - 9;
				}
			}
		}
	}

	private void latin(int nn) {
		int n = 0;
		while (n < nn) {
			x = (int) Math.floor(Math.random() * 9);
			y = (int) Math.floor(Math.random() * 9);
			z = (int) Math.ceil(Math.random() * 9);
			swap(x, y, z, z);
			n = n + 1;
		}
	}

	void count() {
		for (x = 0; x < 9; x++) {
			int i = (int) Math.floor(x / 3);
			for (int y = 0; y < 9; y++) {
				int j = (int) Math.floor(y / 3);
				if (Q[M[x][y]][i][j] == 0) {
					t--;
				}
				Q[M[x][y]][i][j]++;
			}
		}
	}

	void sudoku() {
		while (t > 0) {
			g = 0;
			while (g == 0) {
				x = (int) Math.floor(Math.random() * 9);
				y = (int) Math.floor(Math.random() * 9);
				z = (int) Math.ceil(Math.random() * 9);
				i0 = (int) Math.floor(x / 3);
				j0 = (int) Math.floor(y / 3);
				if (Q[z][i0][j0] == 0 && Q[M[x][y]][i0][j0] > 1) {
					g = 1;
				}
			}
			swapQ(x, y, z, z);
		}
	}

	void swap(int x, int y, int z, int w) {
		z0 = M[x][y];
		if (z0 == w) {
			M[x][y] = z;
			return;
		}
		y0 = (int) Math.floor(Math.random() * 9);
		while (!(M[x][y0] == w)) {
			y0 = y0 + 1;
			if (y0 >= 9) {
				y0 = y0 - 9;
			}
		}
		x0 = (int) Math.floor(Math.random() * 9);
		while (!(M[x0][y] == w)) {
			x0 = x0 + 1;
			if (x0 >= 9) {
				x0 = x0 - 9;
			}
		}
		M[x][y] = z;
		M[x][y0] = z0;
		M[x0][y] = z0;
		swap(x0, y0, w, z0);
	}

	void swapQ(int x, int y, int z, int w) {
		z0 = M[x][y];
		int i = (int) Math.floor(x / 3);
		int j = (int) Math.floor(y / 3);
		if (z0 == w) {
			Q[z0][i][j]--;
			if (Q[z0][i][j] == 0) {
				t++;
			}
			Q[z][i][j]++;
			if (Q[z][i][j] == 1) {
				t--;
			}
			M[x][y] = z;
			return;
		}
		y0 = (int) Math.floor(Math.random() * 9);
		while (!(M[x][y0] == w)) {
			y0 = y0 + 1;
			if (y0 >= 9) {
				y0 = y0 - 9;
			}
		}
		x0 = (int) Math.floor(Math.random() * 9);
		while (!(M[x0][y] == w)) {
			x0 = x0 + 1;
			if (x0 >= 9) {
				x0 = x0 - 9;
			}
		}
		i0 = (int) Math.floor(x0 / 3);
		j0 = (int) Math.floor(y0 / 3);
		Q[z0][i][j]--;
		if (Q[z0][i][j] == 0) {
			t++;
		}
		Q[z][i][j]++;
		if (Q[z][i][j] == 1) {
			t--;
		}
		Q[z0][i][j0]++;
		if (Q[z0][i][j0] == 1) {
			t--;
		}
		Q[w][i][j0]--;
		if (Q[w][i][j0] == 0) {
			t++;
		}
		Q[z0][i0][j]++;
		if (Q[z0][i0][j] == 1) {
			t--;
		}
		Q[w][i0][j]--;
		if (Q[w][i0][j] == 0) {
			t++;
		}
		M[x][y] = z;
		M[x][y0] = z0;
		M[x0][y] = z0;
		swapQ(x0, y0, w, z0);
	}

	void makeGrid() {
		int row;
		int col;
		for (row = 0; row < 9; row++) {
			for (col = 0; col < 9; col++) {
				grid[row][col] = Integer.valueOf(M[row][col]);
				MM[row][col] = M[row][col];
			}
		}
	}

	public int[][] getGrid() {
		return grid;
	}

}