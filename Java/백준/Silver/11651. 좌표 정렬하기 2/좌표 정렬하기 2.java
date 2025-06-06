import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int N= Integer.parseInt(br.readLine());
        Integer arr[][] = new Integer[N][2];
        
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<Integer[]>(){
            @Override
                public int compare(Integer[]o1, Integer[]o2) {
                //y비교 -> 같으면 x비교
                if(o1[1].equals(o2[1])){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        
        for(int i=0; i<N;i++){
            sb.append(arr[i][0] +" "+arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
