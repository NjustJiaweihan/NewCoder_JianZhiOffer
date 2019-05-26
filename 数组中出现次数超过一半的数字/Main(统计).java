import java.util.HashMap;

class Solution {
    
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array == null || array.length == 0) {
            
            return 0;
        }
        
        HashMap<Integer, Integer> cnt = new HashMap<>();
        
        for(int i=0; i<array.length; ++i) {
            
            if(cnt.containsKey(array[i])) {
                
                cnt.put(array[i], cnt.get(array[i])+1);
            } else {
                
                cnt.put(array[i], 1);
            }
        }
        
        for(Integer i : cnt.keySet()) {
            
            if(cnt.get(i) > array.length/2) {

                return i;
            }
        }
        
        return 0;
    }
}
