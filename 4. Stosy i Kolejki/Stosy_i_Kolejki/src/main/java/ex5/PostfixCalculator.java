package ex5;

import ex2.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostfixCalculator {
    public static void processFile(String path) {
        ArrayList<String> expressions = readExpressionFromFile(path);
        if (expressions == null) return;
        expressions.forEach(line -> {
            System.out.println("Result: " + evaluatePostfixExpression(line));
        });
    }

    public static ArrayList<String> readExpressionFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext())
                lines.add(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found!");
            return null;
        }
        return lines;
    }

    public static int evaluatePostfixExpression(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (token.matches("\\d+"))
                stack.push(Integer.parseInt(token));
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluateOperation(operand1, operand2, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int evaluateOperation(int operand1, int operand2, String operator) {
        if (operator.equals("+"))
            return operand1 + operand2;
        else if (operator.equals("*"))
            return operand1 * operand2;
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

}
