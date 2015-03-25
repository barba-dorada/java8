import java.util.Stack;

/**
 * Created by vad on 23.03.2015 19:15.
 */
public class ex100 {
    static public boolean check(String s) {
        String open = "{[(";
        String close = "}])";
        char stack[] = new char[100];
        int ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = open.indexOf(c);
            if (index >= 0) {
                stack[ptr++] = close.charAt(index);
                continue;
            }
            if (close.indexOf(c) == -1) continue;
            if (ptr == 0 || c != stack[ptr - 1]) return false;
            ptr--;
        }
        return ptr==0;
    }
    static public boolean check2(String s) {
        java.util.Stack<Character> stack=new Stack<>();
        String openBrackets = "{[(";
        String closeBrackets = "}])";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = openBrackets.indexOf(c);
            if (index >= 0) {
                stack.push(closeBrackets.charAt(index));
                continue;
            }
            if (closeBrackets.indexOf(c) == -1) continue;
            if (stack.empty() || c != stack.pop()) return false;
        }
        return stack.empty();
    }
}
