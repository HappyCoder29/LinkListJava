package edu.northeastern.ashish;

public class LinkList <T> {

    public Node head;

    public LinkList(){
        head = null;
    }

    // Adds Data to head of link list
    public void addToHead(T data)
    {
        Node add = new Node(data);
        add.Next = head;
        head = add;
    }

    // Adds data to tail of link list
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

    // Prints the link list assuming no cycles
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

    // Count of nodes in link list
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

    // Reverses a link list from start to end
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

    // get the nth node from end, returns null if there are less than n nodes
    public Node nthFromEnd(int n)
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

    // Checks if the list has cycle.
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

    // Finds the starting point of a cycle in the list. Returns null if there is no cycle
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


    // returns merges nodes of 2 sorted link list
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

    // reverses list from the node provided.
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

    // breaks list in half
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

    // breaks list in half from the node specified
    // assumes no cycle
    public Node breakListInHalf(Node node)
    {

        if (node == null || node.Next == null)
            return null;

        Node front = node;
        Node back = node;

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

    // Checks if list is palindrome
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

    // Merges list in Zip manner
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
