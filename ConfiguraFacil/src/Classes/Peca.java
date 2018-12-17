package Classes;

import java.util.List;
import java.util.ArrayList;

public abstract class Peca {
    private int quantidade;
    private String nome;
    private String id;
    private List<Peca> obrigatorias;
    private List<Peca> incompativeis;

    public Peca(int quantidade, String nome, String id, List<Peca> obrigatorias, List<Peca> incompativeis) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.id = id;
        this.obrigatorias = new ArrayList<>(obrigatorias);
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    
    public Peca() {
        this.quantidade = 0;
        this.nome = "";
        this.id = "";
        this.obrigatorias = new ArrayList<>();
        this.incompativeis = new ArrayList<>();
    }
    
    public Peca(Peca umaPeca){
        this.quantidade = umaPeca.getQuantidade();
        this.nome = umaPeca.getNome();
        this.id = umaPeca.getId();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public List<Peca> getObrigatorias() {
        return new ArrayList<>(this.obrigatorias);
    }

    public void setObrigatorias(List<Peca> obrigatorias) {
        this.obrigatorias = new ArrayList<>(obrigatorias);
    }

    public List<Peca> getIncompativeis() {
        return new ArrayList<>(this.incompativeis);
    }

    public void setIncompativeis(List<Peca> incompativeis) {
        this.incompativeis = new ArrayList<>(incompativeis);
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
        return (this.quantidade != other.quantidade && this.nome.equals(other.nome) && this.id.equals(other.getId())
         && this.obrigatorias.equals(other.obrigatorias) && this.incompativeis.equals(other.getIncompativeis()));
    }   
}