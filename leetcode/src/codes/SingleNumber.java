package codes;

import java.util.HashSet;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,1};
        System.out.println(singleNumber(nums));
    }
}
