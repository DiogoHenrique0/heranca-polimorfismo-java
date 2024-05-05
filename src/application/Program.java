package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int numero = ler.nextInt();

        for (int i = 1; i<=numero; i++){
            System.out.println("Product #"+i+" data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char letra = ler.next().charAt(0);

            System.out.print("Name: ");
            ler.nextLine();
            String name = ler.nextLine();
            System.out.print("Price: ");
            Double price = ler.nextDouble();

            switch(letra){
                case 'c':
                    list.add(new Product(name, price));
                    break;

                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufactureDate = LocalDate.parse(ler.next(), dateFormat);

                    list.add(new UsedProduct(name, price, manufactureDate));
                    break;

                case 'i':
                    System.out.print("Customs fee: ");
                    Double customsFee = ler.nextDouble();

                    list.add(new ImportedProduct(name, price, customsFee));
                    break;
            }
        }

        System.out.println();

        System.out.println("PRICE TAGS:");
        for (Product prodcut : list){
            System.out.print(prodcut.priceTag()+"\n");
        }

        ler.close();
    }
}