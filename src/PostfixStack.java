public class PostfixStack {
    private int[] stack;
    private int top;
    public PostfixStack (int size) {
        stack = new int[size];
        top = -1;
    }
    public void push(int value) {
        stack[++top] = value;
    }
    public int pop() {
        return stack[top--];
    }
     public int peek() {
        return stack[top];
    }
     public void displayStack() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
     public int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = pop();
                int a = pop();
                push(a + b);
            } else if (token.equals("-")) {
                int b = pop();
                int a = pop();
                push(a - b);
            } else if (token.equals("*")) {
                int b = pop();
                int a = pop();
                push(a * b);
            } else if (token.equals("/")) {
                int b = pop();
                int a = pop();
                push(a / b);
            } else {
                push(Integer.parseInt(token));
            }
            displayStack();
        }
        return peek();
    }
     public static void main(String[] args) {
        PostfixStack stack = new PostfixStack(20);
        String expression = "5 3 + 2 *";
        System.out.println("Postfix Expression: " + expression);
        int result = stack.evaluatePostfix(expression);
        System.out.println("Final Result: " + result);
    }
}