package com.xyy.javase;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 12:58
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 22;
        int[] myIndex = twoSum2(nums, target);
        for(int num : myIndex){
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(4);
        for(int i=0; i<nums.length; i++){
            int partNumber = target - nums[i];
            if(map.containsKey(partNumber)){
                return new int[]{map.get(partNumber), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
