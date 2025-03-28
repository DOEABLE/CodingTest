import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        //최단 경로 구하는 방법을 이용해 점화식 구함
        int[][] dp = new int[n+1][m+1];
        
        dp[1][1]=1;
        //이 점화식으로 최단경로를 구하는 data를 메모이제이션
        //메모이제이션: botton-up방식
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[i].length; j++){
                //웅덩이 일 경우 0으로 바꿔줌
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                
                //[1][1]~[1][m] 경우의 수 구해줌
                if(i==1 && j>1){
                    dp[i][j]=dp[i][j-1];
                    continue;
                }
                
                //[2][1]~[2][m] 경우의 수 구해줌
                if(i>1){
                    dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000007;
                }
            }
        }
        answer = dp[n][m];
        return answer;
    }
}