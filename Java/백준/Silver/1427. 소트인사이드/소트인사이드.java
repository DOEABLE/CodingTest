import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = br.readLine();
        br.close();
        
        //정렬
        Integer[] array = new Integer[N.length()];
        
        for(int i=0; i< array.length; i++){
            array[i] = N.charAt(i)-'0';
        }
        
        Arrays.sort(array,Collections.reverseOrder());    //큰수->작은수로정렬
        
        for(int i=0; i<array.length;i++){
            bw.write(array[i]+"");//하나씩 꺼내서 buffer에 쓰기
        }
        
        bw.flush();
        bw.close();
    }
}
