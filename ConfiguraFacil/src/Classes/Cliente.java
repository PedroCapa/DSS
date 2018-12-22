package Classes;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Utilizador{
    
    private List<String> carros;

    public Cliente(String nome, String password, String email, List<String> carros) {
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

    public List<String> getCarros() {
        return new ArrayList<>(this.carros);
    }

    public void setCarros(List<String> Carros) {
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
        return super.equals(other) && this.carros.equals(other.getCarros());
    }

    @Override
    public String toString() {
        return "Cliente{" + "carros=" + carros + '}' + super.toString();
    }
    
    public void addCarro(String s){
        this.carros.add(s);
    }
}