import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int[] res = new int[2];
        int start =0;
        int end =N-1;
        //0에 가까운 두 용액
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        while(start<end){
            int sum = arr[start]+arr[end];
            
            if(min>Math.abs(sum)){
                min=Math.abs(sum);
                
                res[0]=arr[start];
                res[1]=arr[end];
                
                if(sum==0) break;
            }
            if(sum<0) start++;
            else if(sum>0) end--;
            else {
                res[0]=start;
                res[1]=end;
            }
        }
        //System.out.println(res[0]+" "+res[1]);
        bw.write(res[0]+" "+res[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}