package com.changhun.apple.leetcode;


/**
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


 * This very nice idea is from rantos22's solution who sadly only commented "You are not expected to understand that :)", which I guess is the reason it's now it's hidden among the most downvoted solutions. I present an explanation and a more usual implementation.

Explanation

Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Because it's not fully sorted, we can't do normal binary search. But here comes the trick:

If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

If target is let's say 7, then we adjust nums to this:
[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

And then we can simply do ordinary binary search.

Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look at. And the adjustment is done by comparing both the target and the actual element against nums[0].

Code

If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]. Otherwise we use -infinity or +infinity as needed.

int search(vector<int>& nums, int target) {
    int lo = 0, hi = nums.size();
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        
        double num = (nums[mid] < nums[0]) == (target < nums[0])
                   ? nums[mid]
                   : target < nums[0] ? -INFINITY : INFINITY;
                   
        if (num < target)
            lo = mid + 1;
        else if (num > target)
            hi = mid;
        else
            return mid;
    }
    return -1;
}

 * @author changhun
 *
 */
public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
	    if (nums == null || nums.length == 0) return -1;

	    int first = nums[0], l = 0, r = nums.length-1;

	    while (l <= r) {
	        int m = (l + r) / 2;

	        if (target == nums[m]) {
	            return m;
	        }

	        if (nums[m] < first && target >= first) {
	            r = m - 1;
	        } else if (nums[m] >= first && target < first) {
	            l = m + 1;
	        } else if (nums[m] < target) {
	            l = m + 1;
	        } else {
	            r = m - 1;
	        }
	    }
	    
	    return -1;
	}
		
	public static void main(String[] args) {
		int [] array = {4,5,6,7,0,1,2};
		
		System.out.println(search(array, 0));
		System.out.println(search(array, 7));
		System.out.println(search(array, 3));


	}
}
