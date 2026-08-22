bool checkDivisibility(int n) {
    int temp=n,digits,sum=0,product=1;
    while(temp>0)
    {
        digits=temp%10;
        temp/=10;
        sum+=digits;
        product*=digits;
    }
    if(sum+product == n)
        return true;
    else
        return false;
    
}