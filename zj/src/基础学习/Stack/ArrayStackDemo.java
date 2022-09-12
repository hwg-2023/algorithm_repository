package 基础学习.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(8);
        for (int i = 0; i < 9; i++) {
            arrayStack.push(i);
        }
        arrayStack.showStack();
        for (int i = 0; i < 6; i++) {
            int popNum = arrayStack.pop();
            System.out.println("元素" + popNum + "出栈");
        }
        arrayStack.showStack();

    }
}

class ArrayStack{
    private int MaxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        MaxSize = maxSize;
        stack = new int[this.MaxSize];
    }

    //栈满
    public boolean isStackFull(){
        return top == MaxSize - 1;
    }
    //栈空
    public boolean isStackEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if (isStackFull()){
            System.out.println("栈已满，元素无法入栈");
            return;
        }
        top ++;
        stack[top] = value;
        System.out.println(value + "入栈");
    }
    //出栈
    public int pop(){
        if (isStackEmpty()){
//            System.out.println("该栈为空栈，没有元素可进行出栈操作~");
//            return;
            throw new RuntimeException("栈空，没有数据~");
        }
//        System.out.println("元素" + stack[top] + "出栈");
        int value = stack[top];
        top --;
        return value;
    }
    //遍历栈
    public void showStack(){
        if (isStackEmpty()){
            System.out.println("该栈为空栈，无法遍历~");
            return;
        }
        for (int i = 0; i <= top ; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
