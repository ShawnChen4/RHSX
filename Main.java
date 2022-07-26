//RHSX Pit Trader Software
//Authors: Shawn Chen, Ethan Lai
//Version: July 2022
//Description: This program is a trading software that allows users to trade stocks and ETFs.
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    private boolean gameActive = true;
    public static void main(String[] args) {
        Scanner systemInput = new Scanner(System.in);
        System.out.println("Welcome to RHSX Pit Trader!");
        System.out.println("Please enter your name: ");
        String name = systemInput.nextLine();
        System.out.println("What is the buyer's ID");
        String buyerID = systemInput.nextLine();
        System.out.println("What is the seller's ID");
        String sellerID = systemInput.nextLine();
        System.out.println("What is the cost basis?:");
        String costBasis = systemInput.nextLine();
        systemInput.close();

    }
}