/*
    Explanation:
        This question expects us to find the number of "good numbers", which should have even numbers {0,2,4,6,8} in their even indices and prime numbers 
        {2,3,5,7} in their odd indices. The right approach would require us to find the number of even and odd positions in the given size of number.
        Then comes the tricky part, we cant use Math.pow() to compute because it is expensive to do that when the number can be within 10^9 + 7.

        We are gonna build a power function that uses divide and conquer method to find the power efficiently. 

        if exponent is equal to 0:
            returns 1;
        we find power(number, exponent / 2) no matter if exponent is odd or even.
        We multiply the result by result itself. [ x^Y = x^(Y/2) * x^(Y/2) ]
        Then if exponent is odd, we multiply the result by base number to compensate
        for the missing power. 

*/



class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        
        long evenCount = n / 2 + (n % 2);
        long oddCount = n / 2;

        long evenWays = power(5,evenCount);
        long oddWays = power(4,oddCount);

        return (int) ((evenWays * oddWays) % MOD);
    }

    public long power(long base, long exp){

        if(exp == 0) return 1;
        long half = power(base, exp/2);
        long result = half*half % MOD;
        if(exp % 2 == 1) result = result*base % MOD;
        return result;
    }

}
