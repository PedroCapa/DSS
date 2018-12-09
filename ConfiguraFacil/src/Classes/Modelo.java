package Classes;

import java.util.List;
import java.util.ArrayList;

public class Modelo {
    private String nome;
    private List<Pacote> pacotes;
    private float custoBase;

    public Modelo(String nome, List<Pacote> pacotes, float custoBase) {
        this.nome = nome;
        this.pacotes = new ArrayList<>(pacotes);
        this.custoBase = custoBase;
    }
    
    public Modelo(){
        this.nome = "";
        this.pacotes = new ArrayList<>();
        this.custoBase = 0;
    }
    
    public Modelo(Modelo umModelo){
        this.nome = umModelo.getNome();
        this.pacotes = umModelo.getPacotes();
        this.custoBase = umModelo.getCustoBase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pacote> getPacotes() {
        return new ArrayList<>(this.pacotes);
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = new ArrayList<>(pacotes);
    }

    public float getCustoBase() {
        return custoBase;
    }

    public void setCustoBase(float custoBase) {
        this.custoBase = custoBase;
    }
    
    @Override
    public Modelo clone(){
        return new Modelo(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Modelo other = (Modelo) obj;
        return (this.custoBase != other.getCustoBase() && this.nome.equals(other.getNome()) 
            && this.pacotes.equals(other.getPacotes()));
    }    
}
