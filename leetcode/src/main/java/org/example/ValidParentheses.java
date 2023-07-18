package org.example;

import java.util.Date;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/submissions/829506311/
public class ValidParentheses {

    public static void main(String[] args)
    {
            isValid2("()[]{}");
            isValid2("([)]");
            isValid2("{[]}");
            isValid2("[");
            isValid2("([])");
    }

    public static boolean isValid(String s) {
        long start = new Date().getTime();

        //method 1
        boolean b = true;
        char[] chars = s.toCharArray();
        Stack<Integer> parens = new Stack<>();
        Stack<Integer> squares = new Stack<>();
        Stack<Integer> curls = new Stack<>();

        //System.out.println("checking s = " + s);
        outer:
        for (int i = 0; i<chars.length; i++)
        {
            char aChar = chars[i];
            int curlsopen = -1;
            int squaresopen = -1;
            int parensopen = -1;
            switch (aChar)
            {
                case  '{' :
                    curls.push(i);
                    break;
                case  '}' :
                    // 1 check that there is an entry in curls
                    try {
                        curlsopen = curls.pop();
                    } catch (Exception e)
                    {
                        //System.out.printf("pop failed on aChar = %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    // 2 check that there is no entry in squares or parens > than the entry in curls
                    try {
                        squaresopen = squares.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    try {
                        parensopen = parens.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    if (squaresopen > curlsopen || parensopen > curlsopen) {
                        //System.out.printf("compare failed on %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    break;
                case  '[' :
                    //System.out.printf("pushing %c%n", aChar);
                    squares.push(i);
                    break;
                case ']' :
                    // 1 check that there is an entry in curls
                    try {
                        squaresopen = squares.pop();
                    } catch (Exception e)
                    {
                        //System.out.printf("pop ] failed on aChar = %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    // 2 check that there is no entry in squares or parens > than the entry in curls
                    try {
                        curlsopen = curls.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    try {
                        parensopen = parens.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    if (curlsopen > squaresopen || parensopen > squaresopen) {
                        //System.out.printf("compare failed on %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    break;
                case  '(' :
                    parens.push(i);
                    break;
                case ')' :
                // 1 check that there is an entry in curls
                    try {
                        parensopen = parens.pop();
                    } catch (Exception e)
                    {
                        //System.out.printf("pop failed on aChar = %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    // 2 check that there is no entry in squares or parens > than the entry in curls
                    try {
                        curlsopen = curls.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    try {
                        squaresopen = squares.peek();
                    } catch (Exception e)
                    {
                        //fine
                    }
                    if (curlsopen > parensopen || squaresopen > parensopen) {
                        //System.out.printf("compare failed on %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    break;
                default:
                    //System.out.println("failed on aChar = " + aChar);
                    b = false;
                    break outer;
            }
        }

        if (parens.size() > 0 || squares.size() > 0 || curls.size() > 0) {
            //System.out.printf("unclosed: %d %d %d%n", parens.size(), squares.size(), curls.size());
            b = false;
        }


        long elapsed = new Date().getTime() - start;
        //System.out.printf("got %s, result %b, took %sms %n", s, b, elapsed);
        return b;
    }

    public static boolean isValid2(String s) {
        long start = new Date().getTime();

        //method 2
        boolean b = true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        char aChar;
        char possmatch;
        //System.out.println("checking s = " + s);
        outer:
        for (int i = 0; i<chars.length; i++)
        {
            aChar = chars[i];
 
            switch (aChar)
            {
                case  '{' :
                case  '[' :
                case  '(' :
                    stack.push(aChar);
                    break;
                case  '}' :
                case  ')' :
                case  ']' :
                    try {
                        possmatch = stack.pop();
                    } catch (Exception e)
                    {
                        //System.out.printf("pop failed on aChar = %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    // 2 check that there is no entry in squares or parens > than the entry in curls
                    if (    (aChar == '}' && possmatch != '{') ||
                            (aChar == ')' && possmatch != '(') ||
                            (aChar == ']' && possmatch != '['))
                    {
                        //System.out.printf("compare failed on %c%n", aChar);
                        b = false;
                        break outer;
                    }
                    break;
                default:
                    //System.out.println("failed on aChar = " + aChar);
                    b = false;
                    break outer;
            }
        }

        if (stack.size() > 0) {
            //System.out.printf("unclosed: %d%n", stack.size());
            b = false;
        }


        long elapsed = new Date().getTime() - start;
        //System.out.printf("got %s, result %b, took %sms %n", s, b, elapsed);
        return b;
    }
}
