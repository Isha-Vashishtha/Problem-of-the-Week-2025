# **Equal Sum Partition (Asked by Facebook)**



## **Problem Statement:**

You are given a multiset (a list that can have duplicate integers). Determine whether it can be

partitioned into two subsets such that the sum of elements in both subsets is equal.



### **Description:**

The challenge is a variation of the Subset Sum Problem and a classical Dynamic

Programming problem known as Partition Equal Subset Sum.

You are required to determine if the given array can be split into two subsets A and B such

that:

sum(A) == sum(B)



#### **Input Format:**

• A list of integers (can include duplicates).

• The list may contain up to 100 elements.

#### **Output Format:**

• Return true if the set can be partitioned into two subsets with equal sum, else return

false.

#### **Constraints:**

• All numbers are non-negative integers.

• At least one number exists in the input.

Hints:

• If total sum is odd, it can’t be split evenly.

• Use Dynamic Programming or recursion + memoization.





#### **Solution Approach:**

#### **1.Recursive Backtracking (Brute-force Subset Sum using Recursion)**

**Problem Overview**

**This class solves the "Partition Equal Subset Sum" problem:**

**Given a list of positive integers, determine if it's possible to divide the array into two subsets such that the sum of elements in both subsets is equal.**



##### **Explanation**

**How does the solution work?**

**1.Calculate the total sum:**

  **First, we find the sum of all elements in the array.**

**2.Check for evenness:**

  **If the total sum is odd, it’s impossible to split it into two equal parts. The function** 

  **returns false immediately.**

  **If the sum is even, our goal becomes finding a subset whose elements add up to exactly sum/2.**

**3.Recursive Search:**

  **We use recursion to explore all possible ways of picking numbers to make a subset sum of**  

  **sum/2.**

  **At every recursive step, we have two choices for the current index:**

  **Include the current number in our subset and reduce the target accordingly.**

  **Skip the number and try with the rest.**

**4.The recursion continues until:**

  **Found Solution: When target reaches zero (target == 0), we've found a valid subset.**

**5.No Solution Path:** 

  **If we go out of bounds (index >= nums.length) or the target becomes negative (target < 0),** 

  **there's no valid subset along this path.**



**Step-by-Step Example**

**For input:**

**nums =**

* **Total sum: 22 (even)**
* **Target for each subset: 11**
* **Recursive branching:**
* 
**&nbsp;  The function will try to build a subset that sums to 11 by either choosing or skipping each** 

   **number one by one.**



**Key Points**

* **This approach checks every possible combination of numbers, so it always finds the answer (if it exists).**
* **Simple to understand; ideal for small to moderately sized inputs, but not optimal for large arrays.**
* **No memoization is used here—so subproblems may be computed multiple times**
* 
**public boolean canPartition(int\[] nums) {**

    **int sum = 0;**

    **for (int num : nums) sum += num;**

    **if (sum % 2 != 0) return false;**

    **return canPartitionRecursive(nums, 0, sum / 2);**

**}**

**private boolean canPartitionRecursive(int\[] nums, int index, int target) {**

    **if (target == 0) return true;**

    **if (index >= nums.length || target < 0) return false;**

    **// Try including current number**

    **if (canPartitionRecursive(nums, index + 1, target - nums\[index])) return true;**

    **// Try skipping current number**

    **return canPartitionRecursive(nums, index + 1, target);**

**}**

##### **Complexity Analysis**

* **Time Complexity:**
* 
**&nbsp;  O(2^n), where n is the number of elements.**

   **Every element may or may not be included in a subset, leading to exponential growth.**

* **Space Complexity:**
* 
**&nbsp;  O(n), due to the recursion stack (at most one call per array element).**



#### **2.Space-Optimized Subset Sum using 1D Dynamic Programming**

#### **Overview**

**The purpose of this class is to determine whether an array of positive integers can be split into two subsets with equal sums. This is a variant of the famous "Subset Sum Problem" often encountered in interviews and coding challenges.**



#### **Explanation**

**The core idea is straightforward:**

##### **A.Sum the Numbers:**

**Add up all elements in the array to get the total sum.**

##### **B.Even Sum Check:**

**If the total sum is odd, it's impossible to split the array into two equal-sum subsets. We return false right away.**

##### **C.Target Subset Sum:**

**If the sum is even, our goal is to find if there's any subset whose sum equals sum / 2 (half of the total).**

##### **D.Dynamic Programming Approach:**

* **We use a boolean DP array (dp\[]), where dp\[j] tells us whether a sum of j is achievable with any subset of the numbers seen so far.**
* **Initialization: We set dp = true since a sum of 0 is always possible (by choosing nothing).**
* **For every num in the input, we update the array backwards from our target towards num:**
*    **If we could make a sum of j-num before including this num, now we can also make a sum of j**
* 
**&nbsp;     by including this number.**

*    **After processing all numbers, dp\[target] will be true if a half-sum subset exists.**



###### Code Logic Step-by-Step

**int sum = 0;**

**for (int num : nums) sum += num;**

**if (sum % 2 != 0) return false; // Odd total can't be divided**

**int target = sum / 2;**

**boolean\[] dp = new boolean\[target + 1];**

**dp\[0] = true; // sum = 0 always possible**



**for (int num : nums) {**

    **for (int j = target; j >= num; j--) {**

        **dp\[j] = dp\[j] || dp\[j - num];**

    **}**

**}**

**return dp\[target];**



**Example:**

**For nums =**

* **Total sum = 22 (even)**
* **Target = 11**
* **It is possible: Subset and subset both sum to 11.**



**Why the Backward Loop?**

**We loop backwards in the inner loop (from target down to num) to avoid using the same number multiple times in this single iteration.**



**Complexity Analysis**

* **Time Complexity: O(n \* target)**
* 
**&nbsp;  Where n is the number of elements in nums, and target is half the array sum.**

* **Space Complexity: O(target)**
* 
**&nbsp;  Since we only keep a 1D array of size target + 1 for DP.**



