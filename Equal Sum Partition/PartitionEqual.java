// package Equal Sum Partition;

public class PartitionEqual {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return canPartitionRecursive(nums, 0, sum / 2);
    }
    private boolean canPartitionRecursive(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;
        if (canPartitionRecursive(nums, index + 1, target - nums[index])) return true;
        return canPartitionRecursive(nums, index + 1, target);
    }
    public static void main(String[] args) {
        PartitionEqual solution = new PartitionEqual();
        int[] nums={1,5,11,5};
        System.out.println(solution.canPartition(nums)); 
    }
}
