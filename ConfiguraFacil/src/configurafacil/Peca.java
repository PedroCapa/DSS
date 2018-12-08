
package configurafacil;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Peca {
    private int quantidade;
    private String nome;
    private List<Peca> obrigatorias;
    private List<Peca> incompativeis;

    public Peca(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.obrigatorias = obrigatorias;
        this.incompativeis = incompativeis;
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

    public List<Peca> getObrigatorias() {
        return obrigatorias;
    }

    public void setObrigatorias(List<Peca> obrigatorias) {
        this.obrigatorias = obrigatorias;
    }

    public List<Peca> getIncompativeis() {
        return incompativeis;
    }

    public void setIncompativeis(List<Peca> incompativeis) {
        this.incompativeis = incompativeis;
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
         && this.obrigatorias.equals(other.obrigatorias) && Objects.equals(this.incompativeis, other.incompativeis));
    }
    
    
}
