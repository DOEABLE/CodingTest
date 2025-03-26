import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();//<Integer>만 삽입, 삭제 가능
        
        for(int i=0; i<progresses.length; i++){  //작업일 수 큐에 저장
            if((100-progresses[i]) % speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }
        
        int x= q.poll();    //큐 맨 앞에 있는 값 반환 후 삭제
        int count =1;
        while(!q.isEmpty()){
            if(x >= q.peek()){
                count++;
                q.poll();
            }else{
                list.add(count);
                count=1;
                x=q.poll();
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length; i++){
            answer[i]=list.get(i);
        }
        return answer;
        
        //큐가 빌 때까지 작업 실행
        //전에 나온게 나중에 나온 것 보다 크거나 같으면 count증가, q.poll()
        //아니면 count를 리스트에 추가, count를 1로 초기화 x=q.poll()처리
        //while문을 빠져나와서 마지막 처리 count를 리스트에 추가
        //list출력.
    }
}