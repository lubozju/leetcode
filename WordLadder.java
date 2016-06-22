/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        int result = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (findNeighbor(word, visited, queue, wordList, endWord)) {
                    return result + 1;
                }
                size--;
            }
            result++;
        }
        return 0;
    }
    
    private boolean findNeighbor(String word, Set<String> visited, Queue<String> queue, Set<String> wordList, String endWord) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char[] wordChar = word.toCharArray();
                wordChar[i] = (char)('a' + j);
                String neighbor = new String(wordChar);
                if (neighbor.equals(endWord)) {
                    return true;
                }
                if (wordList.contains(neighbor) && !visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }
}



public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> beginQueue = new LinkedList<String>();
        Queue<String> endQueue = new LinkedList<String>();
        Set<String> beginVisited = new HashSet<String>();
        Set<String> endVisited = new HashSet<String>();
        int beginResult = 1;
        int endResult = 1;
        beginQueue.add(beginWord);
        endQueue.add(endWord);
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size();
            while (beginSize > 0) {
                String word = beginQueue.poll();
                if (findNeighbor(word, beginVisited, endVisited, beginQueue, wordList)) {
                    return beginResult + endResult;
                }
                beginSize--;
            }
            beginResult++;
            
            int endSize = endQueue.size();
            while (endSize > 0) {
                String word = endQueue.poll();
                if (findNeighbor(word, endVisited, beginVisited, endQueue, wordList)) {
                    return beginResult + endResult;
                }
                endSize--;
            }
            endResult++;
        }
        return 0;
    }
    
    private boolean findNeighbor(String word, Set<String> visited, Set<String> target, Queue<String> queue, Set<String> wordList) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char[] wordChar = word.toCharArray();
                wordChar[i] = (char)('a' + j);
                String neighbor = new String(wordChar);
                if (target.contains(neighbor)) {
                    return true;
                }
                if (wordList.contains(neighbor) && !visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }
}