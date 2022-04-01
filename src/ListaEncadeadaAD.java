public class ListaEncadeadaAD {
    private NoAD primeiro;
    private NoAD ultimo;

    public ListaEncadeadaAD() {
        this.primeiro = null;
        this.ultimo = null;
    }
    public ListaEncadeadaAD(NoAD pPrimeiro) {
        this.primeiro = pPrimeiro;
        this.ultimo = pPrimeiro;
    }
    private NoAD irAteFinal() {
        NoAD ptrProximo = this.primeiro;
        NoAD ultimo = null;
        while (ptrProximo != null) {
            ultimo = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return ultimo;
    }
    private NoAD irAtePenultimo() {
        NoAD ptrProximo = this.primeiro;
        NoAD ultimo = null;
        NoAD penultimo = null;
        while (ptrProximo != null) {
            penultimo = ultimo;
            ultimo = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return penultimo;
    }
    private NoAD encontrar(NoAD pNo) {
        NoAD ptrProximo = this.primeiro;
        while ((ptrProximo != null)
                && (ptrProximo.pegaDado() != pNo.pegaDado())) {
            ptrProximo = ptrProximo.pegaProximo();
        }
        return ptrProximo;
    }
    private NoAD encontrarAnteriorAoMaior(NoAD pNo) {
        NoAD ptrProximo = this.primeiro;
        NoAD anterior = null;
        while ((ptrProximo != null)
                && (ptrProximo.pegaDado() < pNo.pegaDado())) {
            anterior = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return anterior;
    }
    private NoAD encontrarAnterior(NoAD pNo) {
        NoAD ptrProximo = this.primeiro;
        NoAD anterior = null;
        while ((ptrProximo != null) && (ptrProximo.pegaDado() != pNo.pegaDado())) {
            anterior = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return anterior;
    }
    public void imprimirInicio2Fim() {
        NoAD ptrProximo = this.primeiro;
        while (ptrProximo != null) {
            System.out.println(ptrProximo.pegaDado());
            ptrProximo = ptrProximo.pegaProximo();
        }
    }
    public void imprimirFim2Inicio() {
        NoAD ptrAnterior = this.ultimo;
        while (ptrAnterior != null) {
            System.out.println(ptrAnterior.pegaDado());
            ptrAnterior = ptrAnterior.pegaAnterior();
        }
    }
    public boolean inserePrimeiro(Integer i) {
        NoAD no = new NoAD(i);
        boolean inserido = false;
        if (this.primeiro == null) {
            this.primeiro = no;
            inserido = true;
        } else { // percorrer a lista até o último nó
            NoAD primeiroElemento = this.primeiro;
            primeiroElemento.setaAnterior(no);
            inserido = true;
        }
        return inserido;
    }
    public boolean insereUltimo(Integer i) {
        NoAD no = new NoAD(i);
        boolean inserido = false;
        if (this.primeiro == null) {
            this.primeiro = no;
            this.ultimo = no;
            inserido = true;
        } else { // percorrer a lista até o último nó
            NoAD ultimoAD = irAteFinal();
            if (ultimoAD != null) {
                ultimoAD.setaAnterior(irAtePenultimo());
                ultimoAD.setaProximo(no);
                this.ultimo = no;
                inserido = true;
            }
        }
        return inserido;
    }
    public NoAD removePrimeiro() {
        NoAD noAux = this.primeiro;
        if (this.primeiro != null) {
            this.primeiro = this.primeiro.pegaProximo();
        }
        return noAux;
    }
    public NoAD removeUltimo() {
        if (this.primeiro == null) {
            this.ultimo = null;
        } else {
            if (this.primeiro.pegaProximo() == null) {
                this.ultimo = this.primeiro;
                this.primeiro = null;
            } else {
                NoAD penultimoNo = irAtePenultimo();
                if (penultimoNo != null) {
                    this.ultimo = penultimoNo;
                    penultimoNo.setaProximo(null);
                }
            }
        }
        return this.ultimo;
    }
    public boolean insereOrdenado(Integer i) {
        NoAD no = new NoAD(i);
        NoAD noPosicaoAnteriorMaior = null;
        boolean inserido = false;
        noPosicaoAnteriorMaior = this.encontrarAnteriorAoMaior(no);
        if (noPosicaoAnteriorMaior == null) {
            this.inserePrimeiro(i);
            inserido = true;
        } else {
            // insere no final
            if (noPosicaoAnteriorMaior.pegaProximo() == null) {
                this.insereUltimo(i);
                inserido = true;
            } else {
                no.setaProximo(noPosicaoAnteriorMaior.pegaProximo());
                noPosicaoAnteriorMaior.setaProximo(no);
                inserido = true;
            }
        }
        return inserido;
    }
    public boolean insereDepois(NoAD pNo, Integer i) {
        NoAD no = new NoAD(i);
        NoAD noDepois = null;
        boolean inserido = false;
        if (pNo != null) {
            noDepois = this.encontrar(pNo);
        }
        if (noDepois != null) {
            no.setaProximo(noDepois.pegaProximo());
            no.setaAnterior(noDepois);
            noDepois.setaProximo(no);
            inserido = true;
        }
        return inserido;
    }
    public NoAD remove(NoAD pNo) {
        NoAD anterior = null;
        NoAD removido = null;
        if (this.primeiro == null) {
            removido = null;
        } else {
            if ((this.primeiro != null) && (this.primeiro.pegaDado() ==
                    pNo.pegaDado())) {
                removido = this.removePrimeiro();
            } else {
                if (pNo != null) {
                    anterior = encontrar(pNo);
                }
                if (anterior != null) {
                    if (anterior.pegaProximo() == null) {
                        removido = this.removeUltimo();
                    } else {
                        NoAD no = encontrar(pNo);

                        NoAD proximo = no.pegaProximo();
                        anterior = no.pegaAnterior();

                        anterior.setaProximo(proximo);
                        proximo.setaAnterior(anterior);

                        no.setaAnterior(null);
                        no.setaProximo(null);

                        removido = no;
                    }
                }
            }
        }
        return removido;
    }
    public static void main(String[] args) {
        NoAD n;
        ListaEncadeadaAD lista = new ListaEncadeadaAD();
        System.out.println("Inseriu Ultimo 10 ? " + lista.insereUltimo(10));
        System.out.println("Inseriu Ultimo 11 ? " + lista.insereUltimo(11));
        System.out.println("Inseriu Ultimo 12 ? " + lista.insereUltimo(12));
        System.out.println("Inseriu Ultimo 12 ? " + lista.insereUltimo(100));
        System.out.println("Inseriu Ultimo 13 ? " + lista.insereUltimo(13));
        System.out.println("Inseriu Ultimo 14 ? " + lista.insereUltimo(14));
        System.out.println("Inseriu Primeiro 9 ? " + lista.inserePrimeiro(9));
        System.out.println("Inseriu Ultimo 16 ? " + lista.insereUltimo(16));

        lista.imprimirInicio2Fim();
        System.out.println();
        lista.imprimirFim2Inicio();

        System.out.println("\nInseriu depois 14 -> 15 ? " +
                lista.insereDepois(new NoAD(14), 15));

        System.out.println("Remove 10 ? " +
                ((n = lista.remove(new NoAD(10))) != null ? n.pegaDado() : false));
        System.out.println("Remove 100 ? " +
                ((n = lista.remove(new NoAD(100))) != null ? n.pegaDado() : false));
        System.out.println("Remove ultimo ? " +
                ((n = lista.removeUltimo()) != null ? n.pegaDado() : false));
        System.out.println("Remove primeiro ? " +
                ((n = lista.removePrimeiro()) != null ? n.pegaDado() : false));

        lista.imprimirInicio2Fim();
        System.out.println();
        lista.imprimirFim2Inicio();
    }
}