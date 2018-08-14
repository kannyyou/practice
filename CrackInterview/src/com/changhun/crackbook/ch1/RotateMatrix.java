package com.changhun.crackbook.ch1;

public class RotateMatrix {
	
	/**
	 * for i=0 to n
	 * 	temp = top[i]
	 * 	top[i] = left[i]
	 * 	left[i] = bottom[i]
	 * 	bottom[i] = right[i]
	 * 	right[i] = temp
	 * 
	 * @param matrix
	 * @return
	 */
	public static boolean roateMatrix(int[][] matrix) {
		// length == 0 or row != col
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		
		int n = matrix.length;
		
		for (int layer = 0; layer < n/2 ; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			System.out.println(first + " " + last);
			
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i];
				
				matrix[first][i] = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[i][last];
				
				matrix[i][last] = top;
			}
		}
		
		for (int i=0 ; i< matrix.length ; i++) {
			for (int j=0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int [][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		
		for (int i=0 ; i< a.length ; i++) {
			for (int j=0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		roateMatrix(a);
	}
}
