import java.util.*;
import java.io.*;

//완전탐색은 수가 너무 크면 효율 떨어짐. 탐색 범위를 반으로 쪼갬
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);//심사관 별 심사시간이 담긴 times배열을 오름차 순 정렬
        
        long left=0;
        long right=times[times.length-1]*(long)n;
        
        while(left<=right){
            //이분탐색
            long mid = (left+right)/2;
            long complete = 0;
            
            for(int i=0; i<times.length;i++)
                complete+=mid/times[i];
        //심사한 총 사람 수(complete)가 n보다 작을경우, 해당 시간동안 모든 사람을 검사할 수 없었다.즉, left를 mid + 1로 로 이전한다.        
                if(n>complete){
                    left=mid+1;
                }else{
                    right=mid-1;
                    answer = mid;
                }
            
        }
        return answer;
    }
}