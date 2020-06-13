package com.gestiuneContainere;

import static java.lang.Thread.sleep;

public class Descarcator implements Descarcare, Runnable {
    private Macara macara;
    private final PortContainer portContainer;

    //constructor
    public Descarcator(Macara macara, PortContainer portContainer) {
        this.macara = macara;
        this.portContainer = portContainer;
    }

    @Override
    public synchronized int DescarcaContainer(PortContainer portContainer, Macara macara) {
        if(this.portContainer.isInDescarcare(macara.getTipContainer())){
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.portContainer.blocheazaDescarcare(macara.getTipContainer());
        System.out.println("Macaraua " + macara + " a descarcat container " + macara.getTipContainer().name() + " au ramas: " + portContainer.getNrContainere(macara.getTipContainer()));
        portContainer.scadeContainer(macara.getTipContainer());
        this.portContainer.permiteDescarcare(macara.getTipContainer());
        notifyAll();
        return portContainer.getNrContainere(macara.getTipContainer());
    }

    @Override
    public void run() {
        //System.out.println(portContainer.hashCode());
        //DescarcaTot();
        while(this.portContainer.getNrContainere(this.macara.getTipContainer()) > 0){
            try {
                sleep(macara.getTimpManipulare());
                DescarcaContainer(portContainer, macara);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(macara.getTipContainer().name() + ": " + portContainer.isInDescarcare(macara.getTipContainer()));
        }
    }
}
