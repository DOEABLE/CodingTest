import java.util.*;

class Solution {
    static int answer=0;
    
    public static void main(String[] args){
        System.out.println(solution(new int[]{1,1,1,1,1},3));
        System.out.println(solution(new int[]{4,1,2,1},2));
    }
    
    public static int solution(int[] numbers, int target) {
        answer=0;
        
        dfs(numbers, target,0,0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int depth, int sum){
        //마지막 노드까지 탐색했을 때
        if(depth == numbers.length){
            if(target ==sum){
                answer++;
            }
            return;
        }
        int plus=sum+numbers[depth];
        int minus=sum-numbers[depth];
        
        dfs(numbers, target, depth + 1, plus);
        dfs(numbers, target, depth + 1, minus);
    }
}