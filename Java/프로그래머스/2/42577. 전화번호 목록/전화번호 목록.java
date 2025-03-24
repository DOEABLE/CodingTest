import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        
        //map에 받은 전화번호 배열을 넣어준다.
        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i],i);
        }
        
        for(int i=0; i<phone_book.length;i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }
}