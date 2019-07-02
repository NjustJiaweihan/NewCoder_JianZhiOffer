public class Solution {
    
    public int LastRemaining_Solution(int n, int m) {

        //标记小朋友是否出队 false: 在队 true: 出队
        boolean[] marked = new boolean[n];
        //出队人数
        int cnt = 0;

        //游标
        int index = 0;
        //报数器
        int count = 0;

        //队中人数 >=2 继续游戏
        while (cnt < n-1){

            //如果非法位置 游标向前
            if(marked[index % n]){

                index++;
                continue;
            }

            //位置合法 count==m-1 出一个
            if(count == m -1){

                marked[index % n] = true;
                //System.out.println(index%n);
                cnt++;
                count = 0;
                index++;

            } else {
            //否则继续报数
                count++;
                index++;
            }
        }

        //寻找没有出队的最后一个小朋友
        for(int i=0; i<marked.length; i++){

            if(!marked[i]){

                //System.out.println(i);
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        //赢家是3
        new Solution().LastRemaining_Solution(7, 3);
    }
}
