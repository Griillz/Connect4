package main;

import java.util.Random;
import java.util.ArrayList;

public class Main {
	
	//ArrayList<Integer> columns = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		int red = 1;
		int yellow = 2;
		int[][] board = new int[6][7];
		ArrayList<Integer> columns = new ArrayList<Integer>();
		makeColumns(columns);
		


		
		for(int i = 0; i < 42; i++){
			if(i % 2 == 0) {
				takeTurn(red, columns, board);
				System.out.println();
			}
			else {
				takeTurn(yellow, columns, board);
				System.out.println();
			}
		}
		
	}
	
	// Prints the board
	public static void printBoard(int[][] board) {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	// Checks if a player has won either horizontally, vertically, or diagonally
	public static void checkWin(int player, int[][] board) {
		int temp = 0;
		int temp2 = 0;
		int count = 0;
		// Horizontal checks
		for(int i = 5; i > -1; i--) {
			for(int j = 0; j < 4; j++) {
				temp = j;
				if(board[i][temp] == player && board[i][temp+1] == player && board[i][temp+2]==player && board[i][temp+3]==player) {

						printBoard(board);
						System.out.println("Player " + player + " Wins horizontally at row " + i);
						System.exit(0);
				}
			}
		}
		// Vertical Checks
		for(int i = 5; i > 3; i--) {
			temp = i;
			for(int j = 0; j < 7; j++) {
				if(board[temp][j] == player && board[temp - 1][j] == player && board[temp - 2][j] == player && board[temp - 3][j] == player) {
					printBoard(board);
					System.out.println("Player " + player + " Wins Vertically at column " + j);
					System.exit(0);
				}
			}
		}
		
		// Diagonal Checks
		
		for(int i = 5; i > 3; i--) {
			temp = i;
			for(int j = 0; j <4; j++) {
				temp2 = j;
				if(board[temp][temp2] == player && board[temp - 1][temp2 + 1] == player && board[temp - 2][temp2 + 2] == player && board[temp - 3][temp2 + 3] == player) {
					printBoard(board);
					System.out.println("Player " + player + " Wins right diagonal starting at row " + temp + " column " + temp2);
					System.exit(0);
				}
			}
		}
		for(int i = 5; i > 3; i--) {
			temp = i;
			for(int j = 6; j > 3; j--) {
				temp2 = j;
				if(board[temp][temp2] == player && board[temp - 1][temp2 - 1] == player && board[temp - 2][temp2 - 2] == player && board[temp - 3][temp2 - 3] == player) {
					printBoard(board);
					System.out.println("Player " + player + " Wins left diagonal starting at row " + temp + " column " + temp2);
					System.exit(0);
				}
			}
		}
	}
	
	// Places a 1 or 2 on the board depending on who's turn it is
	public static void takeTurn(int player, ArrayList<Integer> pick, int[][] board) {
		checkFullCols(pick, board);
		Random rand = new Random();
		int column = rand.nextInt(pick.size());
		int columnPick = pick.get(column);
		for(int i = 0; i < 6; i++) {
			if(board[i][columnPick] != 0 && i != 0) {
				board[i - 1][columnPick] = player;
				break;
			}
			else if(board[i][columnPick] == 0 && i == 5) {
				board[i][columnPick] = player;
			}
		}
		checkWin(player, board);
	}
	
	// Checks if a column is full, if it is, remove it from the ArrayList so it can no longer have a piece placed there
	public static void checkFullCols(ArrayList<Integer> col, int[][] board) {
		for(int i = 0; i < col.size(); i++) {
			if(board[0][col.get(i)] != 0) {
				col.remove(i);
			}
		}
	}
	
	// Sets the ArrayList to have 7 columns. (Ran once at start)
	public static void makeColumns(ArrayList<Integer> col) {
		for(int i = 0; i < 7; i++) {
			col.add(i);
		}
	}
	
	// Prints the ArrayList to see what columns are still available
	public static void checkCols(ArrayList<Integer> col) {
		for(int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i));
		}
	}
			
	
}
