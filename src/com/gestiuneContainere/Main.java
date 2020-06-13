package com.gestiuneContainere;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PortContainer portContainer1 = new PortContainer("Haine");
        PortContainer portContainer2 = new PortContainer("Colete");
        PortContainer portContainer3 = new PortContainer("Materiale de constructie");

        portContainer1.adaugaContainere(Tip.Jumbo_100mc, 20);
        portContainer1.adaugaContainere(Tip.Mare_50mc, 10);
        portContainer1.adaugaContainere(Tip.Jumbo_100mc, 20);

        //afisare instante
        System.out.println("----------Afisare portContainere:");
        System.out.println(portContainer1.toString());
        System.out.println(portContainer2.toString());
        System.out.println(portContainer3.toString());

        //exemplu deep-copy
        try {
            PortContainer container4 = (PortContainer) portContainer1.clone();
            System.out.println("----------PortContainer inaite de modificare: \n"+ container4.toString());

            container4.adaugaContainere(Tip.Jumbo_100mc, 60);
            System.out.println("----------Dupa modificare: \n" + container4.toString());
            System.out.println("----------PortContainerul dupa care s-a facut copierea initiala \n" + portContainer1);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //testare metoda getCapacitate
        System.out.println("----------Testare metoda get capacitate: "+ portContainer1.getCapacitate() + "\n");

        //colectie cu cele 3 instante
        ArrayList<PortContainer> flota = new ArrayList<PortContainer>();
        flota.add(portContainer1);
        flota.add(portContainer2);
        flota.add(portContainer3);

        //salvare colectie in fisier text
        FileWriter outFile = null;
        BufferedWriter writer = null;

        try {
            outFile = new FileWriter("PortContainere.csv", false);
            writer = new BufferedWriter(outFile);

            for (PortContainer i : flota) {
                writer.write(i.toFileString());
                writer.newLine();
            }
            writer.close();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //citirea din fisier si refacerea din memorie intr un alt tip de colectie
        ArrayDeque<PortContainer> flota2 = new ArrayDeque<PortContainer>();
        FileReader inFile = null;
        BufferedReader reader = null;

        try {
            inFile = new FileReader("PortContainere.csv");
            reader = new BufferedReader(inFile);

            Scanner fileScanner = new Scanner(reader);
            while(fileScanner.hasNext()){
                //Citim un portcontainer
                PortContainer local = new PortContainer("");

                //Citesc eticheta
                String eticheta;
                eticheta = fileScanner.nextLine();
                local.setEticheta(eticheta);

                //Citim toate containerele asociate portContainerului
                //Stim ca urmeaza NR_TIPURI_CONTAINER tipuri de containere
                for (int i=0;i<PortContainer.NR_TIPURI_CONTAINER;i++) {
                    //Citim containerul i
                    String linie = null;
                    linie = fileScanner.nextLine();
                    Scanner linieScanner = new Scanner(linie);
                    linieScanner.useDelimiter(",");

                    //Primul sir pana in virgula = tipul containerului
                    String tip = linieScanner.next();
                    Tip tipContainer = Tip.valueOf(tip);

                    //Al doilea sir este numarul de containere
                    int nr = linieScanner.nextInt();
                    local.adaugaContainere(tipContainer, nr);

                }
                //Adaugam portContainerul in coada
                flota2.offerLast(local);
                //Am citit containerul. Trecem la urmatorul

                //citeste "\n" separator dintre obiecte
                fileScanner.nextLine();
            }
            reader.close();
            inFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //afisare elemente din coada
        System.out.println("----------Afisare coada dupa citirea din fisier: ");
        PortContainer iter = null;
        while (!flota2.isEmpty()) {
            iter = flota2.pollFirst();
            System.out.println(iter.toString());
        }

        //intante ale clasei Macara
        Macara[] macarale = {
                new Macara(Tip.Mare_50mc, 500),
                new Macara(Tip.Mare_50mc, 400),
                new Macara(Tip.Mare_50mc, 300),
                new Macara(Tip.Jumbo_100mc,200),
                new Macara(Tip.Jumbo_100mc, 100)
        };
        int numarMacarale = macarale.length;
        Thread[] threads = new Thread[numarMacarale];
        for(int i=0;i< numarMacarale;i++){
            Descarcator descarcator = new Descarcator(macarale[i], portContainer1);
            threads[i] = new Thread(descarcator);
        }
        System.out.println("----------PortContainer inainte de descarcare: ");
        System.out.println(portContainer1);

        for(Thread t: threads){
            t.start();
        }

        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n----------PortContainer dupa descarcare:");
        System.out.println(portContainer1);

    }
}
