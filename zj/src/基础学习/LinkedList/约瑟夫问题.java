package 基础学习.LinkedList;


public class 约瑟夫问题 {
    public static void main(String[] args) {
        SolvedProblem solvedProblem = new SolvedProblem();
        solvedProblem.createListByNum(10);
        solvedProblem.showList();
        solvedProblem.CountBoy(1,2,10);
    }
}

class SolvedProblem{
    int length;
    Boy first;

    public SolvedProblem() {
        this.length = 0;
        this.first = new Boy(-1);
    }

    public void addNode(Boy boy){
        Boy temp = first;
        if (length == 0){
            first = boy;  //这里我刚开始写的是first.next = child 直接栈溢出
            boy.setNext(boy);
            length ++;
            return;
        }
        //让temp指向最后一个
        while (temp.getNext() != first){
            temp = temp.getNext();
        }
        temp.setNext(boy);
        boy.setNext(first);
        length ++;
    }

    //韩顺平写法：采用for循环 方法接收num后，生成num个child
    public void createListByNum(int num){
        if (num < 1){
            System.out.println("num值不正确");
            return;
        }
        Boy temp = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                boy.setNext(boy);
                temp = boy;   //temp指向第一个小孩的位置
            }else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
        length = num;
    }


    public void showList(){
        Boy temp = first;
        int cnt = length;
        while (cnt != 0){
            System.out.println(temp.getId());
            temp = temp.getNext();
            cnt --;
        }
    }

    /**
     * 约瑟夫问题
     * @param starNo
     * @param countNum
     * @param nums
     */
    public void CountBoy(int starNo, int countNum, int nums) {
        //首先对数据进行校验
        if (first == null || starNo < 1 || starNo > nums) {
            return;
        }
        //定义一个临时变量
        Boy temp = first;
        //使临时变量应事先指向链表的最后一个
        while (true) {
            if (temp.getNext() == first) {
                //temp的下一个指针为first 说明temp已经指向最后一个小孩节点
                break;
            }
            temp = temp.getNext();
        }
        //先让first和temp遍历到starNo位置 starNo-1次
        for (int i = 0; i < starNo - 1; i++) {
            temp = temp.getNext();
            first = first.getNext();
        }
        while (true){
            if (temp == first){//说明圈中只有一个节点
                break;
            }
            //开始报数 实际报数也是countNum - 1次
            for (int i = 0; i < countNum - 1; i++) {
                temp = temp.getNext();
                first = first.getNext();
            }
            //报完后first指向的就是要出列的学生了 让该学生出列
            System.out.println("小孩" + first.getId() + "出圈");
            first = first.getNext();
            temp.setNext(first);
        }
        //结束循环后就只剩一个小孩了
        System.out.println("最后留在圈中的小孩编号为：" + first.getId());

    }
}

class Boy{
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public Boy() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "child{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}
