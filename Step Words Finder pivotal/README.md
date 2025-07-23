Step Words Finder Pivotal



\##Problem Statement



\#Scenario: 

In a word game, a step word is created by adding exactly one letter to a given word and 

then anagramming the result to form a valid dictionary word. 

For example, from "APPLE": 

• Add "A" → "APPLEA" 

• Anagram to form "APPEAL" (a valid dictionary word) → This is a step word. 

You are given: 

• A dictionary of valid English words (as a list of strings), 

• An input word. 

Your task is to write a function that returns all valid step words that can be created from the 

input word using the above logic. 

\#Input Format: 

• First line: A string W (the input word) 

• Second line: An integer N (the number of words in the dictionary) 

• Next N lines: Each line contains one valid word from the dictionary 

\#Output Format: 

• Print each valid step word (one per line) in lexicographical order 

\#Constraints: 

• 1 <= len(W) <= 15 

• 1 <= N <= 10^5 

• All dictionary words are lowercase, alphabetic, and contain no spaces





\## Solution Approaches:



1.Sorting-Based Hash Map Grouping - Optimized Appraoch

&nbsp; Time Complexity: O(n\*k logk)

&nbsp;   n = number of strings

&nbsp;   k = average length of each string (due to sorting)

&nbsp; Space Complexity: O(n\*k)

2\. Brute Force Anagram Matching (Pairwise Comparison)

&nbsp;  Time Complexity: O(n^2 \* k log k)

&nbsp;    O(n^2) for pairwise/group comparisons

&nbsp;    O(k log k) for sorting during isAnagram check

&nbsp;  Space Complexity: O(n \* k)



