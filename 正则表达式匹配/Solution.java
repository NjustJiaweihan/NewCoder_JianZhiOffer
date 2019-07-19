public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){

        if(strIndex==str.length && patternIndex==pattern.length){
            return true;
        }

        if(patternIndex==pattern.length && strIndex!=str.length){
            return false;
        }

        //pattern第二是'*'
        if(patternIndex+1<pattern.length && pattern[patternIndex+1]=='*') {

            //首字符匹配 分三种 1."x*"->"" 2."x*"->"x" 3."x*"->"xx*"
            if(strIndex<str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')){

                return matchCore(str, strIndex, pattern, patternIndex+2)
                        || matchCore(str, strIndex+1, pattern, patternIndex+2)
                        || matchCore(str, strIndex+1, pattern, patternIndex);

            //首字符不匹配 1."x*"->""
            } else {

                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }

        //pattern第二个不是'*'

        //首字符匹配
        if(strIndex<str.length && (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.')){

            return matchCore(str, strIndex+1, pattern, patternIndex+1);

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().match("".toCharArray(), ".*".toCharArray()));
    }
}
