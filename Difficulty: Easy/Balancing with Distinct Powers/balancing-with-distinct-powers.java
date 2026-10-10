class Solution {
    public boolean balancePan(int a, int b) {
        if (a == 1)
            return b == 0;

        while (b > 0) {
            int rem = b % a;

            if (rem == 0)
                b /= a;
             else if (rem == 1) {
                b -= 1;
                b /= a;
            } else 
                if (rem == a - 1){
                    b += 1;
                    b /= a;
             }else 
                return false;
        }

        return true;
    }
}