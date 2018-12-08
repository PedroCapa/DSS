package Classes;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Utilizador{
    
    private String email;
    private List<Carro> carros;

    public Cliente(String nome, String password, String email, List<Carro> carros) {
        super(nome, password);
        this.email = email;
        this.carros = carros;
    }

    public Cliente() {
        super();
        this.email = "";
        this.carros = new ArrayList<>();
    }
    
    public Cliente(Cliente umCliente){
        super(umCliente);
        this.email = umCliente.getEmail();
        this.carros = umCliente.getCarros();
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public List<Carro> getCarros() {
        List l = new ArrayList<>();
        for(Carro c: this.carros)
            l.add(c.clone());
        return l;
    }

    public void setCarros(List<Carro> Carros) {
        this.carros = new ArrayList<>();
        for(Carro c: Carros)
            this.carros.add(c.clone());
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
        
        if (super.equals(other) && this.email.equals(other.getEmail())&& this.carros.equals(other.getCarros())) {
            return true;
        }
        return false;
    }
    
}
