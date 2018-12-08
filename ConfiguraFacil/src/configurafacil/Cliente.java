package configurafacil;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    
    private String nome;
    private String password;
    private List<Carro> carros;

    public Cliente(String nome, String password, List<Carro> carros) {
        this.nome = nome;
        this.password = password;
        this.carros = carros;
    }

    public Cliente() {
        this.nome = "";
        this.password = "";
        this.carros = new ArrayList<>();
    }
    
    public Cliente(Cliente umCliente){
        this.nome = umCliente.getNome();
        this.password = umCliente.getPassword();
        this.carros = umCliente.getCarros();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        
        Cliente other = (Cliente) obj;
        
        if (this.nome.equals(other.nome) && this.password.equals(other.password) 
            && this.carros.equals(other.carros)) {
            return true;
        }
        return false;
    }
    
}
