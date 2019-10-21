package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<Integer>();
        list.addToHead(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);

        Node<Integer> thirdFromLast = list.nthFromEnd(3);
//        list.reverse();
//        list.printList();
//        System.out.println("Count = " + list.count());

//        CreateCycle(list);
//
        boolean isCyclic = list.isCyclic();
        System.out.println(isCyclic);


    }

    private static  void CreateCycle(LinkList<Integer> list){

        Node<Integer> lastNode = list.getLastNode();
        lastNode.Next = list.head;
        return;

    }
}
