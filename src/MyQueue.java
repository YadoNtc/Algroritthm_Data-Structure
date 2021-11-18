/**
 * Class danh sách Queue(Hàng đợi)
 */
public class MyQueue {
    Node head, tail;
    int size; // Number of item

    public void myQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Thêm mọt node vào Queue
     * @param item Nhận một đối tượng
     */
    public void enQueue(Product item) {
        Node current = tail;
        tail = new Node();
        tail.info = item;
        tail.nextNode = null;
        if (isEmpty()) {
            head = tail;
        } else {
            current.nextNode = tail;
        }
        size++;
//        System.out.println(item + " Add to the queue");
    }

    /**
     *  Hiển thị danh sách Queue
     * @return Trả về một chuỗi
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("ID\t\t\t\t\t|\t\t\t\t").append("Name\t\t\t\t|\t").append("Quanlity\t|\t").append("Price").append("\n");

        Node current = head;
        while (current != null) {
            result.append(current.toString()).append(" ").append("\n");
            current = current.nextNode;
        }
        return result.toString();


    }

}
