package org.example;


import java.text.DecimalFormat;

// Imagine you're writing a program to manage your shoe collection and help decide when you
// should sell them
public class Shoes {
    private String name;
    private double originalPrice;
    private int ageInYears;
    private boolean legit;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // write a new constructor that uses `this` to call the other instructor.
    // it should take in the name and originalPrice, but set the age to 1 and legit to false

    // your code here
    public Shoes(String name, double originalPrice) {
        this(name, originalPrice, 1, false);
    }
    public Shoes(String name, double originalPrice, int ageInYears, boolean legit) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.ageInYears = ageInYears;
        this.legit = legit;
    }

    public String getName() {
        return name;
    }

    public int getAgeInYears() {
        return ageInYears;
    }




    // implement a method `ageShoesByOneYear` that tracks that these Shoes are one year older
    // than before
    public void ageShoesByOneYear() {
        ageInYears++;
    }

    // implement a method called `getSellingPrice` that returns how much this can be sold for
    // using the following rules:
    // 1. if the name contains "Air Jordan", add 500 to the price
    // 2. if the name contains "Nike Dunk", add 700 to the price
    // 3. if the name is "Red October", add 21000 to the price
    // 4. to factor in the age, multiply the current price by how many years old the shoes are.
    // 5. if the shoes are not legit, divide the current price by 10.

    // For instructors: you can choose if you want 1 and 2 to be exclusive or if you want them
    // to have to consider shoe names like Air Jordan Nike Dunk that have both phrases. If
    // there is a legendary Air Jordan Nike Dunk shoe out there, it's probably fine that it
    // gets +1200 to its price... it's probably not legit anyways.
    public double getSellingPrice() {
        // your code here
        double currentSellingPrice = originalPrice;
        if(name.contains("Air Jordan")) {
           currentSellingPrice += 500;
        }else if(name.contains("Nike Dunk")) {
           currentSellingPrice += 700;
        }else if(name.contains("Red October")) {
           currentSellingPrice += 21000;
        }
        currentSellingPrice *= ageInYears;

        if(!legit) {
            currentSellingPrice /= 10;
        }

        return currentSellingPrice;
    }


    // implement a method called `shouldSell` that returns true only if the new selling price is
    // at least 1.5x the amount of the original price.
    public boolean shouldSell() {
        // your code here
        double pricedToSell = originalPrice * 1.5;
        if (this.getSellingPrice() >= pricedToSell) {
            return true;
        }else {
            return false;
        }
    }

    // overload the `shouldSell` method by adding another version that takes in a double parameter
    // that represents the inflation rate.
    // `shouldSell` should return true only if the new selling price is at least 1.5x (the
    // amount of the original price * the inflation rate).
    public boolean shouldSell(double inflation) {
        inflation /= 10;
        double pricedToSell = 1.5 * (originalPrice * inflation);
        System.out.println("Inflation: " + inflation + " pricedToSell: " + pricedToSell);
        if (this.getSellingPrice() >= pricedToSell) {
            return true;
        }else {
            return false;
        }
    }
    // extra for those who want more:
    // make a main method using the Shoes class and design a program that you could actually run
    // every year: learn how to read info from a csv file where each row represents the data for
    // the object (you would need to create your own csv example file)
    // learn how to output it back out with the updated ages + selling recommendations
}