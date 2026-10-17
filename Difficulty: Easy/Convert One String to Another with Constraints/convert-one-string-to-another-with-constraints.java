class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) 
            return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != '#') 
                sb1.append(s1.charAt(i));
            if (s2.charAt(i) != '#') 
                sb2.append(s2.charAt(i));
        }

        if (!sb1.toString().equals(sb2.toString())) 
            return false;

        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') 
                i++;
            while (j < n && s2.charAt(j) == '#') 
                j++;

            if (i == n && j == n) 
                break;
            if (i == n || j == n) 
                return false;

            if (s1.charAt(i) != s2.charAt(j)) 
                return false;

            if (s1.charAt(i) == 'A') {
                if (i < j) 
                    return false;
            } else {
                if (i > j) 
                    return false;
            }
            i++;
            j++;
        }

        return true;
    }
}