import java.io.IOException;
import java.util.Scanner;

/**
 * Class chưa phương thức chính chạy chương trình
 */
public class AS2_Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        MyList myList = new MyList();

        boolean choise = true;
        do {
                showMenu();
            try {
                int input = Integer.parseInt(sc.nextLine());

                switch (input) {
                    case 1:
                        OperationToProduct.dataFile(myList);
                        break;
                    case 2:
                        OperationToProduct.inputProduct(myList);
                        break;
                    case 3:
                        OperationToProduct.displayInfoProduct(myList);
                        break;
                    case 4:
                        OperationToProduct.addToFile(myList);
                        break;
                    case 5:
                        OperationToProduct.searchById(myList);
                        break;
                    case 6:
                        OperationToProduct.deleteById(myList);
                        break;
                    case 7:
                        myList.sortById(myList, myList.head);
                        System.out.println(myList);
                        break;
                    case 8:
                        System.out.printf("Mã nhị phân của %d là: ", myList.head.info.quantity);
                        System.out.println(OperationToProduct.coverBinary(myList.head.info.quantity));
                        break;
                    case 9:
                        System.out.println("Danh sách Stack");
                        OperationToProduct.readFileSaveToStack();
                        break;
                    case 10:
                        System.out.println("Danh sách Queue");
                        OperationToProduct.readFileSaveToQueue();
                        break;
                    default:
                        choise = false;
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        } while (choise);

    }

    /**
     * Menu chương trình
     */
    public static void showMenu() {
        System.out.println("==============================================");
        System.out.println("-----------------Product List-----------------");
        System.out.println("|    1. Xem danh sách sản phẩm sẵn có         |");
        System.out.println("|    2. Thêm sản phẩm vào cuối danh sách      |");
        System.out.println("|    3. Hiển thị danh sách sản phẩm           |");
        System.out.println("|    4. Lưu sản phẩm vào File                 |");
        System.out.println("|    5. Tìm sản phẩm theo ID                  |");
        System.out.println("|    6. Xóa sản phẩm theo ID                  |");
        System.out.println("|    7. Sắp xếp sản phẩm theo ID              |");
        System.out.println("|    8. Chuyển đổi sang nhị phân              |");
        System.out.println("|    9. Hiển thị danh sách từ stack           |");
        System.out.println("|    10. Hiển thị danh sách từ queue          |");
        System.out.println("|    0. Thoát                                 |");
        System.out.println("==============================================");
        System.out.println("Chọn từ 0-->10");
        System.out.print("Bạn chọn: ");
    }
}
