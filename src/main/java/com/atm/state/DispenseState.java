package com.atm.state;

import com.atm.Currency;

public class DispenseState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Please wait, dispensing cash.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Please wait, dispensing cash.");
    }

    @Override
    public void insertPin(ATM atm, int pin) {
        System.out.println("Please wait, dispensing cash.");
    }

    @Override
    public void requestCash(ATM atm, int amount) {
        // Here we trigger the Chain of Responsibility
        atm.getDispenseChain().dispense(new Currency(amount));
        
        System.out.println("Please take your cash. Card ejected automatically.");
        // Transition back to Idle after successful dispensing
        atm.setState(atm.getIdleState());
    }
}
