public class EqualSubsetSumBruteForce {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return canFindSubset(nums, 0, sum / 2);
    }
    private boolean canFindSubset(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;
        return canFindSubset(nums, index + 1, target - nums[index]) || 
               canFindSubset(nums, index + 1, target);
    }

    public static void main(String[] args) {
        EqualSubsetSumBruteForce solution = new EqualSubsetSumBruteForce();
        int[] nums = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums)); 
    }
}
