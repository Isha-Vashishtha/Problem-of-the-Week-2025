# **Word Search in 2D Matrix(Easy)**

## **Problem Description:**

### **Scenario:**

In many document processing, word puzzles, and image processing systems, scanning a grid

for a target pattern is a common task. You are given a 2D matrix of characters, and a target

word. Your task is to check if the word exists in the matrix either:

• Left-to-right (horizontally)

• Top-to-bottom (vertically)

### **Input Format:**

• A 2D character matrix of size M x N

• A string representing the target word

### **Output Format:**

• Return true if the word exists in the matrix (either row-wise left to right or columnwise top to bottom)

• Else return false

### **Constraints:**

• 1 ≤ M, N ≤ 100

• Word length ≤ max(M, N)

• All characters are uppercase English letters



### **Solution Approach:**

### **1.Brute Force Path Generation (Full Path Enumeration)**

#### **Problem Overview**

**This class solves the Word Search problem:**

**Given a 2D board of characters and a target word, determine if the word exists in the grid by connecting letters in adjacent cells horizontally or vertically (not diagonally). Each cell can be used only once in the formation of the word.**

### **How does the solution work?**

**1.Board Setup and Goal:**

* **The 2D board is represented by char\[]\[] board.**
* **We want to find if there exists a path in the grid spelling out the word, moving step-by-step** 
* 
**&nbsp;  only in four directions: right, down, left, or up.**

* **No revisiting the same cell during the construction of a single word path.**



**2. Generating All Possible Paths:**

* **Starting from every cell on the board, the code generates all possible paths of length equal to the word length.**
* **The method generatePaths uses recursion to build these paths by moving in all four directions step-by-step.**



**3.Validating Each Path:**

* **After generating all candidate paths:**
* **For each path, it checks if:**
* 
**&nbsp;   a. The path stays within the board boundaries.**

    **b. No cell is visited more than once in that path.**

    **c. The concatenated string of characters matches the given word.**

* **If any valid path matches the word, the search returns true.**



**4.Returning the Result:**

* **If no path matches after checking all possibilities, the method returns false, indicating the word cannot be formed on the board.**



**Step-by-Step Example**

* **Input:**
* 
**&nbsp;  board = {**

  **{'A','B','C','E'},**

  **{'S','F','C','S'},**

  **{'A','D','E','E'}**

**}**

**word = "ABCCED"**



* **The code will:**
* 
**&nbsp;  Start generating paths from each cell (e.g., starting at board = 'A').**

   **Generate all paths of length 6 (length of "ABCCED").**

   **Validate paths to see if they spell "ABCCED" without revisiting cells.**

* **Finally, it will find positive or negative matches for the given word(s).**



**Key Points**

* **Exhaustive Path Exploration: It builds every path of the required length from every position,** 
* 
**&nbsp;  covering all possibilities without shortcutting or pruning.**

* **No Optimization: This is a brute-force method; it does not prune paths early or use memoization, which causes it to do redundant work.**
* **Path Validation: Each path’s validity (bounds and no revisits) is checked separately before comparing the formed string to the target word.**
* **Practical Use: Suitable only for small grids and short words due to exponential growth in paths generated.**



### **Complexity Analysis**

### **Time Complexity:**

**O(m × n × 4^L)**

 **Where m and n are the number of rows and columns of the board, and L is the length of the word.**

 **From each cell, all possible moves are explored recursively in 4 directions, leading to**  

 **exponential growth in the number of paths.**

### **Space Complexity:**

**O(L × P)**

  **Where L is the word length and P is the number of generated paths stored in memory.**

  **The recursion stack is at most the word length, but storing all paths causes high memory** 

  **usage.**



### **2.Depth-First Search (DFS) with Backtracking**

#### **Problem Overview**

**This class solves the Word Search problem:**

**Given a 2D board of characters and a target word, determine if the word can be constructed by sequentially connecting adjacent letters (up, down, left, right) without reusing any cell in the same path.**



### **How does the solution work?**

#### **1.Iterate Over Each Cell as a Starting Point:**

**The exist method starts from every cell (i, j) in the board.**

**It attempts to find the entire word starting from that cell using a recursive search.**

#### **2.Depth-First Search (DFS) with Backtracking:**

**The private method dfs takes the current position (x, y) and the idx indicating which character of the word we are currently matching.**

#### **3.Base Case:**

**If idx equals the length of the word, it means every character has been matched successfully, so return true.**

#### **4.Boundary and Matching Checks:**

**If (x, y) is out of bounds, or the board cell does not match the current character word.charAt(idx), return false.**

#### **5.Mark Cell as Visited:**

**To avoid revisiting the same cell on the current path, temporarily replace the current cell’s character with a special marker (e.g., '#').**

**This acts as a flag to indicate the cell is in use.**

#### **6.Recurse in Four Directions:**

**From the current cell, recursively search in the four adjacent directions (up, down, left, right) for the next character (idx + 1).**

#### **7.Backtrack:**

**After exploring neighbors, restore the cell’s original character so it can be reused in other paths.**

**This ensures that the board remains unchanged for subsequent searches starting at other positions.**

#### **8.Return the Result:**

**If any recursive search returns true, the overall function returns true, indicating the word exists on the board.**

**If no path is found after checking all starting points, return false.**



### **Step-by-Step Example**

* **Consider the board:**
* 
**&nbsp;   A B C E**

    **S F C S**

    **A D E E**

* **And the word: "ABCCED"**
* **Starting at cell (0, 0) which contains 'A', the algorithm matches 'A' with the first character.**
* **It then tries all four directions recursively, matching 'B', 'C', 'C', 'E', and 'D' in sequence, marking cells visited, and backtracking if a path fails.**
* **Eventually, the method finds a valid path for the word and returns true.**



**Key Points**

**1.DFS with Backtracking:**

  **The method explores possible paths deeply and backtracks when no progress is possible on the** 

  **current path.**

**2. In-place Marking:**

  **Using a temporary marker to denote visited cells avoids extra space for a visited array,**

  **optimizing memory usage.**

**3.Early Termination:**

  **The recursion returns early once the entire word is found without exploring unnecessary paths.**

**4.No Redundant Path Storage:**

  **Unlike brute-force approaches that generate all paths first, this method only explores one** 

  **path at a time, reducing overhead drastically.**



### **Complexity Analysis**

### **Time Complexity:**

 **O(m × n × 4^L)**

  **Here, m and n are board dimensions, and L is the length of the word.**

  **From each cell, up to four recursive calls exist for every character, leading to exponential** 

  **growth based on word length.**



### **Space Complexity:**

**O(L)**

 **Due to the recursion stack depth at most equal to the word length.**

 **No additional space is required for visited tracking as cells are marked in place.**

