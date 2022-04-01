import java.util.Arrays;

public class filaCircular {
    private int primeiro;
    private int tamanho;
    private int n;
    private int[] dados;

    public filaCircular(int tamanho){
        this.primeiro = 0;
        this.n = 0;
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
    }

    public boolean insere(int e){
        if(n < this.tamanho){
            int fim = (this.primeiro + n) % this.tamanho;
            this.dados[fim] = e;
            this.n++;

            return true;
        }

        return false;
    }

    public boolean remove(){
        if(n > 0){
            primeiro = (this.primeiro) % this.tamanho;
            n--;

            this.dados[n] = 0;

            return true;
        }

        return false;
    }

    public void printElementos(){
        System.out.println(Arrays.toString(dados));
    }


}
