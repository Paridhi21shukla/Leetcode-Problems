import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // Mark the index corresponding to each number
        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Positive indexes represent missing numbers
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}