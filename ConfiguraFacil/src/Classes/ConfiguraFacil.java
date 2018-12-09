package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class ConfiguraFacil {

   private Map<String, Utilizador> clientes;
   private Map<String, Carro> carros;
   private List<Modelo> modelos;
   private List<Peca> pecas;
   private List<Carro> espera;
   private List<Carro> producao;

    public ConfiguraFacil(Map<String, Utilizador> clientes, Map<String, Carro> carros, List<Modelo> modelos, List<Peca> pecas, List<Carro> espera, List<Carro> producao) {
        this.clientes = new HashMap<>(clientes);
        this.carros = new HashMap<>(carros);
        this.modelos = new ArrayList<>(modelos);
        this.pecas = new ArrayList<>(pecas);
        this.espera = new ArrayList<>(espera);
        this.producao = new ArrayList<>(producao);
    }

    public ConfiguraFacil() {
        this.clientes = new HashMap<>();
        this.carros = new HashMap<>();
        this.modelos = new ArrayList<>();
        this.pecas = new ArrayList<>();
        this.espera = new ArrayList<>();
        this.producao = new ArrayList<>();
    }
    
    public ConfiguraFacil(ConfiguraFacil umConfiguraFacil) {
        this.clientes = umConfiguraFacil.getClientes();
        this.carros = umConfiguraFacil.getCarros();
        this.modelos = umConfiguraFacil.getModelos();
        this.pecas = umConfiguraFacil.getPecas();
        this.espera = umConfiguraFacil.getEspera();
        this.producao = umConfiguraFacil.getProducao();
    }

    public Map<String, Utilizador> getClientes() {
        return new HashMap<>(this.clientes);
    }

    public void setClientes(Map<String, Utilizador> clientes) {
        this.clientes = new HashMap<>(clientes);
    }

    public Map<String, Carro> getCarros() {
        return new HashMap<>(this.carros);
    }

    public void setCarros(Map<String, Carro> carros) {
        this.carros = new HashMap<>(carros);
    }

    public List<Modelo> getModelos() {
        return new ArrayList<>(this.modelos);
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = new ArrayList<>(modelos);
    }

    public List<Peca> getPecas() {
        return new ArrayList<>(this.pecas);
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = new ArrayList<>(pecas);
    }

    public List<Carro> getEspera() {
        return new ArrayList<>(this.espera);
    }

    public void setEspera(List<Carro> espera) {
        this.espera = new ArrayList<>(espera);
    }

    public List<Carro> getProducao() {
        return new ArrayList<>(this.producao);
    }

    public void setProducao(List<Carro> producao) {
        this.producao = new ArrayList<>(producao);
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        ConfiguraFacil other = (ConfiguraFacil) obj;
        return (this.clientes.equals(other.getClientes()) && this.carros.equals(other.getCarros()) 
                && this.modelos.equals(other.getModelos()) && this.pecas.equals(other.getPecas()) 
                && this.espera.equals(other.getEspera()) && this.producao.equals(other.getProducao()));
        }   
}
