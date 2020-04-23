import java.util.LinkedList;
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//Example 1:
//
//Input: [5,7]
//Output: 4
//Example 2:
//
//Input: [0,1]
//Output: 0


//a << 1; // беззнаковый сдвиг влево, эквивалентно умножению на 2
//        a >> 1; // сдвиг вправо с учётом знака (эквивалентно делению на 2)
//        a >>> 1; // сдвиг вправо без учёта знака (эквивалентно беззнаковому делению на 2)
public class BitwiseANDofNumbersRange {

    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while(m < n){ // when equals 0, stop
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,40));
    }
}
