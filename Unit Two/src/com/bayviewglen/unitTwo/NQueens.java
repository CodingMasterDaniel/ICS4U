package com.bayviewglen.unitTwo;

import java.util.Scanner;
import java.util.Stack;

public class NQueens {

	private static Stack<Queen> queens = new Stack<Queen>();
	private static int n;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a number: ");
		n = Integer.parseInt(input.nextLine());
		int filled = 0;
		int col = 0;
		boolean solvable = true;

		while (filled < n && solvable) {
			
			Queen tempQueen = new Queen(filled, col);
			
			if (col >= n) {
				if (!queens.isEmpty()) {
					tempQueen = queens.pop();
					col = tempQueen.getCol() + 1;
					filled--;
				} else {
					System.out.println("Unsolvable");
					solvable = false;
				}
			} else if (conflict(tempQueen)) {
					col++;
				
			} else {
				
				filled++;
				col = 0;
				queens.push(tempQueen);
			}
			
			if (filled == n) {
				displayBoard();
			}
			 

			
		}

		input.close();


	}

	private static void displayBoard() {
		int[][] board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		
		int size = queens.size();
		
		for (int i = 0; i < size; i++) {
			Queen temp = queens.pop();
			int x = temp.getRow();
			int y = temp.getCol();
			
			board[x][y] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q ");
				}else{
					System.out.print("X ");
				}
			}
			System.out.println("");
		}
	}

	private static boolean conflict(Queen x) {
		int row = x.getRow();
		int col = x.getCol();

		for (int i = 0; i < queens.size(); i++) {
			int row2 = queens.get(i).getRow();
			int col2 = queens.get(i).getCol();

			if (row == row2) {
				return true;
			}
			
			if (col == col2) {
				return true;
			}
			
			double xDistance = (double)Math.abs(row2 - row);
			double yDistance = (double)Math.abs(col2 - col);
			
			for (int j = 0; j < n; j++) {
				if (Math.sqrt(xDistance * xDistance + yDistance * yDistance) == j * Math.sqrt(2))
					return true;
			}
		}

		return false;
	}

}
