import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N, M;
	public static int[] arr;
	public static int answer = 0;
	public static int start = 0, end = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
 
    	arr = new int[M];
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i] = Integer.parseInt(st.nextToken());
    		end = Math.max(end, arr[i]);
    	}
    	
    	paramatricSearch();
    }
    
    //파라매트릭 서치에서 매개변수는 "나눠줄 보석의 수", 
    //매개변수로 나눠주었을때 총 몇명의 사람에게 나눠줄 수 있는지 계산하고, 계산하였을때의 사람 인원수가 N보다 크다면, 나눠주는 보석의 개수를 증가시켜서 사람 인원수를 줄여줍니다.
    //이 문제에서 질투심이 최소가 되게 보석을 나누어주기 위해서는 보석의 개수를 최대한 감소시켜야합니다. ( 그래야지 서로간의 보석 차이가 적습니다. )
 
    // 한명한테 보석을 모두 나눠주면 질투심이 높아집니다.
    // 최대한 많은 사람에게 동일하게 보석을 나눠줘야합니다.
    // 질투심 = 모든 학생들 중 보석을 가장 많이 가져간 학생의 보석 갯수입니다.   
    public static void paramatricSearch() {
    	start = 1; // 보석의 최소 개수는 1로 설정
    	end = end; // 색깔 상관없이 보석 중의가장 많은 색깔의 최대 개수 
    	
    	while(start <= end) {
    		int middle = ( start + end ) / 2; // 보석을 몇개씩 나눠줄 것인가.
    		
    		int peopleCnt = 0;
    		for(int i=0;i<M;i++) {
    			peopleCnt += arr[i] / middle; // ( k번쨰 보석의 개수) / ( 한 사람당 나눠줄 보석의 개수 ) = ( 가져가는 사람의 인원 )
    			if(arr[i] % middle > 0) //만약 나누어떨어지지 않으면, 보석이 남을때는 1 사람에게 남은 보석을 나눠줍니다. (한 사람은 1가지의 보석박에 못가지므로 이렇게 처리합니다.)
    				peopleCnt += 1; //보석을 나눠줍니다.
    		}
    		
    		if(peopleCnt > N) { // (나누어준 사람)이 N보다 크다면, 나눠줄 보석의 개수를 크게해줘서 나누어준 사람을 줄입니다.
    			start = middle + 1;
    		}else { // 만약 인원수가 같거나 작다면, ( 한 사람당 나눠줄 보석의 개수 ) 를 최대한 작게해주어야 질투심이 최소값이 되므로 아래와 같이 처리합니다.
    			end = middle - 1;
    		}
    	}
    	
    	System.out.println(start);
    }
 
}