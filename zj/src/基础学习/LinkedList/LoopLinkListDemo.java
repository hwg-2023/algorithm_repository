package 基础学习.LinkedList;

/**
 * 环形单链表的简单实现、添加和遍历
 */

public class LoopLinkListDemo {
    public static void main(String[] args) {
        LoopLinkList loopLinkList = new LoopLinkList();
//        Child child1 = new Child(1);
//        Child child2 = new Child(2);
//        Child child3 = new Child(3);
//        Child child4 = new Child(4);
//        Child child5 = new Child(5);
//        loopLinkList.addNode(child1);
//        loopLinkList.addNode(child2);
//        loopLinkList.addNode(child3);
//        loopLinkList.addNode(child4);
//        loopLinkList.addNode(child5);
        loopLinkList.createListByNum(10);
        loopLinkList.showList();
    }
}

class LoopLinkList{
    int length;     //发现如果不给他个值会报空指针异常
    Child first = new Child(-1);    //相当于指针，指向第一个节点

    public LoopLinkList() {
        this.length = 0; //因为此时这个循环链表没有任何一个元素
    }

    public void addNode(Child child){
        Child temp = first;
        if (length == 0){
            first = child;  //这里我刚开始写的是first.next = child 直接栈溢出
            child.next = child;
            length ++;
            return;
        }
        //让temp指向最后一个
        while (temp.next != first){
         temp = temp.next;
        }
        temp.next = child;
        child.next = first;
//        temp = child;
        length ++;
    }

    public void showList(){
        Child temp = first;
        int cnt = length;
        while (cnt != 0){
            System.out.println(temp.id);
            temp = temp.next;
            cnt --;
        }
    }

    //韩顺平写法：采用for循环 方法接收num后，生成num个child
    public void createListByNum(int num){
        if (num < 1){
            System.out.println("num值不正确");
            return;
        }
        Child temp = null;
        for (int i = 1; i <= num; i++) {
            Child child = new Child(i);
            if (i == 1){
                first = child;
                child.next = child;
                temp = child;   //temp指向第一个小孩的位置
            }else {
                temp.next = child;
                child.next = first;
                temp = child;
            }
        }
        length = num;
    }

}

class Child{
    int id;
    Child next;

    public Child(int id) {
        this.id = id;
    }

    public Child() {}

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "child{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}
