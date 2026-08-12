import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int d = (b * b) - (4 * a * c);
        
        if (d < 0) {
            arr.add(-1);
            return arr;
        }
        
        double sqrtVal = Math.sqrt(d);
        double root1 = (-b + sqrtVal) / (2.0 * a);
        double root2 = (-b - sqrtVal) / (2.0 * a);
        
        int r1 = (int) Math.floor(Math.max(root1, root2));
        int r2 = (int) Math.floor(Math.min(root1, root2));
        
        arr.add(r1);
        arr.add(r2);
        
        return arr;
    }
}