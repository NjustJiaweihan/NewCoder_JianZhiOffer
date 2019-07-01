import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public String ReverseSentence(String str) {

        if(str == null || str.trim().length() == 0) {

            return str;
        }

        StringBuilder s = new StringBuilder(str).reverse().append(' ');

        int i = 0, j;
        for(j = 0; j<s.length(); j++){

            if(s.charAt(j) == ' '){

                StringBuilder temp = new StringBuilder(s.subSequence(i, j)).reverse();
                //System.out.println("temp: " + temp);

                s.replace(i, j, temp.toString());
                //System.out.println("s: " + s);

                i = j + 1;
            }
        }

        return s.toString().substring(0, s.length()-1);
    }

    public static void main(String[] args) {

        System.out.println(new Solution().ReverseSentence("han. am i"));
    }
}
