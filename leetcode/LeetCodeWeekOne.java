package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LeetCodeWeekOne {
	//reverse the String characters
	public String reverseString(String s) {
        StringBuilder output = new StringBuilder();
        for(int i = s.length() - 1; i > -1; i--){
            output.append(s.charAt(i));
        }
        return output.toString();
    }
	
	//making sure the String has valid parentheses
	 public boolean isValid(String s) {
	        Stack<Character> thing = new Stack<Character>();
	        for(char c: s.toCharArray()) {
	            if(c == '(') {
	                thing.push(')');
	            } else if(c == '{') {
	                thing.push('}');
	            } else if(c == '[') {
	                thing.push(']');
	            } else {
	                if(thing.isEmpty() || c != thing.pop()) {
	                    return false;
	                }
	            }
	        }
	        return thing.isEmpty();
	    }
	  
	//maximum subArray
	 public int maxSubArray(int[] nums) {
		 int max = nums[0];
		 int current = 0;
		 
		 for(int i = 0; i < nums.length; i++) {
			 current += nums[i];
			 if(max < current) {
				 max = current;
			 } 
			 if(current < 0) {
				 current = 0;
			 }
		 }
		 return max;
	 }
	 
	 //climbing stairs
	 public int climbStairs(int n) {
		 int smallStep = 1;
		 int bigStep = 2;
		 
	 }
	 
	 //Majority Element
	 public static int majorityElement(int[] nums) {
			HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
			int res = 0;
			for(int i = 0; i < nums.length; i++) {
				if(!myMap.containsKey(nums[i])) {
					myMap.put(nums[i], 1);
				} else {
					myMap.put(nums[i], myMap.get(nums[i]) + 1);
				}
				if(myMap.get(nums[i]) > nums.length / 2) {
					res = nums[i];
					break;
				}
			}
			return res;
		}
	 
	 //two sum two
	 
	 
	 public static void main(String[] args) {
		 LeetCodeWeekOne l = new LeetCodeWeekOne();
		 int[] thing = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(l.maxSubArray(thing));
	 }
}
