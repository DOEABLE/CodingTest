import java.util.*;

public class Main {
    static final int MAX = 100001;
    static int n, k, ans;
    static List<Integer>[] v = new ArrayList[MAX];
    static int[] cnt = new int[MAX];

    public static void dfs(int now, int ncnt) {
        if (ncnt > k) return;
        ans += cnt[now];
        for (int next : v[now]) {
            dfs(next, ncnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // 리스트 초기화
        for (int i = 0; i < MAX; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            v[s].add(e);
        }

        for (int i = 0; i < n; i++) {
            cnt[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(ans);
        sc.close();
    }
}
