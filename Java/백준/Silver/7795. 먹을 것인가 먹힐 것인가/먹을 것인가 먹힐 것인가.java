import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int T = Integer.parseInt(br.readLine());//테스트케이스 갯수
		for(int i=0; i<T;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//A 갯수
			int M = Integer.parseInt(st.nextToken());//B 갯수
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);	// 작은 수부터 정렬?
			int result = 0;
			
			for(int j=0; j<N;j++){
				int first =0;
				int end =M-1;
				int index =0;
				
				while(first<=end){
					int mid =(first+end)/2;
					if(B[mid]<A[j]){
						first = mid+1;
						index = mid+1;
					}else{
						end = mid-1;
					}
				}
				result +=index;
			}
			bw.write(Integer.toString(result)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}