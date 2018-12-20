package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Pacote {
    private String nome;
    private float desconto;
    private List<String> pecas;

    public Pacote(String nome, float desconto, List<String> pecas) {
        this.nome = nome;
        this.desconto = desconto;
        this.pecas = new ArrayList<>(pecas);
    }
    
    public Pacote(){
        this.nome = "";
        this.desconto = 0;
        this.pecas = new ArrayList<>();
    }
    
    public Pacote(Pacote umPacote){
        this.nome = umPacote.getNome();
        this.desconto = umPacote.getDesconto();
        this.pecas = umPacote.getPecas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public List<String> getPecas() {
        return new ArrayList<>(this.pecas);
    }

    public void setPecas(List<String> pecas) {
        this.pecas = new ArrayList<>(pecas);
    }
    
    @Override
    public Pacote clone(){
        return new Pacote(this);
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

        Pacote other = (Pacote) obj;
        return (this.nome.equals(other.getNome()) && this.desconto == other.getDesconto() 
                && this.pecas.equals(other.getPecas()));
    }
    
    public void addPeca(String peca){
        this.pecas.add(peca);
    }
}