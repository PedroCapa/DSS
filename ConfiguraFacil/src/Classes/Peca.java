package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Peca {
    private int quantidade;
    private String nome;
    private List<String> obrigatorias;
    private List<String> incompativeis;

    public Peca(int quantidade, String nome, List<String> obrigatorias, List<String> incompativeis) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.obrigatorias = new ArrayList<>(obrigatorias);
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    
    public Peca() {
        this.quantidade = 0;
        this.nome = "";
        this.obrigatorias = new ArrayList<>();
        this.incompativeis = new ArrayList<>();
    }
    
    public Peca(Peca umaPeca){
        this.quantidade = umaPeca.getQuantidade();
        this.nome = umaPeca.getNome();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Peca other = (Peca) obj;
        return (this.quantidade != other.quantidade && this.nome.equals(other.nome) 
            && this.obrigatorias.equals(other.obrigatorias) && this.incompativeis.equals(other.getIncompativeis()));
    }
    
    public void addStock(int numero){
        this.quantidade = this.quantidade + numero;
    }
    
    public void reduzStock(){
        this.quantidade--;
    }
}