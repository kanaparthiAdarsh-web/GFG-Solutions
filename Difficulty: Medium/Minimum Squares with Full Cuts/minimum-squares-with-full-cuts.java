class Solution {
    public int minSquares(int n, int m) {
        if (n == m) 
            return 1;
            
        if (n < m)
            n=n+m-(m=n);
            
        if (n % m == 0)
            return n / m;
            
        return (n / m) + minSquares(m, n % m);
    }
}