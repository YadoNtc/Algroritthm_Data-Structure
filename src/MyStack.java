/**
 * Class Stack (Ngăn xếp)
 */
public class MyStack {
    Node head;

    /**
     * Contructor
     */
    public void myStack() {
        head = null;
    }

    /**
     * Thêm Sảm phẩm váo Stack
     * @param item: nhận 1 đối tượng
     */
    public void  pushStackHead(Product item) {
        Node current = head;
        head = new Node();
        head.info = item;
        head.nextNode = current;
    }

    /**
     * Hiển thị thông tín Stack
     * @return Chuỗi
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
