/*
 * AnyPush — AI explanation
 * This solution efficiently finds common nodes by performing a simultaneous in-order traversal on both BSTs. We use two stacks to iteratively simulate in-order traversal, effectively treating the trees as sorted sequences. At each step, we compare the smallest available nodes from both trees: if values match, we add to the result and advance both; otherwise, we advance the traversal for the tree with the smaller current node. This approach processes nodes on-the-fly.
 *
 * Time Complexity: O(N1 + N2), as each node is visited and pushed/popped at most a constant number of times.
 * Space Complexity: O(H1 + H2), where H1 and H2 are the heights of the BSTs, as stacks store the path to the current node.
 *
 * This iterative approach was chosen to optimize space. Our earlier considerations included converting both BSTs to sorted ArrayLists and then finding common elements. While simple, that approach would incur O(N1 + N2) auxiliary space regardless of tree structure. This current method, however, limits its space footprint to O(H1 + H2), achieving O(logN) for balanced trees, a significant improvement in common scenarios.
 */

class Solution {
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr1 = r1;
        Node curr2 = r2;

        while (curr1 != null || !s1.isEmpty() || curr2 != null || !s2.isEmpty()) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            if (s1.isEmpty() || s2.isEmpty())
                break;

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            if (top1.data == top2.data) {
                result.add(top1.data);
                s1.pop();
                s2.pop();
                curr1 = top1.right;
                curr2 = top2.right;
            } else if (top1.data < top2.data) {
                s1.pop();
                curr1 = top1.right;
            } else {
                s2.pop();
                curr2 = top2.right;
            }
        }

        return result;
    }
}
