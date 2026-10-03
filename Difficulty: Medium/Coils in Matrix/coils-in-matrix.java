import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 8 * n * n;
        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        int first = 8 * n * n + 2 * n;
        coil1.add(first);
        int curr = first;
        int flag = 1;
        int step = 2;

        while (coil1.size() < m) {
            for (int i = 0; i < step && coil1.size() < m; i++) {
                curr -= 4 * n * flag;
                coil1.add(curr);
            }
            for (int i = 0; i < step && coil1.size() < m; curr += flag,coil1.add(curr),i++);

            flag *= -1;
            step += 2;
        }

        for (int i = 0; i < m; coil2.add(16 * n * n + 1 - coil1.get(i)),i++);
        

        Collections.reverse(coil1);
        Collections.reverse(coil2);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(coil2);
        ans.add(coil1);
        return ans;
    }
}