public class FindComplement {

    public static int findComplement(int num) {
        return num ^ ((1<<Integer.toString(num, 2).length()) - 1);
    }

    public static void main(String[] args) {
        findComplement(1234);
    }
}
