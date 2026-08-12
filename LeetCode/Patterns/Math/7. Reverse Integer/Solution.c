int reverse(int x){
    int rev=0;

    if(x>0)
        while(x>0)
        {
            rev=rev*10+(x%10);
            x/=10;
        }
    else
        while(x<0)
        {
            rev=rev*10+(x%10);
            x/=10;
        }
    return rev;
}