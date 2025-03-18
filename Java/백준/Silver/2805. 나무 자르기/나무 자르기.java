import java.io.*;
import java.util.*;

public class Main{
        static int[] trees;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        trees = new int[N];
        int max =0;
        int min =0;
        
        st = new StringTokenizer(br.readLine());//얘를 왜 두번 쓰는겨?
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        
        //이분탐색
        while(min<max){
            int mid = (min+max)/2;
            long sum =cutting(mid);
            
            if(sum<M){//절단기의 높이가 나무보다 작을 때
                max=mid;    //절단기의 높이를 낮춰야 함.
            }else{//절단기의 높이가 나무보다 클 때
                min=mid+1;
            }
        }
        System.out.println(min-1);
    }
    
    //cutting()의 반환 값이 M보다 작으면 절단기의 높이를 낮춰야 함.
    private static long cutting(int height){
        long cuttingResult=0;
        for(int i=0; i<trees.length; i++){
            if(trees[i]>height){//나무가 절단기 높이보다 높을 때
                cuttingResult += trees[i] - height;
            }
        }
        return cuttingResult;
    }
}