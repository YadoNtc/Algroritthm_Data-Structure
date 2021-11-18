/**
 * Class LinkedList
 */
public class MyList {
    Node head;
    Node tail;

    /**
     * Thêm Node vào cuối list
     *
     * @param item: Nhận một đối tượng
     */
    public void insertAtTail(Product item) {
        Node newNode = new Node(item);

        if (this.head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    // Hoán đổi vị trí hai node
    public void swap(Node left, Node right) {
        Product temp;
        temp = left.info;
        left.info = right.info;
        right.info = temp;
    }

    /**
     * Sort by ID sử dụng đệ quy
     */
    public void sortById(MyList myList, Node current) {

        if (current.nextNode == null) {
            return;
        }
        Node nextNode = current.nextNode;
        while (nextNode != null) {
            if (nextNode.info.id.compareToIgnoreCase(current.info.id) < 0) {
                myList.swap(nextNode, current);
            }
            nextNode = nextNode.nextNode;
        }
        // Đệ quy gọi lại chính nó trong hàm
        sortById(myList, current.nextNode);
    }

    /**
     * Hiển thị thông tin LinkedList
      */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID\t\t\t|\t\t").append("Name\t\t|\t").append("Quanlity\t|\t").append("Price").append("\n");
        Node current = this.head;

        while (current != null) {
            result.append(current.toString()).append(" ").append("\n");
            current = current.nextNode;
        }
        return result.toString();
    }
}
