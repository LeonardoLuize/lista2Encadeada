public class Main {
    public static void main(String[] args) {
        NoAD n;
        ListaEncadeadaAD lista = new ListaEncadeadaAD();
        System.out.println("Inseriu Ultimo 10 ? " + lista.insereUltimo(10));
        lista.printAll();
        System.out.println("Inseriu Ultimo 11 ? " + lista.insereUltimo(11));
        lista.printAll();
        System.out.println("Inseriu Ultimo 12 ? " + lista.insereUltimo(12));
        lista.printAll();
        System.out.println("Inseriu Ultimo 100 ? " + lista.insereUltimo(100));
        lista.printAll();
        System.out.println("Inseriu Ultimo 13 ? " + lista.insereUltimo(13));
        lista.printAll();
        System.out.println("Inseriu Ultimo 14 ? " + lista.insereUltimo(14));
        lista.printAll();
        System.out.println("Inseriu Primeiro 9 ? " + lista.inserePrimeiro(9));
        lista.printAll();
        System.out.println("Inseriu Ultimo 16 ? " + lista.insereUltimo(16));
        lista.printAll();


        System.out.println("\nInseriu depois 14 -> 15 ? " +
                lista.insereDepois(new NoAD(14), 15));
                lista.printAll();

        System.out.println("Remove 10 ? " +
                ((n = lista.remove(new NoAD(10))) != null ? n.pegaDado() : false));
                lista.printAll();
        System.out.println("Remove 100 ? " +
                ((n = lista.remove(new NoAD(100))) != null ? n.pegaDado() : false));
                lista.printAll();
        System.out.println("Remove ultimo ? " +
                ((n = lista.removeUltimo()) != null ? n.pegaDado() : false));
                lista.printAll();
        System.out.println("Remove primeiro ? " +
                ((n = lista.removePrimeiro()) != null ? n.pegaDado() : false));
                lista.printAll();
    }
}
