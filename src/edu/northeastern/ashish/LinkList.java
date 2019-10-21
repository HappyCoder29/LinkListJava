package edu.northeastern.ashish;

public class LinkList <T> {

    public Node head;

    public LinkList(){
        head = null;
    }

    public void addToHead(T data)
    {
        Node add = new Node(data);
        add.Next = head;
        head = add;
    }
    public void addToTail(T data)
    {
        Node add = new Node(data);

        if (head == null)
        {
            head = add;
            return;
        }

        Node temp = head;
        while (temp.Next != null)
            temp = temp.Next;

        temp.Next = add;
    }

    public void printList(){
        if(head == null)
            return;

        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.Next;
        }
        System.out.println("NULL");

    }

    public int count()
    {

        if (head == null)
            return 0;

        Node temp = head;
        int count = 1;
        while (temp.Next != null)
        {
            count++;
            temp = temp.Next;
        }
        return count;

    }

    public void reverse()
    {
        if (head == null || head.Next == null)
            return;

        Node back = null;
        Node mid = head;
        Node front = head.Next;

        while (front != null)
        {
            mid.Next = back;
            back = mid;
            mid = front;
            front = front.Next;
        }

        mid.Next = back;
        head = mid;
    }

    public Node NthFromEnd(int n)
    {
        if (head == null || n <= 0)
            return null;

        Node front = head;
        Node back = head;

        for (int i = 0; i < n; i++)
        {
            if (front == null)
                return null;
            front = front.Next;
        }

        while (front != null)
        {
            front = front.Next;
            back = back.Next;
        }

        return back;
    }

    public boolean isCyclic()
    {
        if (head == null || head.Next == null)
            return false;
        Node slow = head;
        Node fast = head;

        while (fast != null)
        {
            fast = fast.Next;
            if (fast == null)
                return false;

            fast = fast.Next;
            slow = slow.Next;

            if (fast == slow)
                return true;
        }

        return false;

    }

    public Node findStartCycle()
    {
        if (head == null || head.Next == null)
            return null;
        Node slow = head;
        Node fast = head;

        while (fast != null)
        {
            fast = fast.Next;
            if (fast == null)
                return null;

            fast = fast.Next;
            slow = slow.Next;

            if (fast == slow)
                break;
        }

        slow = head;

        while (fast != slow)
        {
            fast = fast.Next;
            slow = slow.Next;
        }

        return fast;
    }


    public Node sortedMerge(Node node1, Node node2)
    {
        Node result = null;
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (node1.compareTo(node2) < 0)
        {
            result = node1;
            result.Next = sortedMerge(node1.Next, node2);
        }
        else
        {
            result = node2;
            result.Next = sortedMerge(node1, node2.Next);
        }
        return result;
    }

    public Node reverse(Node node)
    {
        if (node == null || node.Next == null)
            return null;

        Node back = null;
        Node mid = node;
        Node front = node.Next;

        while (front != null)
        {
            mid.Next = back;
            back = mid;
            mid = front;
            front = front.Next;
        }

        mid.Next = back;
        node = mid;

        return node;
    }

    public Node breakListInHalf()
    {

        if (head == null || head.Next == null)
            return null;

        Node front = head;
        Node back = head;

        while (front.Next != null)
        {
            front = front.Next;
            if (front.Next != null)
            {
                front = front.Next;
                back = back.Next;
            }
        }

        Node temp = back.Next;
        back.Next = null;
        return temp;
    }

    public boolean isPalindrome()
    {
        if (head == null || head.Next == null)
            return true;

        Node secondHalf = breakListInHalf();

        secondHalf = reverse(secondHalf);

        Node firstHalf = head;

        while (firstHalf != null || secondHalf != null)
        {
            if (firstHalf.data != secondHalf.data)
                return false;
            firstHalf = firstHalf.Next;
            secondHalf = secondHalf.Next;
        }
        return true;
    }

    /* Function to reverse the linked list */
    private void printReverse(Node node)
    {
        // Base case
        if (node == null)
            return;

        // print the list after head node
        printReverse(node.Next);

        System.out.print(node.data + " ");
    }

    public void ZipMerge()
    {

        Node secondHalf = breakListInHalf();
        Node firstHalf = head;

        secondHalf = reverse(secondHalf);

        head = zipMerge(firstHalf, secondHalf, true);
    }

    public Node zipMerge(Node node1, Node node2, boolean bSwitch)
    {
        Node result = null;
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (bSwitch)
        {
            result = node1;
            result.Next = zipMerge(node1.Next, node2, false);
        }
        else
        {
            result = node2;
            result.Next = zipMerge(node1, node2.Next, true);
        }
        return result;
    }


}
