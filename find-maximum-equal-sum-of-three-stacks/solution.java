/*
 * AnyPush — AI explanation
 * This solution employs a greedy strategy to find the maximum equal sum. It starts by calculating the total sum of elements in each of the three stacks. Then, it iteratively removes the top-most element from the stack that currently has the largest sum. This process continues until all three stack sums become equal, at which point that common sum is the maximum possible result. If any stack becomes empty before equality is achieved, it's impossible to find a common sum, and the method returns 0.
 *
 * Time complexity is O(N1 + N2 + N3), where N1, N2, N3 are the sizes of the stacks, as each element is added to a sum once and removed from a sum at most once. Space complexity is O(1), as it only uses a few auxiliary variables for sums and pointers.
 *
 * This greedy approach is highly efficient because it always makes the locally optimal choice by reducing only the largest sum, which is essential for convergence to an equal sum without prematurely reducing smaller sums. This avoids the combinatorial explosion of brute-force approaches that would try all possible prefix combinations.
 *
 * A more naive attempt might involve generating all possible prefix sums for each stack and finding a common value among the three sets, potentially leading to O(N^3) or O(N*logN) solutions if using hash sets for intersection, which would be significantly less performant than this linear scan.
 */

class Solution {
    public static int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int num : s1) 
            sum1 += num;
        for (int num : s2) 
            sum2 += num;
        for (int num : s3) 
            sum3 += num;

        int i1 = 0, i2 = 0, i3 = 0;

        while (i1 < s1.size() && i2 < s2.size() && i3 < s3.size()) {
            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= s1.get(i1++);
            else 
                if (sum2 >= sum1 && sum2 >= sum3)
                sum2 -= s2.get(i2++);
            else 
                if (sum3 >= sum1 && sum3 >= sum2)
                sum3 -= s3.get(i3++);
        }

        return 0;
    }
}
