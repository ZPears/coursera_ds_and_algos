import java.util.*;
import java.io.*;
import java.lang.Math;

public class IsBalanced {

    private static class ParenWithIdx {
        Character paren;
        int idx;

        ParenWithIdx(Character c, int i) {
            paren = c;
            idx = i;
        }
    }

    public static void main(String[] args) {
        System.out.println(findBalance(args[0]));
    }

    private static int findBalance(String str) {
        Stack<ParenWithIdx> st = new Stack<ParenWithIdx>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == '(' || c == '[') {
                st.push(new ParenWithIdx(c, i));
            }
            else {
                if (st.empty()) { return i; }
                ParenWithIdx top = st.pop();
                if ((top.paren == '[' && c != ']') || (top.paren == '(' && c != ')')) {
                    return top.idx;
                }
            }
        }
        return -1;
    }
}