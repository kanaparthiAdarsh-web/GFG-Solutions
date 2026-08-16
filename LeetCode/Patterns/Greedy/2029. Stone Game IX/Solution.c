bool stoneGameIX(int* stones, int stonesSize) {
    int remin_0=0,remin_1=0,remin_2=0;
    for(int i=0;i<stonesSize;i++)
    {
        int remin=stones[i]%3;
        if(remin==0)
            remin_0++;
        else
            if(remin==1)
                remin_1++;
        else
            remin_2++;
    }
    if(remin_0%2)
    {
        int diff=remin_1>remin_2?remin_1-remin_2:remin_2-remin_1;
        return diff>2;
    }
    else
        return remin_1>0 && remin_2>0;
}