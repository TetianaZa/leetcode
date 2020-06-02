package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//The order of output does not matter.
//
//Example 1:
//
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//Example 2:
//
//Input:
//s: "abab" p: "ab"
//
//Output:
//[0, 1, 2]
//
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab"
public class FindAllAnagramsinString {

    public static List<Integer> findAnagrams(String s, String p) {

        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            map[p.charAt(i) - 'a']++;
        }

        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd<s.length()){
            // valid anagram
            if(map[s.charAt(windowEnd) - 'a'] > 0){
                map[s.charAt(windowEnd++) - 'a']--;
                // window size equal to size of P
                if(windowEnd-windowStart ==  p.length()){
                    result.add(windowStart);
                }
            }
            // window is of size 0
            else if(windowStart == windowEnd){
                windowStart ++;
                windowEnd ++;
            }
            // decrease window size
            else{
                map[s.charAt(windowStart++) - 'a']++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(findAnagrams( "abc","ab"));
    }

}

