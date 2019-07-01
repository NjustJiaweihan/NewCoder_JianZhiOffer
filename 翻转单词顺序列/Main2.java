public class Solution{
    public String LeftRotateString(String str,int n) {

        if(str == null || str.length() == 0) {

            return "";
        }

        return new StringBuilder((new StringBuilder(str.substring(0, n)).reverse()).append(new StringBuilder(str.substring(n)).reverse())).reverse().toString();
    }
}
