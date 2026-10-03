package com.atm.state;

public interface ATMState {
    void insertCard(ATM atm);
    void ejectCard(ATM atm);
    void insertPin(ATM atm, int pin);
    void requestCash(ATM atm, int amount);
}
