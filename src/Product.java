/**
 * Class chứa thông tin, thuộc tính sản phẩm
 */
public class Product  {
    public String name;
    public String id;
    public double price;
    public int quantity;


    /**
     * Contrutor
     * @param id nhận 1 String
     * @param name nhận 1 String
     * @param price Nhận 1 số nguyên
     * @param quantity nhận một số nguyên
     */
    public Product(String id, String name, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Hiển thị thông tin sản phẩm
     * @return Trả vê một chuỗi gồm nhug thông tin của sản phẩm
     */
    @Override
    public String toString() {
        return id + "\t|\t" + name + "\t|\t" + quantity + "\t|\t" + price;

    }

}
