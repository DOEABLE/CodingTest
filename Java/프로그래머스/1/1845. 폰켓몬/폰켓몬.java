import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length/2;    //고를 포켓몬
        
        Set<Integer> hs = new HashSet<Integer>();
        
        //hs에 nums 넣어서 중복 제거하기
        for(int i=0;i<nums.length; i++){
            hs.add(nums[i]);
        }
        
        int ponketmon_nums = hs.size();
        
        if(ponketmon_nums < num){
            return ponketmon_nums;
        }else{
            return num;
        }
    }
}