import java.util.Arrays;

public class IncreasingSequencesEasySol {
    static int [] l, r;
    static int n, mod = 998244353;
    private static int[][] dp;

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 1, 1}, new int[]{10000, 10000, 10000}));
    }

    public static int count(int[] L, int[] R) {
        l = L; r = R;
        n = l.length;
        dp = new int[n + 2][10005];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 10000; j >= 0; j--) {
                solve(i, j);
            }
        }
        return solve(0, l[0]);
    }

    private static int solve(int ind, int lst) {
        if (ind == n) {
            return 1;
        }
        if (lst > r[ind]) {
            return 0;
        }
        if (lst < l[ind]) {
            return solve(ind, l[ind]);
        }
        if (dp[ind][lst] != -1) {
            return dp[ind][lst];
        }
        return dp[ind][lst] = (solve(ind + 1, lst + 1) + solve(ind, lst + 1)) % mod;
    }
}
