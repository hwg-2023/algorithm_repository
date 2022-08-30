package 基础学习.queue;

import java.util.Scanner;

/**
 * 这种队列有个缺点：只能使用一次 没有达到复用的效果
 * 所以采用环形队列解决
 */
public class testQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
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

class Queue{

    private int maxSize;
    private int front;
    private int rear;
    private int[] Arr;
    private int length;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.Arr = new int[maxSize];
        front = -1; //指向队列的头部，分析出front指向队列头的前一个位置
        rear = -1;  //指向队列的尾部，分析出指向队列尾的数据（即就是队列最后一个数据）
        this.length = 0;
    }

    //判断队列是否满
    public boolean Isfull(){
        return rear == maxSize - 1;
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
        rear ++;
        Arr[rear] = data;
        length ++;
    }

    //出队列
    public int getQueue(){
        //判断队列是否为空
        if (Isempty()){
//            System.out.println("队列为空，出队列失败！");
//            return;
        throw new RuntimeException("队列为空，出队列失败！");
        }
        front ++;
        length --;
        return Arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        if (Isempty()){
            System.out.println("队列为空，无法遍历！");
            return;
        }
        System.out.println("后续遍历出错，等有时间找到核实解决办法");
//        //韩顺平这个遍历错了 他输出了整个数组 应该只有front到rear是有数据的
//        for (int i = 0; i < length; i++) {
//            System.out.printf("Arr[%d] = %d\n", i, Arr[i]);
//        }
    }

    //显示队列的头数据，注意不是去算出啥护具
    public int headQueue(){
        if (Isempty()){
            throw new RuntimeException("队列为空，出队列失败！");
        }
        return Arr[front + 1];  //因为front指向头数据的前一个位置
    }

}
