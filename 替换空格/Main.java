class Solution {
    public String replaceSpace(StringBuffer str) {

        char[] words = str.toString().toCharArray();

        StringBuffer res = new StringBuffer();

        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                res.append("%20");
            } else {

                res.append(words[i]);
            }
        }

        return res.toString();
    }
}

public class Main{

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("We are Happy");

        Solution solution = new Solution();

        System.out.println(solution.replaceSpace(str));
    }
}
