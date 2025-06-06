import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] L;//잃는 체력
	static int[] J;//얻는 기쁨
	static int HP = 100;
	static int happy = 0;

	//체력이 0보다는 큰 상태의 최대 기쁨을 출력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());//세준이를 생각해 준 사람.

		L=new int[N];
		J=new int[N];

		//체력 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N;i++){
			L[i]=Integer.parseInt(st.nextToken());
		}

		//기쁨 입력
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N;i++){
			J[i]=Integer.parseInt(st.nextToken());
		}
		
		//DP배열
		int[] dp = new int[HP+1];//체력 0~100
		
        for(int i=0; i<N;i++){
            //역순 순회로 중복 계산 방지
            for(int hp =HP-1; hp>=L[i]; hp--){
                dp[hp]=Math.max(dp[hp],dp[hp-L[i]]+J[i]);
            }
        }
        
		for(int i=1; i<HP;i++){
			happy=Math.max(happy,dp[i]);
		}
		System.out.println(happy);
	}

}