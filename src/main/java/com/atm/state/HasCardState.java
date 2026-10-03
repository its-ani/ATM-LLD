package com.atm.state;

public class HasCardState implements ATMState {

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
        // Simple hardcoded PIN logic for demonstration
        if (pin == 1234) {
            System.out.println("PIN authenticated.");
            atm.setState(atm.getSelectOperationState());
        } else {
            System.out.println("Invalid PIN. Card ejected.");
            atm.setState(atm.getIdleState());
        }
    }

    @Override
    public void requestCash(ATM atm, int amount) {
        System.out.println("Please enter PIN first.");
    }
}
