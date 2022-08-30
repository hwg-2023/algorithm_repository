package 基础学习.LinkedList;

import java.net.HttpRetryException;

public class sigleLinkedListDemo {
    public static void main(String[] args) {
        sigleLinkList sigleLinkList = new sigleLinkList();
        HeroNode heroNode1 = new HeroNode(1, "宋江1", "及时雨1");
        HeroNode heroNode2 = new HeroNode(2, "宋江2", "及时雨2");
        HeroNode heroNode3 = new HeroNode(3, "宋江3", "及时雨3");
        HeroNode heroNode4 = new HeroNode(4, "宋江4", "及时雨4");
        HeroNode heroNode5 = new HeroNode(5, "宋江5", "及时雨5");
        //测试自己写的
        sigleLinkList.addNodewithRank(heroNode2);
        sigleLinkList.addNodewithRank(heroNode1);
        sigleLinkList.addNodewithRank(heroNode5);
        sigleLinkList.addNodewithRank(heroNode4);
        sigleLinkList.addNodewithRank(heroNode3);
        //测试韩顺平的
//        sigleLinkList.addByHsp(heroNode4);
//        sigleLinkList.addByHsp(heroNode1);
//        sigleLinkList.addByHsp(heroNode3);
//        sigleLinkList.addByHsp(heroNode5);
//        sigleLinkList.addByHsp(heroNode2);
        System.out.println("修改前：");
        sigleLinkList.showList();
        HeroNode modNode = new HeroNode(2, "xxx", "yyy");
        sigleLinkList.modifyByRank(modNode);
        System.out.println("修改后：");
        sigleLinkList.showList();
        sigleLinkList.delNode(1);
        sigleLinkList.delNode(5);
        System.out.println("删除后：");
        sigleLinkList.showList();
    }
}

class sigleLinkList{
    //我本来加了static和final  觉得不太妥删了
    private HeroNode headNode = new HeroNode(0,"","");
    public int length = 0;
    //编写添加节点方法
    public void addNode(HeroNode heroNode){
        //首先准备一个临时变量
        HeroNode temp = headNode;
        //遍历到最后一个节点的位置
        //循环跳出条件：temp的next指针为空，即temp指向最后一个节点的位置
        while (temp.next != null){
            temp = temp.next;
        }
        //将新节点加入
        temp.next = heroNode;
        length ++;
    }
    //这里即使排名相等也能将Node插入，如需不能插入的，可以设置flag变量辅助标识
    public void addNodewithRank(HeroNode heroNode){
        HeroNode temp = headNode;
        //第1种情况：该单链表还没有节点存在，只有头节点
        if (headNode.next == null){
            temp.next = heroNode;
            return;
        }
        while (true){
            //即新加进来的节点都大于已经存在的单链表中的节点，所以temp走到了最后一个节点位置
            if (temp.next == null){
                temp.next = heroNode;
                return; //原本写的break 后来想着加完一个Node就已经完成任务了，直接return掉
            }//原来写的判断条件temp.next.ranking >= heroNode.ranking && temp.ranking <= heroNode.ranking
            //其实没必要判断后面那个temp.ranking <= heroNode.ranking，
            else if (temp.next.ranking >= heroNode.ranking){
                heroNode.next = temp.next;
                temp.next = heroNode;
                return;
            }
            temp = temp.next;
        }
    }
    //按顺序添加：老韩的方法
    public void addByHsp(HeroNode heroNode){
        HeroNode temp = headNode;
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
    public void modifyByRank(HeroNode modheroNode){
        if (headNode.next == null){
            System.out.println("链表为空~");
        }
        HeroNode temp = headNode.next;
        while (true){
            if (temp.ranking == modheroNode.ranking){
                temp.name = modheroNode.name;
                temp.nikename = modheroNode.nikename;
                return;
            }
            if (temp == null){
                //找不到对应要修改的节点
                System.out.println("找不到对应要修改的节点");
                return;
            }
            temp = temp.next;
        }
    }
    //删除指定节点
    public void delNode(int rank){
        if (headNode.next ==null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = headNode;
        while (true){
            if (temp.next == null){
            System.out.println("该节点不存在~");
            return;
            }
            //这个条件很关键：我刚开始写temp.ranking == rank是错的！！！
            if (temp.next.ranking == rank){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    //编写遍历节点方法
    public void showList(){
        HeroNode temp = headNode.next;
        //当temp还有值，即可输出
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int ranking;    //排行
    public String name;    //姓名
    public String nikename;//绰号
    public HeroNode next;  //指向下一个节点

    HeroNode(int ranking, String name, String nikename){
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
