package configurafacil;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Carro {
    private List<String> pecas;

    public Carro(List<String> pecas) {
        this.pecas = pecas;
    }

    public Carro() {
        this.pecas = new ArrayList<>(); 
    }
    
    public Carro(Carro umCarro){
        this.pecas = umCarro.getPecas();
    }

    public List<String> getPecas() {
        return pecas;
    }

    public void setPecas(List<String> pecas) {
        this.pecas = pecas;
    }
    
    @Override
    public Carro clone(){
        return new Carro(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.pecas);
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
        if (this.pecas.equals(other.pecas)) {
            return true;
        }
        return false;
    }   
}
