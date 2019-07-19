public class Solution {

    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {

            return false;
        }

        /**
         * 记录符号 e/E 小数点 是否出现过
         */
        boolean hasFlag = false;
        boolean hasE = false;
        boolean hasPoint = false;


        for (int i = 0; i < str.length; i++) {

            //e/E
            if(str[i] == 'E' || str[i] == 'e'){

                //第二次出现
                if(hasE){
                    return false;
                //第一次出现 后面必须跟数字 TODO 或者+-
                } else if(i ==str.length-1){
                    return false;

                } else if(str[i+1] != '+' && str[i+1] != '-'){

                    if(str[i+1]<'0' || str[i+1]>'9'){
                        return false;
                    }

                } else {
                    hasE = true;
                }
            }

            //+-
            else if(str[i] == '+' || str[i] == '-'){

                //第二次出现 必须跟在e/E之后
                if(hasFlag){
                    if(str[i-1] != 'e' && str[i-1] != 'E'){
                        return false;
                    }
                //第一次出现 必须在开头或者跟在E/e后面
                } else if(i != 0){

                    if(str[i-1] != 'e' && str[i-1] != 'E'){
                        return false;
                    }

                } else {
                    hasFlag = true;
                }
            }

            //.
            else if(str[i] == '.'){

                //e/E出现过了 就不能再出现小数点
                if(hasPoint || hasE){
                    return false;
                    
                } else {
                    hasPoint = true;
                }
            }

            //非法字符
            else if(str[i] >'9' || str[i] < '0'){

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().isNumeric("2e+5.4".toCharArray()));
    }
}
