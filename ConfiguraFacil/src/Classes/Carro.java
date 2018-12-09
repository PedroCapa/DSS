package Classes;

import java.util.List;
import java.util.ArrayList;

public class Carro {
    private List<String> pecas;
    private float custo;

    public Carro(List<String> pecas, float custo) {
        this.pecas = pecas;
        this.custo = custo;
    }

    public Carro() {
        this.pecas = new ArrayList<>();
        this.custo = 0;
    }
    
    public Carro(Carro umCarro){
        this.pecas = umCarro.getPecas();
        this.custo = umCarro.getCusto();
    }

    public List<String> getPecas() {
        return pecas;
    }

    public void setPecas(List<String> pecas) {
        this.pecas = pecas;
    }
    
    public float getCusto(){
        return this.custo;
    }
    
    public void setCusto(float custo){
        this.custo = custo;
    }
    
    @Override
    public Carro clone(){
        return new Carro(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Carro other = (Carro) obj;
        return (this.pecas.equals(other.getPecas())  && this.custo != other.getCusto());
    }   
}
