package org.example;

public class Main {
    public static void main(String[] args) {
        Shoes airJordan = new Shoes("Air Jordan Max", 250.50, 1, true);
        Shoes redOctobers = new Shoes("Cool Red Octobers",2000, 0, false);
        System.out.println(airJordan.getSellingPrice());
        System.out.println(redOctobers.getSellingPrice());
        System.out.println(airJordan.shouldSell());
        System.out.println(redOctobers.shouldSell(7.1));
    }
}