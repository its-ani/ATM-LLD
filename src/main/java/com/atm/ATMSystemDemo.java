package com.atm;

import com.atm.state.ATM;

public class ATMSystemDemo {
    public static void main(String[] args) {
        ATM atm = new ATM();

        System.out.println("--- Scenario 1: Correct Flow ---");
        atm.insertCard();
        atm.insertPin(1234); // Correct PIN
        atm.requestCash(5600);
        
        System.out.println("\n--- Scenario 2: Wrong PIN Flow ---");
        atm.insertCard();
        atm.insertPin(9999); // Wrong PIN
        
        System.out.println("\n--- Scenario 3: Request Cash without Card ---");
        atm.requestCash(1000);
    }
}
