//중복된 것을 뒤로 보낸다
//그중 제일 상위 K개를 선택함.
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k =Integer.parseInt(st.nextToken());
        int l =Integer.parseInt(st.nextToken());
        
        String[] A =new String[l];
        
        for(int i=0; i<l; i++){
            A[i]=br.readLine();
        }
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(String item:A){
            if(set.contains(item)){
                set.remove(item);
            }
            set.add(item);
        }
        int temp =0;
        
        for(String answer:set){
            temp++;
            System.out.println(answer);
            if(temp==k)break;
        }
    }
}
