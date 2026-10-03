package com.atm;

import java.util.Scanner;

public class ATMDispenseChain {
    private DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new TwoThousandRsDispenser();
        DispenseChain c2 = new FiveHundredRsDispenser();
        DispenseChain c3 = new OneHundredRsDispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter amount to dispense (or 0 to exit): ");
            int amount = input.nextInt();
            
            if (amount == 0) {
                System.out.println("Exiting...");
                break;
            }
            
            if (amount % 100 != 0) {
                System.out.println("Amount should be in multiples of 100 Rs.");
                continue;
            }
            
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
        
        input.close();
    }
}
