//n=1  -  只有横放一个矩形一种解决办法
//n=2  -  有横放两个矩形，竖放两个矩形两种解决办法
//n=3  -  n=2的基础上加1个横向，n=1的基础上加2个竖向
//n=4  -  n=3的基础上加1个横向，n=2的基础上加2个竖向

//例 n=3 2*3的大矩形 =  n=2加上横向的小矩形 + n=1加上两个纵向小矩形
// __ __ __ __        __ __ __ __       __ __ __ __
//|           |      |    new    |     |   ne|w    |
//|           |      |__ __ __ __|     |     |     |
//|           |      |           |     |     |     |
//|           | ==   |__ __2__ __|  +  |__ __|__ __|
//|           |      |           |     |     1     |
//|__ __ __ __|      |__ __ __ __|     |__ __ __ __|

class Solution {

    public int RectCover(int target) {

        if (target == 0 || target == 1 || target == 2) {

            return target;
        }

        int[] res = new int[target + 1];

        res[0] = 0;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i < target + 1; ++i) {

            res[i] = res[i - 1] + res[i - 2];
        }

        return res[target];
    }
}
