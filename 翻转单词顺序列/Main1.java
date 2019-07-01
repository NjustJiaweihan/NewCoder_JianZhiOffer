public class Solution{
    public String LeftRotateString(String str,int n) {

        if(str == null || str.length() == 0) {

            return "";
        }

        int length = str.length();
        n = n % length;
        str += str;
        return str.substring(n, length+n);
    }
}
