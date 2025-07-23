// package Step Words Finder pivotal;
import java.util.*;
public class GroupAnagramBruteForce {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            boolean placed = false;
            for (List<String> group : result) {
                if (isAnagram(group.get(0), str)) {
                    group.add(str);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagramBruteForce g = new GroupAnagramBruteForce();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
