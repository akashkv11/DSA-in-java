public class DLinkedList {
    public Node head = null;
    public Node tail = null;

    public static void main(String[] args) {
        DLinkedList Dlist = new DLinkedList();
        Dlist.display();
        Dlist.insert(1);
        Dlist.insert(2);
        Dlist.insert(3);
        Dlist.insert(4);
        Dlist.display();
        Dlist.delete(3);
        Dlist.displayReverse();

    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

//    TODO : implement insertAfter method and insertBefore method

    public void delete(int data) {
        Node temp = head;

        // Case 1: Empty list
        if (head == null) {
            System.out.println("List is empty, Cannot delete");
            return;
        }

        // Traverse to the node to be deleted
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        // Case 2: Not found
        if (temp == null) {
            System.out.println("Node with value " + data + " not found.");
            return;
        }

        // Case 3: Only one node
        if (temp == head && temp == tail) {
            head = tail = null;
            System.out.println("List is cleared");
            return;
        }

        // Case 4: Deleting head
        if (temp == head) {
            head = head.next;
            head.prev = null;
            return;
        }

        // Case 5: Deleting tail
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Case 6: Deleting in the middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

}