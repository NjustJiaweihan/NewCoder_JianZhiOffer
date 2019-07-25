public class Solution {

    /**
     * 0: 没出现过
     * -1: 出现多次了
     * 其余: 出现一次
     */
    private int[] char_occur;

    private int index;

    public Solution() {

        //有人用256的数组也可以ac
        char_occur = new int[(int) Math.pow(2, 16)];

        for (int i = 0; i < char_occur.length; ) {

            char_occur[i++] = 0;
        }

        index = 1;
    }

    //Insert one char from stringstream
    public void Insert(char ch) {

        switch (char_occur[ch]) {

            case 0:
                char_occur[ch] = index;
                index++;
                break;

            case -1:
                break;

            default:
                char_occur[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        char res = Character.MIN_VALUE;
        int minIndex = Integer.MAX_VALUE;

        for(int i=0; i<char_occur.length; i++){

            if(char_occur[i]>0 && char_occur[i] < minIndex){
                minIndex = char_occur[i];
                res = (char) i;
            }
        }

        return res == Character.MIN_VALUE ? '#' : res;
    }
}
