class Solution {
    public boolean isPossible(int n, int m, String s) {
        int r = 0, c = 0;
        int minR = 0, maxR = 0, minC = 0, maxC = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') 
                c--;
            else 
                if (ch == 'R') 
                    c++;
                else 
                    if (ch == 'D') 
                        r--;
                    else 
                        r++;

            if (r < minR) 
                minR = r;
            if (r > maxR) 
                maxR = r;
            if (c < minC) 
                minC = c;
            if (c > maxC) 
                maxC = c;

            if (maxR - minR >= n || maxC - minC >= m) 
                return false;
        }

        return true;
    }
}