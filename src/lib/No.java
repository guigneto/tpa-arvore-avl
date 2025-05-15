package lib;

public class No<T> {

    private T valor;
    private No<T> filhoDireita;
    private No<T> filhoEsquerda;

    public No(T valor){
        this.valor = valor;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public int obterAltura(){
        return obterAltura(this);
    }
    private int obterAltura(No<T> no){
        if(no==null)
            return -1;
        else{
            int hd = obterAltura(no.getFilhoDireita());
            int he = obterAltura(no.getFilhoEsquerda());
            if(hd > he)
                return hd+1;
            else
                return he+1;
        }
    }

    public int fatorBalanceamento(){
        return obterAltura(this.filhoDireita) - obterAltura(this.filhoEsquerda);
    }
}
