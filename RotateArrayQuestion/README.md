#
## Problem Statement
Given an array that was initially sorted in ascending order but then rotated at an unknown 
pivot, write an efficient algorithm to find the minimum element in the array. 
• The array contains no duplicate elements. 
• Your solution must run in O(log N) time.
# Input Format: 
• A single integer N denoting the number of elements in the array. 
• A line containing N space-separated integers, representing the rotated sorted array. 
# Output Format: 
• Print a single integer — the minimum element in the rotated array. 
# Constraints: 
• 1 <= N <= 10^5 
• -10^9 <= A[i] <= 10^9 
• No duplicate elements. 
• The array is a rotated version of a sorted array.

Approach 1:
1. Brute Force - (Linear Search) - RotatedArray.py
    Time Complexity: O(N) - Beacause it may traverse the whole array.
    Space Complexity: O(1) - uses only one variable to store min.
2. Optimized (Binary Search) - RotateArray.py
   Time Complexity - O(log N) - Because we repeatedly divide the search space in half using binary search. In the worst case, it takes log₂(N) comparisons to find the minimum element.
   Space Complexity - O(1) -  Only a few variables (low, high, mid) are used for computation. No additional space is required based on input size.
