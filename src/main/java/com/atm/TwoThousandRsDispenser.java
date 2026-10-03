package com.atm;

public class TwoThousandRsDispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 2000) {
            int num = cur.getAmount() / 2000;
            int remainder = cur.getAmount() % 2000;
            System.out.println("Dispensing " + num + " 2000Rs note(s)");
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
