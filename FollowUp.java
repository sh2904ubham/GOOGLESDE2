import java.util.*;

public class FollowUp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n == 1) {
            System.out.println(k);
            return;
        }
//WE will use 3 dp technique
        
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        int dp3[] = new int[n + 1];

        dp1[1] = k;
        dp2[1] = 0;
        dp3[1] = 0;

        if (n >= 2) {
            dp1[2] = dp1[1] * (k - 1);
            dp2[2] = dp1[1];
        }

        if (n >= 3) {
            dp1[3] = (dp1[2] + dp2[2]) * (k - 1);
            dp2[3] = dp1[1] * (k - 1);
            dp3[3] = dp2[2];
        }

        for (int i = 4; i <= n; i++) {
            dp1[i] = (dp1[i - 1] + dp2[i - 1] + dp3[i - 1]) * (k - 1);
            dp2[i] = (dp1[i - 2] + dp2[i - 2] + dp3[i - 2]) * (k - 1);
            dp3[i] = (dp1[i - 3] + dp2[i - 3] + dp3[i - 3]) * (k - 1);
        }

        System.out.println(dp1[n] + dp2[n] + dp3[n]);
    }
}
