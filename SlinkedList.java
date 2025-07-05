public class SlinkedList {


    public Node head = null;
    public Node tail = null;

    public static void main(String[] args) {
        SlinkedList list = new SlinkedList();
        list.display();
        list.addNode(10);
        list.addNode(20);
        list.addNode(50);
        list.display();
        list.insertAfter(30, 99);
        list.display();
    }

    ;

    public void addNode(int newData) {

        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;

        }
        tail = newNode
        ;
    }


    public void insertAfter(int target, int data) {


        Node newNode = new Node(data);
        Node temp = head;
//        case 1 : list is empty
        if (head == null) {
            System.out.print("List is empty, cannot insert");
            return;
        }
//        case 2 : match is not found

        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Target not found");
            return;
        }


        newNode.next = temp.next;
        temp.next = newNode;

//        case 3 : match is found
        if (temp == tail) {
            tail = newNode;
        }

    }

    public void delete(int deleteData) {
        Node temp = head, prev = null;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        // Case: only one node and it's the target
        if (temp.next == null && temp.data == deleteData) {
            head = null;
            tail = null;
            System.out.println("List is cleared");
            return;
        }

        // Case: target is the head node
        if (temp.data == deleteData) {
            head = head.next;
            return;
        }

        // Search for the node to delete
        while (temp != null && temp.data != deleteData) {
            prev = temp;
            temp = temp.next;
        }

        // If not found
        if (temp == null) {
            System.out.println("Node with value " + deleteData + " not found.");
            return;
        }

        // Normal deletion
        prev.next = temp.next;

        // Update tail if last node is deleted
        if (temp == tail) {
            tail = prev;
        }
    }

    public void display() {
        if (head == null) System.out.println("List is empty");

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

        }

    }

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;

        }
    }
}