package Classes;

import java.util.List;
import java.util.ArrayList;

public class Pacote {
    private String nome;
    private List<Peca> pecas;

    public Pacote(String nome, List<Peca> pecas) {
        this.nome = nome;
        this.pecas = pecas;
    }
    
    public Pacote(){
        this.nome = "";
        this.pecas = new ArrayList<>();
    }
    
    public Pacote(Pacote umPacote){
        this.nome = umPacote.getNome();
        this.pecas = umPacote.getPecas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
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
        return (this.nome.equals(other.getNome()) && this.pecas.equals(other.getPecas()));
    }    
}