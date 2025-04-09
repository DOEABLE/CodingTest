import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] score;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        visited = new boolean[N];
        
        //팀 능력치 입력
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                score[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min);
    }
    
    /*
        true- start팀 false-link팀. count-조합갯수
    */
    public static void dfs(int nowIndex, int count){
        if(count==N/2){
            compare();
            return;
        }
        for(int i= nowIndex; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i+1, count+1);
                visited[i] = false;
            }
        }
    }
    
    public static void compare(){
        int start = 0;
        int link = 0;
        
        for(int i =0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                //i번째 사람과 j번째 사람이 true라면 start팀에 점수 더하기
                if(visited[i]==true && visited[j]==true){
                    start+=score[i][j];
                    start+=score[j][i];
                }
                //i번째 사람과 j번째 사람이 false라면 link팀에 점수 더하기
                else if(visited[i]==false && visited[j]==false){
                    link+=score[i][j];
                    link+=score[j][i];
                }
            }
        }
        //두 팀의 점수 차
        int val = Math.abs(start-link);
        /*
            백트래킹 -> 두 팀의 점수 차가 0이라면 가장 낮은 최솟값이므로
            0 출력 후 끝내기           
        */
        if(val==0){
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(val,min);
    }
}