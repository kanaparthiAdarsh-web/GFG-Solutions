class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        java.util.Queue<Node> q1 = new java.util.LinkedList<>();
        java.util.Queue<Node> q2 = new java.util.LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) 
                return false;

            java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

            for (int i = 0; i < size1; i++) {
                Node curr1 = q1.poll();
                Node curr2 = q2.poll();

                map.put(curr1.data, map.getOrDefault(curr1.data, 0) + 1);
                map.put(curr2.data, map.getOrDefault(curr2.data, 0) - 1);

                if (curr1.left != null) 
                    q1.add(curr1.left);
                if (curr1.right != null) 
                    q1.add(curr1.right);

                if (curr2.left != null) 
                    q2.add(curr2.left);
                if (curr2.right != null)    
                    q2.add(curr2.right);
            }

            for (int val : map.values())
                if (val != 0) return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}