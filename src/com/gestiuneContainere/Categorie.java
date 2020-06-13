package com.gestiuneContainere;

public class Categorie {
    private Tip tipContainer;
    private int numarContainere;

    public Tip getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(Tip tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getNumarContainere() {
        return numarContainere;
    }

    public void setNumarContainere(int numarContainere) {
        this.numarContainere = numarContainere;
    }

    public int getCapacitate() {
        return numarContainere* tipContainer.getCapacitate();
    }

    public Categorie(Tip tipContainer, int numarContainere){
        this.numarContainere= numarContainere;
        this.tipContainer = tipContainer;
    }

    public void scadeContainer(){
        if(this.numarContainere>0) {
            this.numarContainere--;
        }
    }

    public void adaugaContainere(int nrContainere){
        this.numarContainere+=nrContainere;
    }

    @Override
    public String toString() {
        return "tip: " +
                tipContainer.name() +
                " cantitate: " +
                numarContainere;
    }

    public String toFileString() {
        return tipContainer.name() +
                "," +
                numarContainere;
    }
}
