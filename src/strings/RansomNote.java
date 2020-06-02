package strings;

import java.util.HashMap;
import java.util.Map;

//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//Each letter in the magazine string can only be used once in your ransom note.
//
//Note:
//You may assume that both strings contain only lowercase letters.
//
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
public class RansomNote {


    public static boolean canConstruct(String ransomNote, String magazine) {
         boolean canConstrant =true;
        Map<Character, Integer> words = new HashMap<>();
        for(char ch: magazine.toCharArray()){
           if(words.containsKey(ch)){
               words.computeIfPresent(ch, (ch1, value) -> value+1);
           }else words.put(ch, 1);
        }

        for (char ch :ransomNote.toCharArray()){
            if(words.containsKey(ch) && words.get(ch)>0){
                words.computeIfPresent(ch, (ch1, value) -> value-1);
            }else{
                canConstrant =false;
            }
        }

         return canConstrant;
    }


    public static void main(String[] args) {
        System.out.println(canConstruct("a", "ba"));
    }
}
