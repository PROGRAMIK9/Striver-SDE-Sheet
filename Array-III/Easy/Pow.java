class Solution {
    public double pow(double x, int n){
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return pow(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * pow(x, n - 1);
    }
    public double myPow(double x, int n) {
        long e = n;
        //if power is negative
        if(e < 0){
            //invert x
            x = 1 / x;
            //negate e to make it positive
            e = -e;
        }
        //store ans
        double ans = 1;
        //as long as e is positive
        while(e > 0){
            //when the last digit multiply ans with 2
            if((e & 1) == 1){
                ans *= x;
            }
            //square x otherwise
            x *= x;
            //divide e by 2
            e >>= 1;
        }
        //return power
        return ans;
    }
}
