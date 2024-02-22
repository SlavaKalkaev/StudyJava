package stack;

import java.util.Scanner;

public class Skobki {
    public static boolean checkBrackets(String text) {
        StackImpl<Character> stack = new StackImpl();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                stack.push(text.charAt(i));
            } else if (!stack.isEmpty() && text.charAt(i) == ')') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String text = (s.nextLine());
        boolean check = checkBrackets(text);
        System.out.println(check);
    }
}
