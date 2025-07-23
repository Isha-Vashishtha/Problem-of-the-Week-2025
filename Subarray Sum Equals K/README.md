# Subarray Sum Equals K 

You are working as a data analyst for a fitness app. Every day, users log the number of 

calories burned. Your task is to find how many continuous days (subarrays) exist where the 

total calories burned equals a certain target k. This helps the app identify specific goal-based 

streaks. 

## Problem Statement: 

Given an integer array nums representing the calories burned each day, and an integer k 

representing a target calorie goal, return the total number of continuous subarrays whose 

sum is exactly equal to k. 

#### Input Format: 

• An integer n — the number of days. 

• An array nums of n integers — calories burned each day. 

• An integer k — the target calorie burn. 

#### Output Format: 

• A single integer — the total number of continuous subarrays whose sum equals k. 

#### Constraints: 

• 1 <= nums.length <= 2 \* 10^4 

• -1000 <= nums\[i] <= 1000 

• -10^7 <= k <= 10^7



### Solution Approach:

1. ### **Brute Force Approach for Subarray Sum Equals K**

&nbsp;   1. The solution uses two nested loops to check every possible subarray.

&nbsp;   2. For each starting index i, it:

&nbsp;      Initializes sum = 0

&nbsp;      Iterates from j = i to end:

&nbsp;        Adds current number nums\[j] to sum

&nbsp;        If sum == k, it increments the result counter res

&nbsp;    3.Finally, it returns res, the count of valid subarrays.

👉 This method considers all O(n²) subarrays and checks their sums one by one.



#### **📊 Time and Space Complexity:**

🕒 Time Complexity: O(n²)

Outer loop runs n times.

Inner loop runs ~n times per outer iteration → total is O(n²).



💾 Space Complexity: O(1)

Only a few integer variables are used; no extra space is required.



### **2.Optimized Prefix Sum with HashMap (for Subarray Sum Equals K)**

   **This solution uses the concept of Prefix Sum + HashMap to solve the problem in linear time.**

  **💡 Key Idea:**

   **For a subarray sum from index i to j to equal k, the difference between the prefix sum at j** 

   **and prefix sum before i must be k.**

   **That is:**

   **If:    sum = current prefix sum at index j**  

   **Then:  sum - k = prefix sum before some subarray** 

   **So, if map contains (sum - k), we found a valid subarray.**



   **1.Initialize a HashMap to store prefix sum frequencies**

     **Put (0, 1) in map to handle edge case when a subarray from start equals k.**



   **2.Traverse array:**

     **Update running sum**

     **If (sum - k) exists in map → increment count by its frequency**

     **Store/update current prefix sum sum in map** 



#### **📊 Time and Space Complexity:**

**🕒 Time Complexity: O(n)**

**Single pass through the array.**



**💾 Space Complexity: O(n)**

**In worst case, the HashMap stores n prefix sums.**



