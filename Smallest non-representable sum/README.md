# Smallest Non-Representable Sum



### Problem Description:

#### Scenario: 

You are designing a secure digital wallet system. Each user has a set of coin denominations 

(represented as a sorted array of positive integers). For internal validation, you must 

determine the smallest amount of money that cannot be formed using any subset of the 

given denominations. 

This functionality is crucial for detecting missing denominations and optimizing wallet 

design. The challenge? You need to solve this efficiently – in linear time relative to the size 

of the input array.



##### Input Format: 

• A single line containing space-separated sorted positive integers: 

a1 a2 a3 ... an 

##### Output Format: 

• Print a single integer: the smallest positive integer that cannot be formed as the sum 

of any subset of the array. 

##### Constraints: 

• 1 <= N <= 10^5 

• 1 <= a\[i] <= 10^9 

• The input array is sorted in increasing order 

• All elements are positive integers  



##### Solution Approaches

1. ###### Knapsack Dynamic Programming (Subset Sum DP) - Optimized approach

&nbsp;   The goal of this code is to check whether an array can be split into two subsets with equal

&nbsp;   sum.

&nbsp;   🔍 Logic Behind the Code (Brief \& Clear):

&nbsp;    1.Total Sum:

&nbsp;      Calculate the sum of all elements.

&nbsp;      If the sum is odd, you cannot divide it into two equal integers → return false.



&nbsp;    2.Target Sum:

&nbsp;      If total sum is even, the target for each subset is sum / 2.



&nbsp;    3.Dynamic Programming (1D dp array):

&nbsp;      dp\[i] means subset sum i is possible.

&nbsp;      Initialize with dp = true (### ✅ Explanation of the Code (Short \& Clear)

&nbsp;   This Java program determines whether a given array of integers can be split into two subsets 

&nbsp;   with equal sums — a classic dynamic programming problem known as the "Partition Equal Subset 

&nbsp;   Sum".



Time and Space Complexity:

* Time Complexity: O(n \* sum/2)

&nbsp;   Where n is the number of elements in the array, and sum/2 is the target subset sum.



* Space Complexity: O(sum/2)

&nbsp;   One-dimensional dp array is used of size target + 1.



###### 2.Recursive Backtracking (Subset Sum via Recursion) - Brute Force

&nbsp; a. Goal: Check if the array can be split into two subsets with equal sum (i.e., does a subset 

&nbsp;    sum to half of the total).



&nbsp; b. Method:

* &nbsp;   First, calculate the total sum. If it’s odd, immediately return false.
* &nbsp;   Call a recursive function to try each possibility:
* &nbsp;     At each step, decide to either include the current number in the subset or exclude it.
* &nbsp;     Base cases:

&nbsp;          If target == 0: found a subset, return true.

&nbsp;          If target is negative or no elements are left, return false.

* &nbsp;     Recursively check both: including and excluding the current number.
* &nbsp;   The result is true if any combination of choices forms the required subset.

This method checks all possible subsets to see if any sums to the required target.



Time and Space Complexity:

* Time Complexity: O(2ⁿ)

&nbsp;   Where n is the number of elements in the array.

&nbsp;   Each element has two choices: include or exclude, leading to 2^n subsets being checked in 

&nbsp;   the worst case.



* Space Complexity: O(n)

&nbsp;  Due to the recursive call stack. In the worst case, the recursion depth is n (when creating a

&nbsp;  full branch of the recursive tree).



This approach is easy to understand but inefficient for large inputs, which is why dynamic programming (as we used earlier) is preferred in practice.

