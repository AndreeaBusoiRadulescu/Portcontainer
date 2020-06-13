package com.gestiuneContainere;

public enum Tip {
    Mic_10mc(10),
    Mediu_25mc(25),
    Mare_50mc(50),
    Jumbo_100mc(100);

    private int capacitate;

    Tip(int capacitate){
        this.capacitate = capacitate;
    }

    public int getCapacitate() {
        return capacitate;
    }
}
