import java.io.*;
import java.util.Scanner;

/**
 * Chứa các phương thức biểu diễn các yêu cầu chức năng
 * Các phương thức được gọi ở Hàm Main
 */
public class OperationToProduct {

    private static final String FILE_NAME = "D:\\asignment2\\data.txt";
    private static final String OUT_PUT = "D:\\asignment2\\console_output.txt";

    /**
     * 1. Danh sách sản phẩm có sẵn trong File
     *
     * @throws IOException: Ngăn lỗi
     */
    public static void dataFile(MyList myList) throws IOException {
        Product product = new Product("SP01", "Milk", 10, 5);
        Product product1 = new Product("SP02", "Orange", 5, 50);
        Product product2 = new Product("SP03", "Apple", 20, 20);
        Product product3 = new Product("SP04", "Coffee", 30, 15);

        // Lưa các sản phẩm vào LinkedList
        myList.insertAtTail(product);
        myList.insertAtTail(product1);
        myList.insertAtTail(product2);
        myList.insertAtTail(product3);

        // Lưu vào file
        writeFile(FILE_NAME, myList);
        System.out.println("Danh sách sản phẩm");
        System.out.println(myList);
    }

    /**
     * 2. Thêm sản phẩm vào cuối LinkedList
     */
    public static void inputProduct(MyList myList) {
        Scanner sc = new Scanner(System.in);
        Scanner nb = new Scanner(System.in);
        int select;
        do {
            System.out.print("ID: ");
            String id = sc.next();

            System.out.print("Tên: ");
            String name = sc.next();

            System.out.print("Số lượng: ");
            int quality = Integer.parseInt(nb.nextLine());

            System.out.print("Giá tiền: ");
            double price = nb.nextDouble();
            nb.nextLine();

            // Lấy dữ liệu nhập, và sản phẩm lưu vào LinkedList
            Product product = new Product(id, name, quality, price);
            myList.insertAtTail(product);
            System.out.println("Thêm sản phẩm thành công");

            System.out.println("Tiếp tục?: 1-Yes | 2-No");
            select = Integer.parseInt(nb.nextLine());
        } while (select != 2);
    }

    /**
     * 3. Hiển thị thông tin sản phẩm
     *
     * @param myList Nhận 1 linkedList
     * @throws IOException Ngăn Lỗi
     */
    public static void displayInfoProduct(MyList myList) throws IOException {
        System.out.println("Danh sách sản phẩm");
        System.out.println(myList);
        writeFile(OUT_PUT, myList);
    }

    /**
     * 4. Hàm Ghi dữ liệu vào File
     * Sử dụng Generic method
     *
     * @param data : Nhận dữ liệu là Object
     * @throws IOException: Ngăn, xử lý lỗi
     */
    public static <T> void writeFile(String fileName, T data) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(String.valueOf(data));

        printWriter.close();
        fileWriter.close();
    }

    public static void addToFile(MyList myList) throws IOException {
        writeFile(FILE_NAME, myList);
        System.out.println("Ghi vào file thành công");
    }

    /**
     * 5. Tìm Kiếm sản phẩm theo Id
     *
     * @param myList: nhận LinkedList
     * @return: Không tìm thấy return -1
     */
    public static void searchById(MyList myList) {
        Scanner sc = new Scanner(System.in);

        Node current = myList.head;
        System.out.print("Nhập Id sản phẩm: ");
        String key = sc.next();

        Node newNode = current.nextNode;

        // Nếu tù khóa trùng với Node đầu tiên in Node và thoát
        while (current != null) {
            // Ở lần lặp tiếp theo điều kiện sẽ false, chương trình sẽ nhảy xuống vòng lặp bên dưới
            if (current.info.id.equalsIgnoreCase(key)) {
                System.out.println("Tìm thành Công");
                System.out.println(current);
                return;
            }

            // newNode là một node sau head duyệt qua và tìm node trung với key
            while (newNode != null && newNode.info.id.equalsIgnoreCase(key)) {
                System.out.println("Tìm thành Công");
                System.out.println(newNode);

                // Cập nhật newNode
                newNode = newNode.nextNode;
                return;
            }
            // cập nhật current là nốt tiếp theo
            current = current.nextNode;
        }
        // Vòng lặp sẽ chạy đến khi current = null nếu không tìm thấy key trùng
        System.out.println("Không có sản phẩm: -1");
    }

    /**
     * 6. Xóa Sản phẩm theo id
     *
     * @param myList: nhận Linkedlist
     */
    public static void deleteById(MyList myList) {
        Scanner sc = new Scanner(System.in);
        Node current = myList.head;
        Node newNode = null;

        System.out.print("Nhập Id sản phẩm cần xóa: ");
        String key = sc.next();

        // Nếu Id Node head giống với từ khóa thì xóa head
        if (current != null && current.info.id.equalsIgnoreCase(key)) {
            myList.head = current.nextNode;
            System.out.printf("Xóa sản phẩm có Id %s thành công\n ", key);
            return;
        }

        while (current != null && !(current.info.id.equalsIgnoreCase(key))) {
            newNode = current;
            current = current.nextNode;
        }
        newNode.nextNode = current.nextNode;
    }

    /**
     * 8. Chuyển đổi sang hệ nhị phân
     *
     * @param quality: Nhận một số nguyên
     * @return: trả về hệ nhị phân
     */
    public static int coverBinary(int quality) {
        if (quality == 0) {
            return 0;
        }
        return (quality % 2 + 10 * coverBinary(quality / 2));
    }

    /**
     * 9. Đọc từ File và lưu vào Stack
     * @throws IOException: Ngăn lỗi ngọai lệ
     */
    public static void readFileSaveToStack() throws IOException {
        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(FILE_NAME);

        int i;
        // Trong khi vẫn còn đọc danh sách
        while ((i = fileReader.read()) != -1) {

            //Nối chuỗi với mã đc ép kiểu sang char
            sb.append((char) i);
        }
        fileReader.close();
        String arrString = sb.toString();

        // Tách chuổi thành từng dòng thông qua điểm chung \n
        String[] arr = arrString.split("\n");
        MyStack myStack = new MyStack();
        int n = arr.length;

        // Duyệt qua mảng tách để lấy những thuộc tính riêng
        for (int j = 1; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            myStack.pushStackHead(product);
        }
        System.out.print(myStack);

        // Ghi vào file
        writeFile(OUT_PUT, myStack);
    }

    /**
     * 10. Đọc từ file và lưu vào Queue
     * @throws IOException Ngăn Lỗi
     */
    public static void readFileSaveToQueue() throws IOException {
        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(FILE_NAME);

        int i;
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }
        fileReader.close();

        String arrString = sb.toString();
        String[] arr = arrString.split("\n");
        MyQueue myQueue = new MyQueue();
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            myQueue.enQueue(product);
        }
        System.out.print(myQueue);
        writeFile(OUT_PUT, myQueue);

    }
}
