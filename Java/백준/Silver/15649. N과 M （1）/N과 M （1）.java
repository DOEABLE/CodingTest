import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        sb=new StringBuilder();
        
        visited = new boolean[N+1];
        result = new int[M];
        backTrack(0);
        System.out.println(sb);
    }
    public static void backTrack(int depth){
        if(depth==M){
            for(int num:result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=i;
                backTrack(depth+1);
                visited[i]=false;
            }
        }
    }
}
