/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (min.empty()) {
            min.push(x);
        } else {
            // push min when x <= top of min stack
            if (x <= min.peek()) {
                min.push(x);
            }
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}