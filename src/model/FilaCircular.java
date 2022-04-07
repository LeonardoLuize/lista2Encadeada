package model;

import java.util.Arrays;

public class FilaCircular {
    private int primeiro;
    private int tamanho;
    private int numeroDados;
    private int[] dados;

    public FilaCircular(int tamanho){
        this.primeiro = 0;
        this.numeroDados = 0;
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
    }

    public boolean inserir(int e){
        if(numeroDados < this.tamanho){
            int fim = (this.primeiro + numeroDados) % this.tamanho;
            this.dados[fim] = e;
            this.numeroDados++;
            return true;
        }

        return false;
    }

    public boolean remover(){
        if(numeroDados > 0){
            primeiro = (this.primeiro) % this.tamanho;
            numeroDados--;
            this.dados[numeroDados] = 0;
            return true;
        }
        return false;
    }

    public void imprimir(){
        System.out.println(Arrays.toString(dados));
    }


}
