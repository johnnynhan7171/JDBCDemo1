import service.ProductService;
import service.ProductServiceImpl;
import util.Constants;
import util.Validator;

import java.util.Scanner;

public class Inventory {
   static ProductService service = new ProductServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        buildMenu(scanner);
    }

    static void menu() {
        System.out.println("*============*Menu*============*");
        System.out.println("***  1.Xem danh sách sản phẩm***");
        System.out.println("***  2.Tìm sản phẩm theo tên ***");
        System.out.println("***  3.Thêm một sản phẩm mới ***");
        System.out.println("***  4.Thoát                 ***");
        System.out.println("*****   Please choose menu   ***");
    }

    public static void buildMenu(Scanner scanner) {
        String inputMenu;
        do {
            menu();
            inputMenu = input(scanner);
            processInput(inputMenu, scanner);
        } while (!Constants.FOUR.equals(inputMenu));
    }

    static void processInput(String input, Scanner scanner) {
        switch (input) {
            case Constants.ONE:
                service.findAllProduct();
                break;
            case Constants.TWO:
                service.findByName(scanner);
                break;
            //Search book by Title
            case Constants.THREE:
                service.insProduct(scanner);
                break;
            default:
                break;
        }
    }

    private static String input(Scanner scanner) {
        String inputMenu;
        do {
            inputMenu = scanner.nextLine();
            if (!Validator.validInput(inputMenu))
                System.out.println("Please input again. (1->4)");
        } while (!Validator.validInput(inputMenu));
        return inputMenu;
    }
}
