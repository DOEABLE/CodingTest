import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i< clothes.length; i++){
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key,0)+1);
        }
        
        Iterator<Integer> ite = hm.values().iterator();
        
        while(ite.hasNext()){
            answer*= ite.next().intValue() +1;
        }
        return answer-1;
    }
}