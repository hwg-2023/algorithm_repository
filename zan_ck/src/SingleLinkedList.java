public class SingleLinkedList {
    public static void main(String[] args) {
        //单项链表的模拟
        SingleLinkedFunction singleLinkedFunction = new SingleLinkedFunction();
        //添加一个节点
        singleLinkedFunction.add(new SingleLinkedNode(1,"第二个元素"));

        singleLinkedFunction.ergodic();
    }
}


class SingleLinkedFunction {
    //初始化头节点
    private SingleLinkedNode HeadNode = new SingleLinkedNode(0,"我来组成头部");
    //添加节点,找到尾部节点
    public void add(SingleLinkedNode singleLinkedNode){
        SingleLinkedNode temp = HeadNode;
        while (true){
            if (temp.next == null){
                //这里一定要是 temp.next ，因为是本节点没有指向下一个节点的内存地址，才能得出该节点为最后一个节点
                break;
            }
            temp = temp.next;
        }
        temp.next = singleLinkedNode;
    }
    //遍历那个链表
    public void ergodic(){
        SingleLinkedNode temp = HeadNode;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class SingleLinkedNode {
    //链表中的节点有两个重要属性，一个data数据，一个link 指向下一个节点的链接
    public int no;
    //就当作普通数据吧
    public String name;
    //也是数据的一员，节点的名字
    public SingleLinkedNode next;
    //指向下一个节点内存地址的链接

    //构造方法


    public SingleLinkedNode() {
    }

    public SingleLinkedNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //重写toString方法，这样看起来更清楚

    @Override
    public String toString() {
        return "SingleLinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
