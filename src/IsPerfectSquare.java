public class IsPerfectSquare {


    public static boolean isPerfectSquare(int num) {

        if (num < 0) return false;
        if (num == 0) return true;

        long left = 0;
        long right =Integer.MAX_VALUE;

        while (left <= right)
        {
            long mid =(left + right) / 2;
            long midSqr = mid * mid;
            if (midSqr == num) return true;
            else if (midSqr > num) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
