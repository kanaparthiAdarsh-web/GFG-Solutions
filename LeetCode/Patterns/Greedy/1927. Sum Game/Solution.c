bool sumGame(char* num) {
    int n = strlen(num);
    int half = n / 2;
    int left_sum = 0, right_sum = 0;
    int left_q = 0, right_q = 0;

    for (int i = 0; i < half; i++)
        if (num[i] == '?')
            left_q++;
        else
            left_sum += num[i] - '0';

    for (int i = half; i < n; i++)
        if (num[i] == '?')
            right_q++;
        else
            right_sum += num[i] - '0';

    if ((left_q + right_q) % 2 != 0)
        return true;

    int sum_diff = left_sum - right_sum;
    int q_diff = right_q - left_q;

    if (sum_diff * 2 == q_diff * 9)
        return false;

    return true;
}