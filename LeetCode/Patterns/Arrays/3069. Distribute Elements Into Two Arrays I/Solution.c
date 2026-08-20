int* resultArray(int* nums, int numsSize, int* returnSize) {
    int* arr1 = (int*)malloc(sizeof(int) * numsSize);
    int* arr2 = (int*)malloc(sizeof(int) * numsSize);
    int* result = (int*)malloc(sizeof(int) * numsSize);
    int len1 = 0;
    int len2 = 0;
    arr1[len1++] = nums[0];
    arr2[len2++] = nums[1];
    
    for (int i = 2; i < numsSize; i++) 
        if (arr1[len1 - 1] > arr2[len2 - 1])
            arr1[len1++] = nums[i];
        else
            arr2[len2++] = nums[i];
    
    int idx = 0;
    for (int i = 0; i < len1; i++)
        result[idx++] = arr1[i];
    for (int i = 0; i < len2; i++)
        result[idx++] = arr2[i];
    
    free(arr1);
    free(arr2);
    
    *returnSize = numsSize;
    return result;
}