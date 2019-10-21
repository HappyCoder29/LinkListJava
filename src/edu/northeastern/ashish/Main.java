package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<Integer>();
        list.addToHead(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.printList();


    }
}
