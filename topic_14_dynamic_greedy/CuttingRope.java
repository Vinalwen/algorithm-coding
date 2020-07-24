package topic_14_dynamic_greedy;

/**
 * @author wenyao
 * @create 2020-07-24 19:03
 * ^-^ Fighting!
 */
public class CuttingRope {
    public int integerBreak_dynamic(int n) {
        switch(n){
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4;i <= n;i++){
            int max = 0;
            for (int j = 1; j <= i/2;j++){
                int cn = dp[j]*dp[i-j];
                if (cn > max)
                    max = cn;
            }
            dp[i] = max;
        }
        return dp[n];
    }
    //别人的解法：
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
        return dp[n];
    }

    public int integerBreak_greedy(int n) {

    }
}
