package com.changhun.z.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L51_N_Queens {
    private static Set<Integer> col = new HashSet<Integer>();
    private static Set<Integer> diag1 = new HashSet<Integer>();
    private static Set<Integer> diag2 = new HashSet<Integer>();
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> outout = new ArrayList<List<String>>();
        dfs(outout,new ArrayList<String>(), 0, n);
        return outout;
    }
    
    private static void dfs(List<List<String>> res, List<String> list, int row, int n){
    	System.out.println("dfs " + res.toString() + " " + list.toString() + " " + row + " " + n);
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        //Try each queen.
        for (int i = 0; i < n; i++){
        	//check safe
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) {
            	System.out.println(" oops " + i);
            	continue;
            }
            
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            
            System.out.println(i + " " + rowString);

            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            System.out.println(col.toString());
            System.out.println(diag1.toString());
            System.out.println(diag2.toString());

            
            dfs(res, list, row + 1, n);
            
            System.out.println("Let's remove (backtrack)");
            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
    
    public static void main(String[] args) {
		System.out.println(solveNQueens(4).toString());
	}
}
