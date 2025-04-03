package codes;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                longest = Math.max(longest, count);
                count = 1;
            }
        }

        longest = Math.max(longest, count);
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
}
