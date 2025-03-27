import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String[] nums= new String[numbers.length];//int-> String으로 변환해 숫자 자체가 아닌 앞자리의 크기로 비교.
        //1. 문자열 내림차순 정렬
        for(int i=0; i<numbers.length;i++)
            nums[i] = numbers[i]+"";
            
        Arrays.sort(nums,(n1,n2)->(n2+n1).compareTo(n1+n2));
        
        
        return nums[0].equals("0")?"0":Arrays.stream(nums).collect(Collectors.joining());
    }
}