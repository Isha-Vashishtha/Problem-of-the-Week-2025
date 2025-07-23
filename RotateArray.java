public class RotateArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return nums[low];
    }
    public static void main(String[] args) {
        RotatedArray r1 = new RotatedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Minimum element is: " + r1.findMin(nums)); // Output: 1
    }
}
