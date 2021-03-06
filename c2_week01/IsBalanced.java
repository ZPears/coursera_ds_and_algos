import java.util.*;
import java.io.*;
import java.lang.Math;

public class IsBalanced {

    public static void main(String[] args) {
        int isBalanced = new IsBalanced().findBalance(args[0]);
        if (isBalanced < 0) {
            System.out.println("Success");
        } else {System.out.println(isBalanced);}
    }

    private class ParenWithIdx {
        Paren paren;
        int idx;

        ParenWithIdx(Character c, int i) {
            paren = new Paren(c);
            idx = i;
        }

        ParenWithIdx(Paren p, int i) {
            paren = p;
            idx = i;
        }
    }

    private static class ParenManager {
        private static Set<Character> LeftParens = new HashSet<Character>(
            Arrays.asList('{', '[', '('));
        private static Set<Character> RightParens = new HashSet<Character>(
            Arrays.asList('}', ']', ')')); 

        public static boolean isLeftParen(Character c) {
            return (LeftParens.contains(c));
        }

        public static boolean isRightParen(Character c) {
            return (RightParens.contains(c));   
        }

        public static boolean isParen(Character c) {
            return (isLeftParen(c) || isRightParen(c));
        }
    }

    private class Paren {
        Character parenChar;
        
        Paren(Character c) { parenChar = c; }

        private Map<Character, Character> matchMap = new HashMap<Character, Character>();

        private void buildMap() {
            matchMap.put('{', '}');
            matchMap.put('[', ']');
            matchMap.put('(', ')');
        }

        public boolean isMatched(Character c) {
            if (matchMap.isEmpty()) { buildMap(); }
            return (matchMap.get(parenChar) == c); 
        }
    }


    private int findBalance(String str) {
        Stack<ParenWithIdx> st = new Stack<ParenWithIdx>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (ParenManager.isLeftParen(c)) {
                Paren newParen = new Paren(c);
                st.push(new ParenWithIdx(newParen, i));
            }
            else if (ParenManager.isRightParen(c)) {
                ParenWithIdx top = st.pop();
                if (!top.paren.isMatched(c)) {
                    return i + 1 ;
                }
            }
        }
        if (st.empty()) { return -1; }
        else { return st.pop().idx + 1 ; }
    }
}