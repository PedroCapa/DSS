package Classes;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Utilizador{
    
    private List<Carro> carros;

    public Cliente(String nome, String password, String email, List<Carro> carros) {
        super(nome, password, email);
        this.carros = new ArrayList<>(carros);
    }
    
    public Cliente(String nome, String password, String email){
        super(nome, password, email);
    }
    
    public Cliente() {
        super();
        this.carros = new ArrayList<>();
    }
    
    public Cliente(Cliente umCliente){
        super(umCliente);
        this.carros = umCliente.getCarros();
    }

    public List<Carro> getCarros() {
        return new ArrayList<>(this.carros);
    }

    public void setCarros(List<Carro> Carros) {
        this.carros = new ArrayList<>(carros);
    }
    
    @Override
    public Cliente clone(){
        return new Cliente(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Cliente other = (Cliente) obj;
        
        if (super.equals(other) && this.carros.equals(other.getCarros())) {
            return true;
        }
        return false;
    }
}