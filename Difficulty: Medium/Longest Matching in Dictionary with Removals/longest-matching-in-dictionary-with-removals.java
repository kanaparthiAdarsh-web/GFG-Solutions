class Solution {
    public String findLongestWord(String s, List<String> d) {
        ArrayList<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            pos[i] = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++)
            pos[s.charAt(i) - 'a'].add(i);
        
        String res = "";
        for (String word : d)
            if (isSubsequence(word, pos))
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) 
                    res = word;
        return res;
    }

    private boolean isSubsequence(String word, ArrayList<Integer>[] pos) {
        int currIdx = -1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            ArrayList<Integer> list = pos[ch - 'a'];
            int idx = binarySearch(list, currIdx);
            if (idx == -1)
                return false;
            currIdx = list.get(idx);
        }
        return true;
    }

    private int binarySearch(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                ans = mid;
                high = mid - 1;
            } else 
                low = mid + 1;
        }
        return ans;
    }
}