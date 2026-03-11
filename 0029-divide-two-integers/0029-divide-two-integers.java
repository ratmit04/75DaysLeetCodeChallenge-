class Solution {
    public int divide(int dividend, int divisor) {
        int quotient=dividend/divisor;
        if(quotient<((int)(Math.pow(-2,31))))
            return ((int)(Math.pow(-2,31)));
        if(quotient>((int)((Math.pow(2,31))-1)))
            return ((int)((Math.pow(2,31))-1));
        if(quotient==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        return quotient;
    }
}