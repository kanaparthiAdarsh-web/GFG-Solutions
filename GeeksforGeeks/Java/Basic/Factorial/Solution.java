class Solution {
    int factorial(int n) {
        // code here
        int fact=1;
        for(int i=2;i<=n;fact*=i,i++);
        return fact;
    }
}
