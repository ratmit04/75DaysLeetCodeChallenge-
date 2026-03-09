class Solution {
    public int reverse(int x) {
        int n=x,c=0;
        long rev=0l;
         while(n!=0)
        {
            int a=n%10;
            rev=rev*10+a;
            n=n/10;
        }
        if(rev>=((int)(Math.pow(-2,31)))&&rev<=((int)((Math.pow(2,31))-1)))
        {
            return (int)rev;
        }    
        else
        {
            return 0;
        }
    }
}