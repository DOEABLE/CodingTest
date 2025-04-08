import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        int N= Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        
        
        //입력받을 때 마다 정렬
        Set<Integer> set = new TreeSet<>();
        
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int index=0;
        for(int l: set){
            map.put(l,index++);
        }
        
        for(int i =0; i<N; i++){
            sb.append(map.get(arr[i])).append(' ');
        }
        System.out.println(sb);
    }
}