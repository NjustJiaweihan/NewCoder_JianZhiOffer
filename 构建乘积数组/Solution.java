public class Solution {
    public int[] multiply(int[] A) {

        
        if(A == null || A.length == 0){
            
            return null;
        }

        int n = A.length;
        
        int[] B = new int[n];
        
        B[0] = 1;
        
        //下三角
        for(int i=1; i<n; i++){
            
            B[i] = B[i-1] * A[i-1];
        }
        
        int temp = 1;
        
        //上三角
        for(int i=n-2; i>=0; i--){
            
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }
}
