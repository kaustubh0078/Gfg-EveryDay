import java.util.*;
public class CaseSpecificSorting {
    public static String caseSort(String s) {
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) upper.add(c);
            else lower.add(c);
        }
        Collections.sort(upper);
        Collections.sort(lower);
        StringBuilder sb = new StringBuilder();
        int ui = 0, li = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(upper.get(ui++));
            else sb.append(lower.get(li++));
        }
        return sb.toString();
    }
}
