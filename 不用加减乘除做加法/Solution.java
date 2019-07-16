public class Solution{

    public int Add(int num1,int num2) {

        while (num2 != 0){

            int a = num1 ^ num2;
            num2 = (num1 & num2)<<1;
            num1 = a;
        }
        return num1;
    }
}
