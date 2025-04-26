package backtracking;

import java.util.*;

public class SubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        System.out.println(result);
    }

    static void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // store current subset
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); // choose
            backtrack(i + 1, nums, temp, result); // explore
            temp.remove(temp.size() - 1); // un-choose (backtrack)
        }
    }
}
