import java.util.HashMap;

public class SubarraySumOptimized {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubarraySumOptimized solution = new SubarraySumOptimized();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k));
    }
}
