package com.atm.state;

public class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card inserted successfully.");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("No card inserted to eject.");
    }

    @Override
    public void insertPin(ATM atm, int pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void requestCash(ATM atm, int amount) {
        System.out.println("Please insert card first.");
    }
}
