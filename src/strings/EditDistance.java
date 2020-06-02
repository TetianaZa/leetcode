package strings;

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//You have the following 3 operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character
//Example 1:
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//Example 2:
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int steps = 0;
        Integer[] letters = new Integer[26];
        for (char ch : word2.toCharArray()) {
            letters[ch - 'a'] = letters[ch - 'a'] + 1;
        }
        int startPoint = 0;
        for (char ch : word2.toCharArray()) {
            for (int j = startPoint; j < word1.length(); j++) {

                if (ch==word1.charAt(j)){
                    startPoint++;
                    letters[ch - 'a'] = letters[ch - 'a'] -1;
                }

                if(ch!=word1.charAt(j) &&  letters[ch - 'a']>0 )  {
                    steps++;
                }

            }
        }


        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
