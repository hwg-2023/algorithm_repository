public class Queue {
    public static void main(String[] args) {
        //一个简单的用一维数组模拟队列的程序
        QueueCopy queueCopy = new QueueCopy(5);
        queueCopy.addQueue(5);
        queueCopy.addQueue(4);
        queueCopy.addQueue(8);
        System.out.println(queueCopy.popQueue());

        System.out.println(queueCopy.popQueue());
        queueCopy.once();

    }
}
//写一个类用来模仿
class QueueCopy{
    private int maxSize;
    //确定最大容量，自己设定，医院啥的能承受多少之类的
    private int arr [];
    //模拟用数组
    private int front = -1;
    //头部下标，这边直接进行赋值
    private int rear = -1;
    //尾部下标，这边也直接进行赋值

    public QueueCopy() {
    }

    //还是要提供一个无参的构造方法的

    public QueueCopy(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    //提供了最大容量的构造方法
    public Boolean isFull(){
        return rear == maxSize -1;
    }
    //判断队列有没有满
    public Boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否为空
    public void addQueue(int Element){
        if (isFull()){
            //队列没有满，就可以添加元素
            System.out.println("队列已满，无法添加元素");
            return;
        }
        rear++;
        //rear 进行后移
        arr[rear] = Element;
    }
    //添加队列元素
    public int popQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无元素抛出");
        }
        front++;
        return arr[front];
    }
    //抛出队列头元素
    public void once(){
        for (int a = front ; a<arr.length;a++){
            System.out.println("  "+arr[a]);
        }
    }
    //遍历数组用的
}
