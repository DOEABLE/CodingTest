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
        sb = new StringBuilder();
        
        visited = new boolean[N];
        result = new int[M];
        dfs(0,0);
        System.out.println(sb);
        
    }
    public static void dfs(int depth, int start){
        if(depth==M){
            for(int num:result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =start; i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=i+1;
                dfs(depth+1, i+1);
                visited[i]=false;
            }
        }       
    }
}