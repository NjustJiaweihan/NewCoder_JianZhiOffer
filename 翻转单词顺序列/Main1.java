import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public String ReverseSentence(String str) {

        if(str == null || str.trim().length() == 0) {

            return str;
        }
        if(str.charAt(str.length()-1) != ' '){

            str += ' ';
        }
        int i = 0, j = 0;
        ArrayList<String> res = new ArrayList<>();

        for(j=0; j<str.length(); j++){

            if(str.charAt(j) == ' '){

                res.add(str.substring(i, j));
                i = j + 1;
            }
        }

        Collections.reverse(res);

        StringBuilder s = new StringBuilder();

        for(String s1 : res) {

            s.append(s1);
            s.append(" ");
        }

        return s.toString().substring(0, s.length()-1);
    }
}
