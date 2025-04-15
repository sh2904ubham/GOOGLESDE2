import java.util.*;

class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        dp1[1] = k;
        dp2[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp2[i] = dp1[i - 1];
            dp1[i] = (dp1[i - 1] + dp2[i - 1]) * (k - 1);
        }
        System.out.println((dp1[n] + dp2[n]));//dp
    }

}
