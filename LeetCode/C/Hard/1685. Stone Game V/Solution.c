#include <stdlib.h>
#include <string.h>

int stoneGameV(int* stoneValue, int stoneValuesSize) {
    int n = stoneValuesSize;
    long long prefix[505];
    prefix[0] = 0;
    for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + stoneValue[i];
    }

    int dp[505][505];
    memset(dp, 0, sizeof(dp));

    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            int max_val = 0;
            for (int k = i; k < j; k++) {
                long long left_sum = prefix[k + 1] - prefix[i];
                long long right_sum = prefix[j + 1] - prefix[k + 1];
                int current = 0;
                if (left_sum < right_sum) {
                    current = left_sum + dp[i][k];
                } else if (left_sum > right_sum) {
                    current = right_sum + dp[k + 1][j];
                } else {
                    int opt1 = left_sum + dp[i][k];
                    int opt2 = right_sum + dp[k + 1][j];
                    current = opt1 > opt2 ? opt1 : opt2;
                }
                if (current > max_val) {
                    max_val = current;
                }
            }
            dp[i][j] = max_val;
        }
    }
    return dp[0][n - 1];
}