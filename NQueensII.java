/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    public int totalNQueens(int n) {
        int result = 0;
        
        List<Integer> colIndexes = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i ++) {
            result += dfs(0, i, colIndexes, n);
        }
        
        return result;
    }
    
    public int dfs(int rowCur, int colCur, List<Integer> colIndexes, int n) {
        if (rowCur == n - 1) {
            return 1;
        }
        
        int result = 0;
        colIndexes.add(colCur);
        
        for (int i = 0; i < n; i++) {
            if (valid(colIndexes, rowCur + 1, i)) {
                result += dfs(rowCur + 1, i, colIndexes, n);
            }
        }
        // user colIndexes.size() - 1 instead of colCur because colCur is considered as index
        colIndexes.remove(colIndexes.size() - 1);

        return result;
    }
    
    public boolean valid(List<Integer> colIndexes, int rowCur, int colCur) {
        //check same col
        if (colIndexes.contains(colCur)) {
            return false;
        }
        
        // check diagonal cannot be same col
        for (int i = 0; i < colIndexes.size(); i++) {
            int rowDiff = rowCur - i;
            int colDiff = colCur -colIndexes.get(i);
            if (rowDiff == colDiff || rowDiff == -colDiff) {
                return false;
            }
        }
        
        return true;
    }
}

public class Solution {
    public int totalNQueens(int n) {
        int[] tag = new int[n];
        return dfs(0, tag, n);
    }
    
    private int dfs(int index, int[] tag, int n) {
        if (index == n) {
            return 1;
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (validate(index, i, tag)) {
                tag[index] = i;
                result += dfs(index + 1, tag, n);
            }
        }
        
        return result;
    }
    
     private boolean validate(int index, int i, int[] tag) {
        // vertical
        for (int j = 0; j < index; j++) {
            if (tag[j] == i) {
                return false;
            }
        }
        // 
        for (int j = 0; j < index; j++) {
            if (tag[j] == i + index - j || tag[j] == i + j - index) {
                return false;
            }
        }
        return true;
    }
}