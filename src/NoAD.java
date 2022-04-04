public class NoAD {
    private Integer dado;
    private NoAD proximo;
    private NoAD anterior;

    public NoAD(){
        this.dado = null;
        this.proximo = null;
        this.anterior = null;
    }

    public NoAD(Integer pDado){
        this.dado = pDado;
        this.proximo = null;
        this.anterior = null;
    }
    
    public Integer pegaDado(){
        return this.dado;
    }

    public NoAD pegaProximo(){
        return this.proximo;
    }

    public NoAD pegaAnterior(){
        return this.anterior;
    }

    public void setaProximo(NoAD pNo){
        this.proximo = pNo;
    }

    public void setaAnterior(NoAD pNo){
        this.anterior = pNo;
    }
}