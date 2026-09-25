import java.util.*;

class Solution {

    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        return new ArrayList<>(new TreeSet<>(result));
    }

    // Parse one complete expression
    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {

            Set<String> current;

            // If we find '{', parse everything inside it
            if (s.charAt(index) == '{') {
                index++; // skip '{'
                current = parse(s);
                index++; // skip '}'
            } 
            else {
                // Single character
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(index)));
                index++;
            }

            // Concatenation:
            // result × current
            if (result.isEmpty()) {
                result.addAll(current);
            } 
            else {
                Set<String> temp = new HashSet<>();

                for (String a : result) {
                    for (String b : current) {
                        temp.add(a + b);
                    }
                }

                result = temp;
            }

            // Union inside braces
            if (index < s.length() && s.charAt(index) == ',') {
                index++; // skip ','
                
                Set<String> next = parse(s);

                result.addAll(next);
            }
        }

        return result;
    }
}