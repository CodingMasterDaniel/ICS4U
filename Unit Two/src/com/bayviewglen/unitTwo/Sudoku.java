package com.bayviewglen.unitTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] sudoku = new int[9][9];
		
		System.out.println("Enter a Sudoku puzzle solution: ");
		
		for (int i = 0; i < 9; i++) {
			char[] x = (input.nextLine()).toCharArray();
			for (int j = 0; j < sudoku[i].length; j++) {
				sudoku[i][j] = (int)x[j] - 48;
			}
		}
		
		boolean result = checkAnswers(sudoku);
		if (result)
			System.out.println("Valid solution");
		else
			System.out.println("Invalid solution");

	}

	private static boolean checkAnswers(int[][] sudoku) {
		for (int i = 0; i < sudoku.length; i++) {
			ArrayList<Integer> x = getArrayList();
			for (int j = 0; j < sudoku[i].length; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		
		for (int i = 0; i < sudoku.length; i++) {
			ArrayList<Integer> x = getArrayList();
			for (int j = 0; j < sudoku[i].length; j++) {
				if (!x.contains(sudoku[j][i]))
					return false;
				else
					x.remove(x.indexOf(sudoku[j][i]));
			}
		}
		
		ArrayList<Integer> x = getArrayList();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		
		
		x = getArrayList();
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 3; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		
		
		x = getArrayList();
		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		x = getArrayList();
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				if (!x.contains(sudoku[i][j]))
					return false;
				else
					x.remove(x.indexOf(sudoku[i][j]));
			}
		}
		
		return true;
	}

	private static ArrayList<Integer> getArrayList() {
		ArrayList<Integer> temp = new ArrayList<Integer>(9);
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(4);
		temp.add(5);
		temp.add(6);
		temp.add(7);
		temp.add(8);
		temp.add(9);
		
		return temp;
	}

}
