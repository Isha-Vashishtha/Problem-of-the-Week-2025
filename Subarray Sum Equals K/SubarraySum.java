// package Subarray Sum Equals K;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        SubarraySum solution = new SubarraySum();
        int[] nums = {1, 1, 1};
        int k=2;
        System.out.println(solution.subarraySum(nums,k)); 
    }
}
