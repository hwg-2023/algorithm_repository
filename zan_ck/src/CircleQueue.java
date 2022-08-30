public class CircleQueue {
    //一个环形队列的模拟程序
    //构造一个环形队列
    public static void main(String[] args) {
        CircleQueueCopy circleQueueCopy = new CircleQueueCopy(5);
        circleQueueCopy.addQueue(5);
        circleQueueCopy.addQueue(6);
        circleQueueCopy.addQueue(7);
        circleQueueCopy.addQueue(8);
        //circleQueueCopy.addQueue(8);
        //circleQueueCopy.addQueue(9);
        circleQueueCopy.subQueue();
        circleQueueCopy.circle();
        //这里设置为4，但容量实际为3，空出了一个位置来
    }
}
class CircleQueueCopy {
    //原始数组，最大容量，首尾指针下标
    private int [] circleQueue;
    private int maxSize;
    private int front = 0;
    private int rear = 0;

    //构造器

    public CircleQueueCopy() {
    }

    public CircleQueueCopy(int maxSize) {
        this.maxSize = maxSize;
        circleQueue = new int [maxSize];
    }
    //队列满判断
    public Boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //队列空判断
    public Boolean isEmpty(){
        return front == rear;
    }
    //添加元素
    public int addQueue(int n){
        //判断队列有没有满
        if (isFull()){
            throw new RuntimeException("队列已满，无法添加元素");
        }
        //添加元素,末尾添加，因为rear已经不是指向末尾元素下标了，所以
        circleQueue[rear] = n;
        return rear = (rear + 1) % maxSize;
    }
    //取出元素
    public int subQueue(){
        //判断元素是否为空
        if (isEmpty()){
            System.out.println("队列为空，无元素取出");
        }
        int val = circleQueue[front];
        front = (front+1) % maxSize;
        return val;
    }
    //遍历环形队列中的元素
    public void circle(){
        //使用for循环
        for(int a = front; a< (front+sum());a++){
            System.out.print("  "+circleQueue[a]);
        }
    }
    public int sum(){
        return (rear+maxSize-front) % maxSize;
    }
}
