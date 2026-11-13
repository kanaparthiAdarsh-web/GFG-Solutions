/*
 * AnyPush — AI explanation
 * This solution finds common nodes by performing a simultaneous in-order traversal on both BSTs. It uses two stacks to iteratively generate the next smallest node from each tree, effectively treating them as sorted sequences. We compare the current nodes (peeked from stacks); if values match, we add to the result and advance both traversals. If one value is smaller, we advance only that tree's traversal to seek a larger element.
 *
 * Time complexity is O(N1 + N2), as each node is visited and processed at most once.
 * Space complexity is O(H1 + H2) for the two traversal stacks, where H is the height of the respective BST.
 *
 * This approach is efficient as it avoids materializing full sorted lists of nodes for both BSTs, processing elements on-demand. This limits auxiliary space to the maximum height of the trees rather than the total number of nodes.
 *
 * A simpler alternative would be to flatten both trees into sorted arrays and then find common elements. However, that would consume O(N1 + N2) auxiliary space, whereas this iterative method uses O(Height) stack space.
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

            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

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
