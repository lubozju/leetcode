/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<ListIterator<NestedInteger>> stack;
    Integer next;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<ListIterator<NestedInteger>>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return next;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            ListIterator<NestedInteger> listIter = stack.peek();
            if (!listIter.hasNext()) {
                stack.pop();
            } else {
                NestedInteger ni = listIter.next();
                if (ni.isInteger()) {
                    next = ni.getInteger();
                    return true;
                }
                stack.push(ni.getList().listIterator());
            }
        }
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> iterator;
    Stack<Iterator<NestedInteger>> iterStacks;
    Integer next = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = nestedList.iterator();
        iterStacks = new Stack<>();
    }

    @Override
    public Integer next() {
        Integer result = next;
        next = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        while (iterator.hasNext() || !iterStacks.empty()) {
            if (iterator.hasNext()) {
                NestedInteger nextNi = iterator.next();
                if (nextNi.isInteger()) {
                    next = nextNi.getInteger();
                    return true;
                }
                if (iterator.hasNext()) {
                    iterStacks.push(iterator);
                }
                iterator = nextNi.getList().iterator();
            } else {
                iterator = iterStacks.pop();
            }
        }
        return false;
    }
}