# Longest Common Subsequence of Three Strings



## Problem Description: 

### Scenario: 

In many real-world applications like version control, spell checking, or DNA sequencing, 

comparing multiple strings and identifying common patterns is crucial. 

In this challenge, you're given three strings, and you need to compute the length of the 

longest common subsequence (LCS) that is present in all three strings. 

A subsequence is a sequence that appears in the same relative order, but not necessarily 

contiguous. 

For example, in "abcde" and "ace", "ace" is a subsequence. 

Your goal is to implement an efficient algorithm that returns the length of the longest 

subsequence common to all three strings. 

#### Input Format: 

• Three lines of input, each containing one string: 

o S1 (string 1) 

o S2 (string 2) 

o S3 (string 3) 

#### Output Format: 

• A single integer representing the length of the longest common subsequence among 

the three strings. 

#### Constraints: 

• 1 ≤ |S1|, |S2|, |S3| ≤ 100 

• Strings may contain lowercase or uppercase English letters 



###### **Solution Approach:**

###### **1.Bottom-Up (Tabulation) for Longest Common Subsequence (LCS) - Optimized Approach**

   **1.Create a 2D DP table of size (m+1) x (n+1), where:**

     **m = length of text1**

     **n = length of text2**

     **dp\[i]\[j] = LCS length of text1\[i:] and text2\[j:]**

   **2.Fill the DP table in reverse order (bottom-up):**

     **If characters at current positions match (text1\[i] == text2\[j]), increment LCS:**

        **dp\[i]\[j] = 1 + dp\[i+1]\[j+1];**

     **Else, take the maximum by either skipping character from text1 or text2:**

        **dp\[i]\[j] = max(dp\[i+1]\[j], dp\[i]\[j+1]);**

  **3.Final result is in dp, which means LCS of full strings.**

    **🧠 DP Table Logic:**

    **| dp\[i]\[j] stores the LCS length between |**

    **|-----------|----------------------------|**

    **| text1\[i..end] | and | text2\[j..end] |**



###### **Time and Space Complexity:**

**🕒 Time Complexity: O(m \* n)**

**Two nested loops each running through lengths of the two strings.**



**💾 Space Complexity: O(m \* n)**

**A 2D array of size (m+1) x (n+1) is used for memoization.**



###### **2.Recursive Approach for Longest Common Subsequence (LCS) - Brute Force Approach**

   **This solution uses pure recursion to try all possible subsequences of text1 and text2**   

   **starting from indices i and j:**

   **1. Base Case:**

     **If either string is fully traversed (i == text1.length() or j == text2.length()), return 0.**

   **2. Match Case:**

     **If text1.charAt(i) == text2.charAt(j):**

      **The characters match!**

      **Add 1 to the result and move forward in both strings:**

      **return 1 + lcs(text1, text2, i + 1, j + 1);**

   **3.Mismatch Case:**

     **If characters don't match, recurse into both possibilities:**

        **Skip one character from either string and take the maximum:**

        **return Math.max(**

          **lcs(text1, text2, i + 1, j),**

          **lcs(text1, text2, i, j + 1)**

        **);**

###### 

###### **📊 Time and Space Complexity:**

**🕒 Time Complexity: O(2^(m + n))**

 **For each pair (i, j), the function makes 2 recursive calls.**

 **Total combinations grow exponentially in the worst case.**



**💾 Space Complexity: O(m + n)**

 **Due to the recursive call stack.**

 **Maximum depth = m + n (lengths of strings as it tries to match all characters).**



