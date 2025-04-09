import java.util.*;
import java.io.*;

public class Main{
    public static int max=Integer.MIN_VALUE;
    public static int min=Integer.MAX_VALUE;
    public static int[] number;
    public static int[] operator = new int[4];
    public static int N;//받은 수
    
    public static void main(String[] args)throws IOException{
        //백트래킹을 통해 모든 경우의 수를 확인하는 재귀호출문제.
        //수열을 받음 수의 순서를 바꾸면 안됨.(배열에 수열과 연산자의 수를 넣는다.)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        
        //숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            number[i]=Integer.parseInt(st.nextToken());
        }
        
        //연산자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(number[0],1);
        //연산자 우선순위 무시하고 앞에서부터 계산됨.
            //나눗셈은 음수를 양수로 나눌때 양수로바꿈(절댓값변환) 후 몫을 음수로 변환
        
        //식의 결과가 최대인 것과 최소인 것 구하기.
        System.out.println(max);
        System.out.println(min);
        
    }
    
    public static void dfs(int num, int idx){
        // dfs부분은 idx가 N이 되면 return -> 연산자를 다 사용하였다.
        if(idx==N){
            max=Math.max(max,num);
            min=Math.min(min,num);
            return;
        }
        //연산자가 한개라도 남아있으면 그 연산자를 사용한다.
        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;
                switch(i){
                    case 0: dfs(num+number[idx], idx+1); break;
                    case 1: dfs(num-number[idx], idx+1); break;
                    case 2: dfs(num*number[idx], idx+1); break;
                    case 3: dfs(num/number[idx], idx+1); break;
                }
                operator[i]++;
            }
        }
    }
    
}