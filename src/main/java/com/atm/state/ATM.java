package com.atm.state;

import com.atm.DispenseChain;
import com.atm.TwoThousandRsDispenser;
import com.atm.FiveHundredRsDispenser;
import com.atm.OneHundredRsDispenser;

public class ATM {
    private ATMState idleState;
    private ATMState hasCardState;
    private ATMState selectOperationState;
    private ATMState dispenseState;
    
    private ATMState currentState;
    private DispenseChain dispenseChain;

    public ATM() {
        idleState = new IdleState();
        hasCardState = new HasCardState();
        selectOperationState = new SelectOperationState();
        dispenseState = new DispenseState();
        
        currentState = idleState; // Initial state
        
        // Initialize the Chain of Responsibility
        dispenseChain = new TwoThousandRsDispenser();
        DispenseChain c2 = new FiveHundredRsDispenser();
        DispenseChain c3 = new OneHundredRsDispenser();
        
        dispenseChain.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public ATMState getIdleState() { return idleState; }
    public ATMState getHasCardState() { return hasCardState; }
    public ATMState getSelectOperationState() { return selectOperationState; }
    public ATMState getDispenseState() { return dispenseState; }
    public DispenseChain getDispenseChain() { return dispenseChain; }

    // Actions delegated to the current state
    public void insertCard() {
        currentState.insertCard(this);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }

    public void insertPin(int pin) {
        currentState.insertPin(this, pin);
    }

    public void requestCash(int amount) {
        currentState.requestCash(this, amount);
    }
}
