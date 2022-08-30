package 基础学习.queue;

import java.util.Scanner;

/**
 * 环形队列
 * 思路分析：初始值 front = rear = 0
 * 1.front变量的含义做一个调整：front就指向队列的第一个元素，也就是说Arr[front]就是队列的第一个元素
 * 2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
 * 3.当队列满时：条件是(rear + 1)% maxsize = front
 * 4.队列为空的条件：rear = front 空
 * 队列中有效的数据个数：(rear + maxsize -front)% maxsize
 */

public class loopQueuetest {
    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int q1 = queue.getQueue();
                    System.out.println("q1 = " + q1);
                    break;
                case 'h':
                    int i = queue.headQueue();
                    System.out.println("head = " + i);
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}
class LoopQueue{

    private int maxSize;
    private int front;
    private int rear;
    private int[] Arr;
    // 1.front变量的含义做一个调整：front就指向队列的第一个元素，也就是说Arr[front]就是队列的第一个元素
    // 2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
    public LoopQueue(int maxSize){
        this.maxSize = maxSize;
        this.Arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean Isfull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean Isempty(){
        return front == rear;
    }

    //将数据加入队列
    public void addQueue(int data){
        //判断队列是否满
        if (Isfull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        Arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getQueue(){
        //判断队列是否为空
        if (Isempty()){
            throw new RuntimeException("队列为空，出队列失败！");
        }
        int data = Arr[front];
        front = (front + 1) % maxSize;
        return data;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (Isempty()){
            System.out.println("队列为空，无法遍历！");
            return;
        }
        for (int i = front; i < front + getvals(); i++) {
            System.out.printf("Arr[%d] = %d\n", i % maxSize, Arr[i % maxSize]);
        }
    }

    public int getvals(){
        return (rear + maxSize -front) % maxSize;
    }

    //显示队列的头数据，注意不是去算出啥护具
    public int headQueue(){
        if (Isempty()){
            throw new RuntimeException("队列为空，出队列失败！");
        }
        return Arr[front];  //因为front指向头数据的前一个位置
    }

}

