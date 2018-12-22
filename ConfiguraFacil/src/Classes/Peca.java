package Classes;

import Exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Peca {
    private int quantidade;
    private String nome;
    private float preco;
    private List<String> obrigatorias;
    private List<String> incompativeis;

    public Peca(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.obrigatorias = new ArrayList<>(obrigatorias);
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    
    public Peca() {
        this.quantidade = 0;
        this.nome = "";
        this.preco = 0;
        this.obrigatorias = new ArrayList<>();
        this.incompativeis = new ArrayList<>();
    }
    
    public Peca(Peca umaPeca){
        this.quantidade = umaPeca.getQuantidade();
        this.nome = umaPeca.getNome();
        this.preco = umaPeca.getPreco();
        this.obrigatorias = umaPeca.getObrigatorias();
        this.incompativeis = umaPeca.getIncompativeis();        
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public List<String> getObrigatorias() {
        return new ArrayList<>(this.obrigatorias);
    }

    public void setObrigatorias(List<String> obrigatorias) {
        this.obrigatorias = new ArrayList<>(obrigatorias);
    }

    public List<String> getIncompativeis() {
        return new ArrayList<>(this.incompativeis);
    }

    public void setIncompativeis(List<String> incompativeis) {
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome);
    }

    @Override
    public String toString() {
        return "Peca{" + "quantidade=" + quantidade + ", nome=" + nome + ", preco=" + preco + ", obrigatorias=" + obrigatorias + ", incompativeis=" + incompativeis + '}';
    }
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Peca other = (Peca) obj;
        return (this.quantidade != other.quantidade && this.nome.equals(other.nome) && this.preco == other.getPreco()
            && this.obrigatorias.equals(other.obrigatorias) && this.incompativeis.equals(other.getIncompativeis()));
    }
    
    public void addProibida(String p)throws PecaJaExisteException{
        if(this.incompativeis.contains(p))
            throw new PecaJaExisteException("Essa peca ja era considerada incompativel");
        this.incompativeis.add(p);
    }
    
    public void addObrigatoria(String p)throws PecaJaExisteException{
        if(this.incompativeis.contains(p))
            throw new PecaJaExisteException("Essa peca ja era considerada incompativel");
        this.incompativeis.add(p);
    }
    
    public void addStock(int numero){
        this.quantidade = this.quantidade + numero;
    }
    
    public void reduzStock(){
        this.quantidade--;
    }
}