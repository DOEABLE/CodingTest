import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int A = Math.abs(a);
                int B = Math.abs(b);
                
                if(A>B)
                    return A-B;
                else if(A==B){
                    if(a>b) return 1;
                    else return -1;
                }
                else return -1;
            }
        });
        
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            
            if(num !=0){
                pq.offer(num);
            }else{
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }else
                    sb.append("0\n");
            }
        }
        System.out.println(sb);
        
        
    }
}