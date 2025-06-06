import java.util.*;
import java.io.*;

public class Main{
    static int minTaste;
    static boolean[] isSelected;
    static int[][] tastes;
    static int N;
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());//재료의 가짓수
		isSelected = new boolean[N];
        minTaste = Integer.MAX_VALUE;
        tastes = new int[N][2];//맛을 나타낼 배열
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }
        
        subSet(0,1,0);
        
        System.out.println(minTaste);
	}
    
    static void subSet(int cnt, int mulSour, int hapBitter){
        if(cnt==N){
            int falseCnt =0;
            for(int i=0;i<N;i++){
                if(isSelected[i]) continue;
                falseCnt++;
            }
            if(falseCnt==N) return;
            minTaste = Math.min(minTaste, Math.abs(mulSour-hapBitter));
            return;
        }
        isSelected[cnt] =true;
        subSet(cnt+1,mulSour*tastes[cnt][0],hapBitter+tastes[cnt][1]);
        isSelected[cnt]=false;
        subSet(cnt+1, mulSour,hapBitter);
    }
    	
}