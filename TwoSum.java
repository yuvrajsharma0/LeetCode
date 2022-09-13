public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 19, 32, 8};
        int target = 10;

        int[] result = Solution.twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> lookUp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a; // possible value of b to find in lookUp

            if (lookUp.containsKey(b)) {
                result[0] = i;
                result[1] = lookUp.get(b);
                break;
            }
            lookUp.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> lookUp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // to get the possible value of b in constant time (a + b == target)
            lookUp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = target - a; // possible value of b to find in lookUp

            if (lookUp.containsKey(b) && lookUp.get(b) != i) {
                result[0] = i;
                result[1] = lookUp.get(b);
                break;
            }
        }
        return result;
    }

    // Using Brute Force Solution => O(n^2)
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}