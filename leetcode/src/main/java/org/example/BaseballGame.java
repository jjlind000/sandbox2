package org.example;

import java.util.*;

//
public class BaseballGame {

    public static void main(String[] args)
    {

    }

    //https://leetcode.com/problems/baseball-game/submissions/904899984/
    public int calPoints(String[] operations) {
        Stack<Integer> resultStack = new Stack<>();
        resultStack.push(0);
        int size;
        for (String op : operations)
        {
            switch (op)
            {
                case "+" :
                    resultStack.push(resultStack.get(resultStack.size()-2) + resultStack.get(resultStack.size()-1));
                    break;
                case "D" :
                    resultStack.push(resultStack.peek()*2);
                    break;
                case "C" :
                    resultStack.pop();
                    break;
                default :
                    resultStack.push(Integer.parseInt(op));
                    break;
            }
            //System.out.printf("op: %s stack %s%n", op, resultStack);
        }

        //System.out.println(resultStack);
        int result = 0;
        for (int i : resultStack)
        {
            result+=i;
        }
        return result;
    }

}

