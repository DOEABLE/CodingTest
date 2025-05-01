import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N =Integer.parseInt(st.nextToken());//남은 반납일수
        int M =Integer.parseInt(st.nextToken());//챕터의 수
        
        int[][] dp = new int[M+1][N+1];
        
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int day=Integer.parseInt(st.nextToken());
            int page=Integer.parseInt(st.nextToken());
            
            for(int j=1; j<=N; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=day){
                    dp[i][j] =Math.max(dp[i][j], dp[i-1][j-day]+page);
                }
            }
        }
        System.out.println(dp[M][N]);
    }
}