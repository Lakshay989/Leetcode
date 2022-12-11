// Given an array of integers nums[] and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

import java.util.HashMap;

public class Main {

    public static void main(String[] args)
    {
         int[] example = {2,7,11,15} ;

         int target = 9 ;

         int[] result = twoSum(example, target) ;

        System.out.println(result[0] + "," + result[1]);

    }


    public static int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        HashMap<Integer,Integer> secondNum = new HashMap<Integer, Integer>();

        for(int i = 0 ; i< nums.length ; i++)
        {
            if(secondNum.containsKey(target - nums[i]))
            {
                result[0] = i ;
                result[1] = secondNum.get(target - nums[i]);
            }
            else
            {
                secondNum.put(nums[i], i) ;
            }
        }
        return result ;
    }
}