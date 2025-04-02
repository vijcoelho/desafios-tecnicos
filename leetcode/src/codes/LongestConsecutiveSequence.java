package codes;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int loop = 0;
        for (int i : nums) {
            if (i < 0) {
                loop = 1;
                break;
            }
        }

        int numero = nums[0];
        for (int i : nums) {
            if (i == 1) {
                numero = 1;
            } else if (i == 0) {
                numero = 0;
                break;
            }
        }

        int i = 0;
        int count = 1;
        if (loop == 1) {
            while (i < nums.length) {
                if ((numero - 1) == nums[i]) {
                    count++;
                    numero = nums[i];
                    i = 0;
                }
                i++;
            }
        } else {
            while (i < nums.length) {
                if ((numero + 1) == nums[i]) {
                    count++;
                    numero = nums[i];
                    i = 0;
                }
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1};
        System.out.println(longestConsecutive(nums));
    }
}
