package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String answer;

    public static void main(String[] args) {
        ArrayList<Store> inventory = new ArrayList<Store>();

        Store st = new Store();
        st.setProducts("Bison Sweater");
        st.setPrices(55.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Tee");
        st.setPrices(14.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Hoodie");
        st.setPrices(23.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Bumpersticker");
        st.setPrices(4.99);
        inventory.add(st);

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getProducts()+ ": $" + inventory.get(i).getPrices());

        }

        ArrayList<Purchases> purchaselist = new ArrayList<Purchases>();
        Scanner input = new Scanner(System.in);
        double price;
        price = 0.00;


        do {
            System.out.println("What would you like to do?");
            System.out.println("1) add purchase 2) change purchase 3) show purchases 4) finish transaction");
            answer = input.nextLine();

            if (answer.equals("1")) {
                System.out.println("What do you wish to buy?");
                answer = input.nextLine();


                for (int i = 0; i < inventory.size(); i++) {
                    if (answer.equals(inventory.get(i).getProducts())){
                        price = inventory.get(i).getPrices();
                    }
                }
                Purchases pts = new Purchases();
                pts.setPurchproduct(answer);
                pts.setPurchprice(price);
                purchaselist.add(pts);

            }  else if (answer.equals("2")) {
                System.out.println("What do you wish to remove?");
                for (int i = 0; i < purchaselist.size(); i++) {
                    System.out.println(purchaselist.get(i).getPurchproduct());
                }

                String delete = input.nextLine();
                int position = -1;
                for (int i = 0; i < purchaselist.size(); i++) {
                    if (purchaselist.get(i).getPurchproduct().equals(delete)) ;
                    {
                        position = i;
                    }

                    if (position != -1) {
                        purchaselist.remove(position);
                    }
                }

            }else if (answer.equals("3")) {
                System.out.println("Here are your purchases");
                for (int i = 0; i < purchaselist.size(); i++) {
                    System.out.println(purchaselist.get(i).getPurchproduct());

                }

            }

        } while (! answer.equals("4"));
        double totalcost = 0.0;
        for (int i = 0; i < purchaselist.size() ; i++)
        {
            totalcost += purchaselist.get(i).getPurchprice();

        }
        System.out.println("Your order total is: $" + totalcost);
        System.out.println("Thank you for ordering!");

    }
}