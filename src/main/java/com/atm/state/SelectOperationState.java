package com.atm.state;

public class SelectOperationState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card is already inserted.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected.");
        atm.setState(atm.getIdleState());
    }

    @Override
    public void insertPin(ATM atm, int pin) {
        System.out.println("PIN already authenticated.");
    }

    @Override
    public void requestCash(ATM atm, int amount) {
        if (amount % 100 != 0) {
            System.out.println("Amount should be in multiples of 100 Rs.");
            return;
        }
        System.out.println("Processing cash request for " + amount + " Rs.");
        atm.setState(atm.getDispenseState());
        
        // Delegate cash dispensing immediately after changing state
        atm.requestCash(amount); 
    }
}
