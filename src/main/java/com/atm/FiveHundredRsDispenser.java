package com.atm;

public class FiveHundredRsDispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 500) {
            int num = cur.getAmount() / 500;
            int remainder = cur.getAmount() % 500;
            System.out.println("Dispensing " + num + " 500Rs note(s)");
            if (remainder != 0) {
                if (this.chain != null) {
                    this.chain.dispense(new Currency(remainder));
                } else {
                    System.out.println("Cannot dispense remainder: " + remainder);
                }
            }
        } else {
            if (this.chain != null) {
                this.chain.dispense(cur);
            }
        }
    }
}
