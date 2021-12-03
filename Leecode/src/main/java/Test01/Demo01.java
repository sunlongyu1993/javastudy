package Test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 211125
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] nums={2,4,11,15};
        int[] getresult = getresult(nums, 9);
        System.out.println(Arrays.toString(getresult));
    }

    //哈希表
    public static int[] getresult(int[] nums, int target){
        int[] result =new int[2]; //定义一个数组，接收符合条件的索引
        Map<Integer,Integer> maplist =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maplist.put(nums[i],i);//遍历春如的数组，添加的map集合中
        }
        for (int j = 0; j <nums.length ; j++) {
            int diff1 =target -nums[j];
            if (maplist.containsKey(diff1) &&(maplist.get(diff1)!=j)) {
                result[0] =j;
                result[1] =maplist.get(diff1);
                return result;
                }
            }
        return result;
    }
//    暴力法
    public int[] twoSum(int[] nums, int target) {
        int sum =0;
        int[] result =new int[2];

        for(int i =0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]+nums[j] ==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
}
