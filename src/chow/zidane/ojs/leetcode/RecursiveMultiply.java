package chow.zidane.ojs.leetcode;

class RecursiveMultiply {

    static int multiplyWithPlus(int addend, int count) {
        if (count == 1) return addend;
        else {
            return addWithBitManipulation(multiplyWithPlus(addend, count - 1), addend);
        }
    }

    static int multiplyWithBitShifting(int n1, int n2) {
        int ace = 0;
        while (n2 != 0) {
            if ((1 & n2) == 1)
                ace = addWithBitManipulation(ace, n1);
            n1 <<= 1;
            n2 >>= 1;
        }
        return ace;
    }

    private static int addWithBitManipulation(int n1, int n2) {
        int digit = 1;
        int carry = 0;
        int res = 0;
        while (digit <= n1 || digit <= n2){
            int bit1 = n1 & digit;
            int bit2 = n2 & digit;
            int bit = bit1 ^ bit2 ^ carry;
            carry = (carry | bit1) ^ (carry | bit2) ^ (bit1 | bit2);
            res |= bit;
            digit <<= 1;
            carry <<= 1;
        }
        if (carry != 0) {
            res |= carry;
        }
        return res;
    }
}
