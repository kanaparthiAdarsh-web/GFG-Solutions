class Solution {
    public int minOperation(int n) {
        int count = 0;
        for(;n > 0 ; n= (n % 2 == 0)?  n/ 2 : n- 1 ,count++);
        return count;
    }
}