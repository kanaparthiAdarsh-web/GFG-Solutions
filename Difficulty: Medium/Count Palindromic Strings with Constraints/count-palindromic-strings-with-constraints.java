class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007L;
        long totalCount = 0;

        for (int len = 1; len <= n; len++) {

            if ((len + 1) / 2 <= k) {
                long ways = 1;
                for (int i = 0; i < (len + 1) / 2; i++)
                    ways = (ways * (k - i)) % MOD;
                    
                totalCount = (totalCount + ways) % MOD;
            }
        }

        return (int) totalCount;
    }
}