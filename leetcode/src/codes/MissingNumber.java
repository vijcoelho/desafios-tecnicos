package codes;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 0;
        }

        int numero = 0;
        boolean zero = false;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                zero = true;
            }
            if (numero + 1 == nums[i]) {
                numero = nums[i];
                i = 0;
            } else {
                i++;
            }
            if (i == nums.length && zero) {
                return numero + 1;
            }
        }
        return 0;

        //Solucao mais rapida!
//        int sum = 0;
//
//        for(int num: nums){
//            sum += num;
//        }
//
//        int reqSum = (nums.length*(nums.length+1))/2;
//
//        return reqSum - sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,9,10,11,0};
        System.out.println(missingNumber(nums));
    }
}
