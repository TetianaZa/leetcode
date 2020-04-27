public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {

        char[] chr1 = text1.toCharArray();
        char[] chr2 = text2.toCharArray();
        int text1lenght = text1.length(), text2lenght = text2.length();
        if (text1lenght == 0 || text2lenght == 0) return 0;


        int[][] lcs = new int[text1lenght + 1][text2lenght + 1];

        for(int i = 1; i <= text1lenght; i++){
            for(int j = 1; j <= text2lenght; j++){
                if(chr1[i - 1] == chr2[j - 1]){
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }else{
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[text1lenght][text2lenght];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
