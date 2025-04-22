import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static char[][] map;
    static int[][] heightMap;
    static boolean[][] visited;
    
    static int[] heightArray;
    
    static int initialMax =0;
    static int initialMin = 1000000;
    
    static int[] startPoint = new int[2];
    static int totalHouse = 0;
    
    static int[] dx = {0,0,1,-1,1,-1,1,-1};
    static int[] dy = {1,-1,0,0,-1,1,1,-1};
    
    static ArrayList<Integer> diffs;
    
    public static void main(String[] args)throws IOException{
        getInput();
        
        findInitialMinMax();
        
        getSortedHeight();
        
        calDiff();
        
        int tiredValue = Collections.min(diffs);
        
        System.out.println(tiredValue);
        
    }
    //입력받기
    public static void getInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        heightMap = new int[N][N];
        visited = new boolean[N][N];
        
        //map 받기
        for(int i =0;i<N; i++){
            String line = br.readLine();
            for(int j =0; j<N; j++){
                map[i][j] = line.charAt(j);
                
                if(map[i][j]=='P'){
                    startPoint[0]=j;
                    startPoint[1]=i;
                }
                if(map[i][j]=='K'){
                    totalHouse +=1;
                }
            }
        }
        
        // heightMap받기
        for(int y =0; y<N; y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x =0; x<N; x++){
                heightMap[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        // visited 초기화
        for(int a = 0; a<N; a++){
            for(int b = 0;b<N; b++){
                visited[a][b] = false;
            }
        }
    }
    //두 지도를 훑어서 집과 우체국 최소 고도, 최대 고도 얻기
    public static void findInitialMinMax(){
        for(int i =0 ; i<N;i++){
            for(int j=0;j<N; j++){
                if(map[i][j]=='P'||map[i][j]=='K'){
                    initialMax = Math.max(initialMax, heightMap[i][j]);
                    initialMin = Math.min(initialMin, heightMap[i][j]);
                }
            }
        }
    }
    public static void getSortedHeight(){
        HashSet<Integer> heights = new HashSet<Integer>();
        
        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                heights.add(heightMap[i][j]);
            }
        }
        heightArray = new int[heights.size()];
        int i = 0;
        for(Integer num: heights){
            heightArray[i]=num;
            i++;
        }
        Arrays.sort(heightArray);
     }
    
    //BFS를 이용해 두 사이의 간격으로 모든 집을 방문할 수 있었는지 확인
    public static boolean isVisited(int minHeight, int maxHeight){
        int count =0;
        
        ArrayDeque<int[]> ad = new ArrayDeque<int[]>();
        
        //visited 초기화
        for(int a =0; a<N; a++){
            for(int b =0; b<N; b++){
                visited[a][b] =false;
            }
        }
        
        int nowX=startPoint[0];
        int nowY=startPoint[1];
        
        int[] now = new int[] {nowX, nowY};
        
        ad.add(now);
        visited[nowY][nowX]=true;
        
        while(ad.size()>0){
            now = ad.poll();
            nowX = now[0];
            nowY = now[1];
            
            if(map[nowY][nowX]=='K'){
                count +=1;
            }
            if(count==totalHouse){
                return true;
            }
            
            for(int i =0;i<8; i++){
                int nextX = nowX +dx[i];
                int nextY = nowY +dy[i];
                
                if(nextX >=0&& nextY >=0 && nextX < N && nextY < N && !visited[nextY][nextX]){
                    int nextHeight = heightMap[nextY][nextX];
                    if(nextHeight >= minHeight && nextHeight <= maxHeight){
                        int[] next = new int[] {nextX, nextY};
                        ad.add(next);
                        visited[nextY][nextX] = true;
                    }
                }     
            }
        }
        return false;
    }
    //left, right 이동
    public static void calDiff(){
        int leftIdx =0;
        int rightIdx =0;
        
        diffs = new ArrayList<Integer>();
        
        for(int i =0; i< heightArray.length; i++){
            if(heightArray[i]==initialMax){
                rightIdx = i;
                break;
            }
        }
        
        while(true){
            if(isVisited(heightArray[leftIdx], heightArray[rightIdx])){
                int diff = heightArray[rightIdx]-heightArray[leftIdx];
                diffs.add(diff);
                //left가 끝에 도달아면 더 할 필요 없음.
                if(heightArray[leftIdx]==initialMin){
                    return;
                }
                leftIdx++;
            }else{
                rightIdx++;
                //right가 끝에 도달하면 더 할 필요 없음.
                if(rightIdx >= heightArray.length){
                    return;
                }
            }
        }
    }
}