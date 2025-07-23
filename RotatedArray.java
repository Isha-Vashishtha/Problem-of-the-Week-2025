public class RotatedArray {
    public int findMin(int[] nums) {
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        RotatedArray r1=new RotatedArray();
        int[] nums = {3,4,5,1,2};
        System.out.println(r1.findMin(nums));
    }
}