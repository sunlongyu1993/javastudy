package Test704;

/**
 * @author 孙珑瑜
 * @version 211202
 * 704 二分法
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] nums ={1,2,5,7,8,10};
        int index = getIndex1(nums, 10);
        int index2 = getIndex2(nums, 10);
//        System.out.println(index);
        System.out.println(index2);
    }
//    暴力法
    public static int getIndex1(int[] nums,int target){
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    //二分法- 左闭右闭，【left，right】
    public static int getIndex2(int[] nums,int target){
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid =left+ (right-left)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                right =mid-1;
            }
            else if(target>nums[mid]){
                left =mid+1;
            }
        }
        return -1;
    }




}
