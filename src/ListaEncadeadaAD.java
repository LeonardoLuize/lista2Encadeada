public class ListaEncadeadaAD {
    
    private NoAD elemento;

    public ListaEncadeadaAD() {
        elemento = null;
    }

    public ListaEncadeadaAD(NoAD pPrimeiro) {
	    elemento = pPrimeiro;
    }

    private NoAD irAteFinal() {
        // o nó elemento indica onde o inicio da lista é, e ele é estatico (não vai mudar de pos)
        // a var auxiliar é um ponteiro que vai navegar DENTRO da lista do elemento, e retornar oq
        // vc quiser
        NoAD auxiliar = elemento;

        while (auxiliar.pegaProximo() != null) {
            auxiliar = auxiliar.pegaProximo();
        }
        return auxiliar;
    }

    private NoAD encontrar(NoAD pNo) {
        NoAD auxiliar = elemento;
        while ((auxiliar != null) && (auxiliar.pegaDado() != pNo.pegaDado())) {
            auxiliar = auxiliar.pegaProximo();
        }
        return auxiliar;
    }

    public void imprimirInicio2Fim() {
		NoAD auxiliar = elemento;
		System.out.print('[');
		while(auxiliar != null) {
			System.out.print(auxiliar.pegaDado());
			if(auxiliar.pegaProximo() != null) {
				System.out.print(", ");
			}
			auxiliar = auxiliar.pegaProximo();
		}
		System.out.println(']');
	}

    public void imprimirFim2Inicio() {
		NoAD auxiliar = elemento;
		while(auxiliar.pegaProximo() != null) {
			auxiliar = auxiliar.pegaProximo();
		}
		System.out.print('[');
		while(auxiliar != null) {
			System.out.print(auxiliar.pegaDado());
			if(auxiliar.pegaAnterior() != null) {
				System.out.print(", ");
			}
			auxiliar = auxiliar.pegaAnterior();
		}
		System.out.println(']');
	}

    public boolean inserePrimeiro(Integer i) {
        boolean inserido = true;
        if (elemento == null) {
            elemento = new NoAD(i);
            return inserido;
        } 
            NoAD auxiliar = new NoAD(i);
            elemento.setaAnterior(auxiliar);
            auxiliar.setaProximo(elemento);

            // nesse final eu coloco elemento = auxiliar pro inicio da lista ficar apontado pro primeiro elemento
            // lembrando que quando vc faz "elemento = auxiliar", o ponteiro do elemento é igual ao ponto do auxiliar
            elemento = auxiliar;
            return inserido;
    }

    public boolean insereUltimo(Integer i) {
        boolean inserido = true;
        if (elemento == null) {
            elemento = new NoAD(i);
            return inserido;
        }
        NoAD auxiliar = irAteFinal();
        NoAD novoDado = new NoAD(i);

        auxiliar.setaProximo(novoDado);
        novoDado.setaAnterior(auxiliar);

        return inserido;
    }

    public NoAD removePrimeiro() {
        NoAD noAuxiliar = elemento;
        if (elemento != null) {
            elemento = elemento.pegaProximo();
            elemento.setaAnterior(null);
        }
        return noAuxiliar;
    }

    public NoAD removeUltimo() {
        if (elemento == null) {
            return null;
        }
        NoAD auxiliar = irAteFinal();

        auxiliar.pegaAnterior().setaProximo(null);
        auxiliar.setaAnterior(null);

        return auxiliar;
    }

    // usado no método insereOrdenado
    private NoAD encontrarAnteriorAoMaior(NoAD pNo) {
        NoAD ptrProximo = elemento;
        NoAD anterior = null;
        while ((ptrProximo != null)
                && (ptrProximo.pegaDado() < pNo.pegaDado())) {
            anterior = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return anterior;
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
                no.setaAnterior(noPosicaoAnteriorMaior);
                no.pegaProximo().setaAnterior(no);
                noPosicaoAnteriorMaior.setaProximo(no);
                inserido = true;
            }
        }
        return inserido;
    }

    public boolean insereDepois(NoAD pNo, Integer i) {
        NoAD no = new NoAD(i);
        boolean inserido = true;

        if (elemento != null) {
            NoAD noDepois = this.encontrar(pNo);
            no.setaAnterior(noDepois);
            no.setaProximo(noDepois.pegaProximo());
            noDepois.setaProximo(no);
            no.pegaProximo().setaAnterior(no);
        }else{
            return !inserido; 
        }
        return inserido;
    }

    public NoAD remove(NoAD pNo) {
        NoAD anterior = null;
        NoAD removido = null;
        if (elemento == null) {
            removido = null;
        } else {
            if ((elemento != null) && (elemento.pegaDado() ==
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

    public void printAll(){
        imprimirInicio2Fim();
        imprimirFim2Inicio();
        System.out.println();
    }
}
