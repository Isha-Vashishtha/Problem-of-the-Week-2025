import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);

            if (!map.containsKey(s)) {
                map.put(s, result.size());
                result.add(new ArrayList<>());
            }
            result.get(map.get(s)).add(strs[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagram g = new GroupAnagram();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
