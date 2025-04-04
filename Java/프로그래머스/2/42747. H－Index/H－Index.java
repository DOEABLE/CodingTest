import java.util.Arrays;

class Solution {
    
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h=0;
        int hIndex=0;
        for(int i=0; i< citations.length; i++){
            h = citations[i];
            hIndex= citations.length -i;
            
            if(h>=hIndex){
                answer = hIndex;
                break;
            }
        }
        return answer;
    }
}