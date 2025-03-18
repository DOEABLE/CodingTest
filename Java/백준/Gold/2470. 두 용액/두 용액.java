import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int[] res = new int[2];    //pointer생성
        int start=0;
        int end=N-1;
        int min=Integer.MAX_VALUE;    //int 타입에서 표현할 수 있는 가장 큰 값(2³¹ - 1)을 의미
        
        Arrays.sort(arr);
        
        while(start<end){    //언제까지? -> start >=end
            int sum = arr[start]+arr[end];
            
            if(min>Math.abs(sum)){
                min = Math.abs(sum);//sum의 절댓값을 찾아서 0과 얼마나 가까운지 계산
                
                res[0]=arr[start];
                res[1]=arr[end];
            
                if(sum==0) break;    
            }
            if(sum<0) start++;
            else end--;    
        }
        System.out.println(res[0]+" "+res[1]);
    }
    
}