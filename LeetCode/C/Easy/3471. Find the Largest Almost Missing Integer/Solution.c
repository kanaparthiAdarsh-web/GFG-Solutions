int largestInteger(int* nums, int numsSize, int k) {
    int sub_count[55];
    memset(sub_count, 0, sizeof(sub_count));
    
    for (int i = 0; i <= numsSize - k; i++) {
        int seen[55];
        memset(seen, 0, sizeof(seen));
        
        for (int j = i; j < i + k; j++) {
            int val = nums[j];
            if (!seen[val]) {
                seen[val] = 1;
                sub_count[val]++;
            }
        }
    }
    
    int ans = -1;
    for (int v = 0; v <= 50; v++)
        if (sub_count[v] == 1)
            if (v > ans)
                ans = v;
    
    return ans;
}