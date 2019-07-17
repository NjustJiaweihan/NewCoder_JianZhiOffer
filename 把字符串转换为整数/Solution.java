public class Solution {
    
    public int StrToInt(String str) {

        if(str == null || str.equals("")){

            return 0;
        }

        //判断正负 case: "+"
        if(str.length() == 1){

            int res = str.charAt(0);
            return res>='0'&&res<='9' ? res-'0' : 0;
        }
        boolean isPositive = true;

        char c = str.charAt(0);
        if(c == '-'){
            isPositive = false;
            str = str.substring(1);

        } else if(c >='0' && c <= '9'){
            isPositive = true;

        } else if(c == '+'){
            isPositive = true;
            str = str.substring(1);
        }
        else {
            return 0;
        }
        
        //是否含有非法字符
        if(!isValid(str)){
            return 0;
        }

        //计算long型值 (直接用long其实不靠谱 万一溢出long呢)
        if(str.length() > 10)
        {
            retrun 0;
        }
        
        long res = str.charAt(str.length()-1) - '0';

        for(int i=str.length()-2; i>=0; i--){

            res += (str.charAt(i)-'0') * Math.pow(10, (str.length() - 1 - i));
        }

        //只包含数字时 要验证是否溢出
        //Integer.MAX_VALUE =  2147483647
        //Integer.MIN_VALUE = -2147483648
        if(isPositive && res > Integer.MAX_VALUE){

            return 0;

        } else if(!isPositive && res < Integer.MIN_VALUE){

            return 0;
        }

        //注意正负
        return isPositive ? (int) res : -(int) res;
    }

    /**
     * 是否含有非法字符
     * @param s
     * @return
     */
    private boolean isValid(String s){

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            if(c <'0' || c > '9'){

                return false;
            }
        }
        return true;
    }
}
