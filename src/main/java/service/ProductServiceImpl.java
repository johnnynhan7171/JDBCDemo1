package service;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;
import util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void findAllProduct() {
        List<Product> products = productDAO.findAllProduct();
        display(products);
    }

    @Override
    public void findByName(Scanner scanner) {
        System.out.println("Nhập tên sp muốn tìm: ");
        String name = "";
        do {
            name = scanner.nextLine().trim();
            if ("".equals(name)) {
                System.out.println("Tên không được để trống: ");
            }
        } while ("".equals(name));
        List<Product> products = productDAO.findByName(name);
        display(products);
    }

    @Override
    public void insProduct(Scanner scanner) {
        List<Product> products = new ArrayList<>();

        do {
            Product product = new Product();
            System.out.print("Nhập tên: ");
            String input = "";

            do {
                input = scanner.nextLine().trim();
                if ("".equals(input)) {
                    System.out.print("Tên không được để trống: ");
                    continue;
                }
                product.setName(input);
                break;
            } while (true);

            System.out.print("Nhập Price: ");
            do {
                input = scanner.nextLine().trim();
                if (Validator.isNumber(input)) {
                    int price = Integer.parseInt(input);
                    if (price >= 1 && price <= 1000) {
                        product.setPrice(Integer.parseInt(input));
                        break;
                    } else {
                        System.out.println("Price phải >= 1 và <= 1000");
                    }
                } else {
                    System.out.print("Vui lòng nhập một số: ");
                }
            } while (true);

            System.out.println("Nhập số lượng: ");
            do {
                input = scanner.nextLine().trim();
                if (!Validator.isNumber(input) && Integer.parseInt(input) > 0) {
                    System.out.println("Số lượng phải > 0:");
                    continue;
                }
                product.setQOH(Integer.parseInt(input));
                break;
            } while (true);
            products.add(product);

            System.out.print("Bạn có muốn nhập tiếp không? (y/n): ");
        } while (!"n".equalsIgnoreCase(scanner.nextLine().trim()));

        if (productDAO.insProduct(products) == -1) {
            System.out.println("Không thể insert sản phẩm.");
        } else {
            System.out.println("Insert thành công!");
        }
    }

    @Override
    public void display(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm yêu cầu nào!");
        } else {
            System.out.printf("%s \t %-20s \t %s \t %s",
                    "ID", "Name", "OQH", "Price");
            System.out.println();
            products.forEach(t -> {
                System.out.printf("%d \t %-20s \t %d \t %d",
                        t.getId(), t.getName(), t.getPrice(), t.getQOH());
                System.out.println();
            });
            System.out.println("----------------------------------------------");
            System.out.println("Tổng cộng có " + products.size() + " sản phẩm");
        }
    }
}
