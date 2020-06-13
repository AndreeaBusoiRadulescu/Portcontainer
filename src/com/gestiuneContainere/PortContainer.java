package com.gestiuneContainere;

public class PortContainer implements Numarabil, Cloneable {
    public static final int NR_TIPURI_CONTAINER = Tip.values().length;
    private Categorie[] categorii = new Categorie[Tip.values().length];
    private String eticheta;
    private boolean inDescarcare[] = new boolean[NR_TIPURI_CONTAINER];

    //constructor
    public PortContainer(String eticheta) {
        this.eticheta = eticheta;
        // Construiesc cele 4 containere
        for(int i = 0; i < NR_TIPURI_CONTAINER; i++){
            categorii[i] = new Categorie(Tip.values()[i], 0);
            inDescarcare[i] = false;
        }
    }

     //getters si setters

    public void setContainere(Tip tipContainer, int numarContainere){
        categorii[tipContainer.ordinal()].setNumarContainere(numarContainere);
    }

    public Categorie getCategorii(int i) {
            return categorii[i];
    }

    public void adaugaContainere(Tip tipContainer, int numarContainere){
            categorii[tipContainer.ordinal()].adaugaContainere(numarContainere);
    }

    public void scadeContainer(Tip tipContainer){
        categorii[tipContainer.ordinal()].scadeContainer();
    }

    public int getNrContainere(Tip tipContainer) {
        return categorii[tipContainer.ordinal()].getNumarContainere();
    }

    public boolean isInDescarcare(Tip tipCategorie) {
        return inDescarcare[tipCategorie.ordinal()];
    }

    public void blocheazaDescarcare(Tip tipCategorie) {
        this.inDescarcare[tipCategorie.ordinal()] = true;
    }

    public void permiteDescarcare(Tip tipCategorie) {
        this.inDescarcare[tipCategorie.ordinal()] = false;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    //metode
    public int NumarTotalContainere() {
        int nr = 0;
        for (int i = 0; i < NR_TIPURI_CONTAINER; i++) {
            nr += categorii[i].getNumarContainere();
        }
        return nr;
    }

    public void setNrContainere(Tip tip,int nr){
        categorii[tip.ordinal()].setNumarContainere(nr);
    }

    @Override
    public String toString() {
        StringBuilder afisare = new StringBuilder(this.eticheta  + "\n");
        for(int i = 0; i< NR_TIPURI_CONTAINER; i++){
            afisare.append(categorii[i].toString()).append("\n");
        }
        return afisare.toString();
    }

    public String toFileString(){
        StringBuilder afisare = new StringBuilder(this.eticheta + "\n");
        for(int i = 0; i< NR_TIPURI_CONTAINER; i++){
            afisare.append(categorii[i].toFileString()).append("\n");
        }
        return afisare.toString();
    }

    @Override
    public int getCapacitate() {
        int capacitate = 0;
        for (int i = 0; i < NR_TIPURI_CONTAINER; i++) {
            capacitate += categorii[i].getCapacitate();
        }
        return capacitate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PortContainer clona = (PortContainer) super.clone();
        clona.categorii = new Categorie[NR_TIPURI_CONTAINER];
        //copiere deep
        //pentru String nu este nevoie deoarece este imutabil
        for(int i = 0; i< Tip.values().length; i++) {
            clona.categorii[i] = new Categorie(this.categorii[i].getTipContainer(), this.categorii[i].getNumarContainere());
        }
        return clona;
    }
}
