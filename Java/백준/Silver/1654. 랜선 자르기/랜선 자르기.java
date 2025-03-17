import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //공백으로 나누어진 K,N이 첫째 줄에 입력됨.
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result =0;
        long max =0;
        
        long[] arr = new long[K];
        for(int i=0; i<K; i++){
            arr[i]=Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        result = binarySearch(arr,N, max);
        
        System.out.println(result);
        br.close();
        
    }
    //자를 수 있는 선의 최대 길이를 찾는 메서드
    private static long binarySearch(long[] arr, int N, long max){
        long half = 0;
        long min = 1;
        
        while(min<=max){
            half=(min+max)/2;
            long count=0;
            
            for(long num: arr){
                count+=num/half;
            }
            if(count<N){            //더 짧게 만들어야 한다.
                max=half-1;
            }else{      //더 길게 만들 수 있다.     
                min=half+1;
            }
        }
        return (min+max)/2;
    }
}