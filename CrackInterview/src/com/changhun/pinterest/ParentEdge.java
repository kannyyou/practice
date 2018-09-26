//package com.changhun.pinterest;
//
//public class ParentEdge {
//
//}
//
//
///**
//import java.io.*;
//import java.util.*;
//
///*
//Problem :
//
//Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.
//
//For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
//            
//1   2   4
// \ /   / \
//  3   5   8
//   \ / \   \
//    6   7   9
//
//Write a function that, for two given individuals in our dataset, returns true if and only if they share at least one ancestor.
//
//Sample input and output:
//parentChildPairs, 3, 8 => false
//parentChildPairs, 5, 8 => true
//parentChildPairs, 6, 8 => true
//
//
//find command ancestor.
//
//
//
//
//*/
//
//class Solution {
//  /**
//  
//  
//  
//  */
//  
//  public static boolean haveCommonAncestor(int[][] pairs, int node1, int node2) {
//    Map<Integer, List<Integer> // key parents, list has all its childs. 
//    <4 , (5,7,6,8,9)
//    (4, [8])
//  
//   (8,9) // 
//      
//  }
//  
//  
//  
//  public static List<List<Integer>> getRelation(int[][] pairs) {
//    HashMap<Integer, Integer> parentMap = new HashMap<Integer, Integer>(); 
//    //key individual, value # of parents
//    
//    for (int [] edge : pairs) {
//      //{1,3}
//      int ind = edge[1];
//      int parent = edge[0];
//      
//      
//      Integer numPar = parentMap.get(ind);
//
//      
//      
//      if (numPar == null) {
//        parentMap.put(ind, 0);
//        numPar = parentMap.get(ind);
//      }
//      parentMap.put(ind, numPar + 1);
//      
//      Integer numPar2 = parentMap.get(parent);
//      if (numPar2 == null) {
//        parentMap.put(parent, 0);
//        numPar2 = parentMap.get(parent);
//      }
//      parentMap.put(parent, numPar2);
//
//    }
//    
//    System.out.println(parentMap.toString());
//    
//    List<Integer> noParent = new ArrayList<Integer>();
//    List<Integer> singleParent = new ArrayList<Integer>();
//
//    for(Map.Entry<Integer, Integer> entry: parentMap.entrySet()) {
//      if (entry.getValue() == 0) noParent.add(entry.getKey());
//      if (entry.getValue() == 1) singleParent.add(entry.getKey());
//
//    }
//         
//    List<List<Integer>> ret = new ArrayList<>();
//    ret.add(noParent);
//    ret.add(singleParent);
//    return ret;
//  }
//  
//  public static void main(String[] args) {
//    int[][] parentChildPairs = new int[][] {
//        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
//        {4, 5}, {4, 8}, {8, 9}
//    };
//    
//    System.out.println(getRelation(parentChildPairs).toString());
//      
//  }
//}
//
//
///* 
//Your previous Markdown content is preserved below:
//
//Welcome to the Interview!
// */
// */
//*/