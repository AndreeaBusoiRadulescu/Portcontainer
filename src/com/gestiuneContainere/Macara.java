package com.gestiuneContainere;

public class Macara {
    private Tip tipContainer;
    private int timpManipulare; //in milisecunde
    private static int last_id = 1;
    private int id;

    //constructor
    public Macara(Tip tipContainer, int timpManipulare) {
        this.tipContainer = tipContainer;
        this.timpManipulare = timpManipulare;
        id = last_id;
        last_id ++;
    }

    //getters si setters
    public Tip getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(Tip tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }


    @Override
    public String toString() {
        return "Macara " + id;
    }
}