import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Deque<Balloon> queue = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());//풍선갯수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] balloonLocation = new int[N];
        for(int i=0;i<N;i++){
            balloonLocation[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
        sb.append("1 ");
        int moveValue = balloonLocation[0];//움직일 값
        
        for(int i =1; i<N; i++){
            queue.add(new Balloon(i+1, balloonLocation[i]));
        }
        
        //풍선이 모두 터질 때까지
        while(!queue.isEmpty()){
            //1-1. 양수 일 경우 인덱스가 큰 쪽
            if(moveValue>0){
                //1-2. 앞에있는 쪽을 모두 뒤로 보냄
                for(int i=1;i<moveValue; i++){
                    queue.add(queue.poll());
                }
                //1-3. 모두 뒤로 보낸 후 -> 이동값 갱신-> 터트린 풍선의 위치 값 출력목록에 저장
                Balloon next = queue.poll();
                moveValue = next.numValue;
                sb.append(next.index+" ");
            }else{//2.음수일 경우
                //뒤에 있는 요소들 모두 앞으로
                for(int i=1; i<-moveValue; i++){
                    queue.addFirst(queue.pollLast());
                }
                //모두 뒤로 보낸 후
                Balloon next = queue.pollLast();
                moveValue = next.numValue;
                sb.append(next.index+" ");
            }
        }
        System.out.println(sb);
    }
}

//풍선의 인덱스와 숫자 값을 저장하는 클래스
class Balloon{
    int index;
    int numValue;
    
    public Balloon(int index, int numValue){
        this.index=index;
        this.numValue=numValue;
    }
}