package main;

import model.FilaCircular;
import model.ListaEncadeadaAD;
import model.NoAD;

public class Main {
    public static void main(String[] args) {
        //Lista encadeada:
        System.out.println("=========================================================");
        imprimeListaEncadeada();
        System.out.println("=========================================================");
        //Fila circular:
        imprimeFilaCircular();
    }

    private static void imprimeFilaCircular() {
        System.out.println("Fila Circular: \n" );
        FilaCircular f = new FilaCircular(4);
        f.imprimir();
        // Inserir o elemento 5 na fila f
        f.inserir(5);
        f.imprimir();
        // Inserir o elemento 15 na fila f
        f.inserir(15);
        f.imprimir();
        // Inserir o elemento 25 na fila f
        f.inserir(25);
        f.imprimir();
        // Remover elemento da fila f
        System.out.println("Removido: "+f.remover());
        f.imprimir();
        // Remover elemento da fila f
        System.out.println("Removido: "+f.remover());
        f.imprimir();
        // Inserir o elemento 15 na fila f
        f.inserir(15);
        f.imprimir();
        // Inserir o elemento 25 na fila f
        f.inserir(25);
        f.imprimir();
        // Remover elemento da fila f
        System.out.println("Removido: "+f.remover());
        f.imprimir();
    }

    private static void imprimeListaEncadeada() {
        System.out.println("Lista duplamente encadeada: ");
        NoAD noAd;
        ListaEncadeadaAD listaEncadeadaAD = new ListaEncadeadaAD();
        System.out.println("Inseriu Ultimo 10 ? " + listaEncadeadaAD.insereUltimo(10));
        System.out.println("Inseriu Ultimo 11 ? " + listaEncadeadaAD.insereUltimo(11));
        System.out.println("Inseriu Ultimo 12 ? " + listaEncadeadaAD.insereUltimo(12));
        System.out.println("Inseriu Ultimo 100 ? " + listaEncadeadaAD.insereUltimo(100));
        System.out.println("Inseriu Ultimo 13 ? " + listaEncadeadaAD.insereUltimo(13));
        System.out.println("Inseriu Ultimo 14 ? " + listaEncadeadaAD.insereUltimo(14));
        System.out.println("Inseriu Primeiro 9 ? " + listaEncadeadaAD.inserePrimeiro(9));
        System.out.println("Inseriu Ultimo 16 ? " + listaEncadeadaAD.insereUltimo(16));
        System.out.println("Inseriu depois 14 -> 15 ? " + listaEncadeadaAD.insereDepois(new NoAD(14), 15));
        System.out.println("Remove 10 ? " + ((noAd = listaEncadeadaAD.remove(new NoAD(10))) != null ? noAd.pegaDado() : false));
        System.out.println("Remove 100 ? " + ((noAd = listaEncadeadaAD.remove(new NoAD(100))) != null ? noAd.pegaDado() : false));
        System.out.println("Remove ultimo ? " + ((noAd = listaEncadeadaAD.removeUltimo()) != null ? noAd.pegaDado() : false));
        System.out.println("Remove primeiro ? " + ((noAd = listaEncadeadaAD.removePrimeiro()) != null ? noAd.pegaDado() : false));

        listaEncadeadaAD.imprimirInicio2Fim();
        System.out.println();
        listaEncadeadaAD.imprimirFim2Inicio();
    }
}
