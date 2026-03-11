class Solution {
    public int divide(int dividend, int divisor) {
        int quotient=dividend/divisor;
        if(quotient<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(quotient>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(quotient==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        return quotient;
    }
}