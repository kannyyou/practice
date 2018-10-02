package com.changhun.z.game;

import java.util.HashSet;
import java.util.Set;

/**
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

Pinterest

medium

 * @author changhun
 *
 */
public class L36_Valid_Sudoku {
	
	public static class Solution1 {
		public static boolean isValidSudoku(char[][] board) {
		    for(int i = 0; i<9; i++){
		        HashSet<Character> rows = new HashSet<Character>();
		        HashSet<Character> columns = new HashSet<Character>();
		        HashSet<Character> cube = new HashSet<Character>();
		        for (int j = 0; j < 9;j++){
		            if(board[i][j]!='.' && !rows.add(board[i][j]))
		                return false;
		            if(board[j][i]!='.' && !columns.add(board[j][i]))
		                return false;
		            int RowIndex = 3*(i/3);
		            int ColIndex = 3*(i%3);
		            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
		                return false;
		        }
		    }
		    return true;
		}
	}
	
	public static class Solution2 {
		public static boolean isValidSudoku(char[][] board) {
		    Set<String> seen = new HashSet<String>();
		    for (int i=0; i<9; ++i) {
		        for (int j=0; j<9; ++j) {
		            char number = board[i][j];
		            if (number != '.')
		                if (!seen.add(number + " in row " + i) ||
		                    !seen.add(number + " in column " + j) ||
		                    !seen.add(number + " in block " + i/3 + "-" + j/3)) {

		                	System.out.println(number + " at " + i + "," + j + " for " + seen.toString());
		                	return false;

		                }
		        }
		    }
		    return true;
		}
	}

	public static void main(String[] args) {
		char [][] board = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		
		System.out.println(Solution1.isValidSudoku(board));
		System.out.println(Solution2.isValidSudoku(board));

	}
}
