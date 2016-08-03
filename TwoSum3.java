/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
    // Time O(1)
	public void add(int number) {
	    Integer count = map.get(number);
	    if (count == null) {
	        map.put(number, 1);
	    } else {
	        map.put(number, count + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
    // Time O(n)
    // Space O(n)
	public boolean find(int value) {
	    for (Integer num : map.keySet()) {
	        Integer count = map.get(value - num);
	        if (count != null) {
	            if (num * 2 != value || count > 1) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> nums = new ArrayList<Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    Integer count = map.get(number);
	    if (count == null) {
	        map.put(number, 1);
	        nums.add(number);
	    } else {
	        map.put(number, count + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < nums.size(); i++) {
	        Integer count = map.get(value - nums.get(i));
	        if (count != null) {
	            if (nums.get(i) * 2 != value || count > 1) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}