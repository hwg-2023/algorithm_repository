package 基础学习.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        HeroNode1 heNode1 = new HeroNode1(1, "宋江1", "及时雨1");
        HeroNode1 heNode2 = new HeroNode1(2, "宋江2", "及时雨2");
        HeroNode1 heNode3 = new HeroNode1(3, "宋江3", "及时雨3");
        HeroNode1 heNode4 = new HeroNode1(4, "宋江4", "及时雨4");
        HeroNode1 heNode5 = new HeroNode1(5, "宋江5", "及时雨5");
        //测试自己写的
        doubleLinkList.addNodewithRank(heNode2);
        doubleLinkList.addNodewithRank(heNode1);
        doubleLinkList.addNodewithRank(heNode5);
        doubleLinkList.addNodewithRank(heNode4);
        doubleLinkList.addNodewithRank(heNode3);
        //测试韩顺平的
//        sigleLinkList.addByHsp(heroNode4);
//        sigleLinkList.addByHsp(heroNode1);
//        sigleLinkList.addByHsp(heroNode3);
//        sigleLinkList.addByHsp(heroNode5);
//        sigleLinkList.addByHsp(heroNode2);
        System.out.println("修改前：");
        doubleLinkList.showList();
        HeroNode1 modNode = new HeroNode1(2, "xxx", "yyy");
        doubleLinkList.modifyByRank(modNode);
        System.out.println("修改后：");
        doubleLinkList.showList();
        doubleLinkList.delNode(1);
        doubleLinkList.delNode(5);
        System.out.println("删除后：");
        doubleLinkList.showList();
    }
}

class DoubleLinkList{
    //我本来加了static和final  觉得不太妥删了
    private HeroNode1 headNode = new HeroNode1(0,"","");
    public int length;

    DoubleLinkList(){
        headNode.next = headNode;
        headNode.pre = headNode;
        length = 0;
    }
    //编写从最后一个节点后添加节点的方法
    public void addNode(HeroNode1 heroNode){
        //首先准备一个临时变量
        HeroNode1 temp = headNode;
        //遍历到最后一个节点的位置
        //循环跳出条件：temp的next指针头结点
        while (temp.next != headNode){
            temp = temp.next;
        }
        //将新节点加入
        heroNode.pre = temp;
        heroNode.next = headNode;
        temp.next = heroNode;
        length ++;
    }
    //这里即使排名相等也能将Node插入，如需不能插入的，可以设置flag变量辅助标识
    public void addNodewithRank(HeroNode1 heroNode){
        HeroNode1 temp = headNode;
        //第1种情况：该单链表还没有节点存在，只有头节点
        if (headNode.next == headNode){
            temp.next = heroNode;
            temp.pre = heroNode;
            heroNode.next = headNode;
            heroNode.pre = headNode;
            length ++;
            return;
        }
        while (true){
            //即新加进来的节点都大于已经存在的单链表中的节点，所以temp走到了最后一个节点位置
            if (temp.next == headNode){
                heroNode.pre = temp;
                heroNode.next = headNode;
                temp.next = heroNode;
                length ++;
                return; //原本写的break 后来想着加完一个Node就已经完成任务了，直接return掉
            }//原来写的判断条件temp.next.ranking >= heroNode.ranking && temp.ranking <= heroNode.ranking
            //其实没必要判断后面那个temp.ranking <= heroNode.ranking，
            else if (temp.next.ranking >= heroNode.ranking){
                heroNode.pre = temp;
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
                length ++;
                return;
            }
            temp = temp.next;
        }
    }
    //按顺序添加：老韩的方法
    public void addByHsp(HeroNode1 heroNode){
        HeroNode1 temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.ranking > heroNode.ranking){
                break;
            }else if (temp.next.ranking == heroNode.ranking){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true){
            System.out.println("该英雄已在排行榜，请勿重复添加！");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点：根据编号来修改
    public void modifyByRank(HeroNode1 modheroNode){
        if (headNode.next == headNode){
            System.out.println("链表为空~");
        }
        HeroNode1 temp = headNode.next;
        while (true){
            if (temp.ranking == modheroNode.ranking){
                temp.name = modheroNode.name;
                temp.nikename = modheroNode.nikename;
                return;
            }
            if (temp == headNode){
                //找不到对应要修改的节点
                System.out.println("找不到对应要修改的节点");
                return;
            }
            temp = temp.next;
        }
    }
    //删除指定节点
    public void delNode(int rank){
        if (headNode.next == headNode){
            System.out.println("链表为空~");
            return;
        }
        HeroNode1 temp = headNode.next;
        while (true){
            if (temp == headNode){
                System.out.println("该节点不存在~");
                return;
            }
            //这个条件很关键：单链表这里的判断条件是temp.next.ranking == rank！！！
            if (temp.ranking == rank){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                length --;
                return;
            }
            temp = temp.next;
        }
    }

    //编写遍历节点方法
    public void showList(){
        HeroNode1 temp = headNode.next;
        //当temp还有值，即可输出
        while (temp != headNode){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode1{
    public int ranking;    //排行
    public String name;    //姓名
    public String nikename;//绰号
    public HeroNode1 pre = null;
    public HeroNode1 next = null;  //指向下一个节点

    HeroNode1(int ranking, String name, String nikename){
        this.ranking = ranking;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}
