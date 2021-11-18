/**
 * Class tạo Node của các danh sách chứa thông tin, thuộc tính và Contructor
 */
public class Node  {
    Node nextNode;
    Product info;

    /**
     * Contructor
     * @param product Nhận một đối tượng sản phẩm
     * @param node Nhận một Node của danh sách
     */
    public Node (Product product, Node node) {
        info =  product;
        nextNode = node;
    }

    /**
     * Contructor
     * @param item Nhận đối tượng
     */
    public Node(Product item) {
        this(item, null);
    }

    public Node() {}

    /**
     * Hiển thị thông tin sản phẩm
     * @return trả về một chuỗi
     */
    @Override
    public String toString() {
        return info.id + "\t\t|\t\t" + info.name + "\t\t|\t\t" + info.quantity + "\t\t|\t" + info.price;
    }
}
