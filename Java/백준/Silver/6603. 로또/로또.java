import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;

            arr = new int[n];    //input
            result = new int[6];
            
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            back(0, 0);
            sb.append("\n");
            

        }
        System.out.println(sb);

    }

    static void back(int start, int depth) {
        if (start == 6) {
            for (int i=0; i<6; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = depth; i < n; i++) {
            result[start] = arr[i];
            back(start+1, i+1);
        }
    }
}