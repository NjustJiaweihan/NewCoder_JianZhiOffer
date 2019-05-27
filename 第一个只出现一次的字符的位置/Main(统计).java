import java.util.LinkedHashMap;
import java.util.Map;

//第一次出现的 map<字符, 其索引>
//多次出现的 map<字符, Integer.MAX_VALUE>
class Solution {
    public int FirstNotRepeatingChar(String str) {

        //<字符, 其索引>
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); ++i) {

            if (!map.containsKey(str.charAt(i))) {

                map.put(str.charAt(i), i);
            } else {

                map.put(str.charAt(i), Integer.MAX_VALUE);
            }
        }

        for (Character c : map.keySet()) {

            if (map.get(c) != Integer.MAX_VALUE) {

                return map.get(c);
            }
        }
        return -1;
    }
}
