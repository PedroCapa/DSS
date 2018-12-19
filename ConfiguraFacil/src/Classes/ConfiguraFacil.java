package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ConfiguraFacil {

   private Map<String, Utilizador> utilizadores;
   private Map<String, Carro> carros;
   private Map<String, Modelo> modelos;
   private Map<String, Peca> pecas;
   private Map<String, Pacote> pacotes;
   private List<Carro> producao;

    public ConfiguraFacil(Map<String, Utilizador> utilizadores, Map<String, Carro> carros, Map<String, Modelo> modelos, Map<String, Peca> pecas, Map<String, Pacote> pacotes, List<Carro> producao) {
        this.utilizadores = new HashMap<>(utilizadores);
        this.carros = new HashMap<>(carros);
        this.modelos = new HashMap<>(modelos);
        this.pecas = new HashMap<>(pecas);
        this.pacotes = new HashMap<>(pacotes);
        this.producao = new ArrayList<>(producao);
    }

    public ConfiguraFacil() {
        this.utilizadores = new HashMap<>();
        this.carros = new HashMap<>();
        this.modelos = new HashMap<>();
        this.pecas = new HashMap<>();
        this.pacotes = new HashMap<>();
        this.producao = new ArrayList<>();
    }
    
    public ConfiguraFacil(ConfiguraFacil umConfiguraFacil) {
        this.utilizadores = umConfiguraFacil.getClientes();
        this.carros = umConfiguraFacil.getCarros();
        this.modelos = umConfiguraFacil.getModelos();
        this.pecas = umConfiguraFacil.getPecas();
        this.pacotes = umConfiguraFacil.getPacotes();
        this.producao = umConfiguraFacil.getProducao();
    }

    public Map<String, Utilizador> getClientes() {
        return new HashMap<>(this.utilizadores);
    }

    public void setClientes(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new HashMap<>(utilizadores);
    }

    public Map<String, Carro> getCarros() {
        return new HashMap<>(this.carros);
    }

    public void setCarros(Map<String, Carro> carros) {
        this.carros = new HashMap<>(carros);
    }

    public Map<String, Modelo> getModelos() {
        return new HashMap<>(this.modelos);
    }

    public void setModelos(Map<String, Modelo> modelos) {
        this.modelos = new HashMap<>(modelos);
    }

    public Map<String, Peca> getPecas() {
        return new HashMap<>(this.pecas);
    }

    public void setPecas(Map<String, Peca> pecas) {
        this.pecas = new HashMap<>(pecas);
    }

    public Map<String, Pacote> getPacotes() {
       return new HashMap<>(this.pacotes);
    }

    public void setPacotes(Map<String, Pacote> pacotes) {
         this.pacotes = new HashMap<>(pacotes);
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
        return (this.utilizadores.equals(other.getClientes()) && this.carros.equals(other.getCarros()) 
                && this.modelos.equals(other.getModelos()) && this.pecas.equals(other.getPecas()) 
                && this.pacotes.equals(other.getPacotes()) && this.producao.equals(other.getProducao()));
        }
    
    public void registaCliente(String nome, String password, String email)throws UtilizadorJaRegistadoException{
        if(this.utilizadores.containsKey(email)){
            throw new UtilizadorJaRegistadoException("Ja existe um utilizador com essa conta de email registado");
        }
        Cliente c = new Cliente(nome, password, email);
        this.utilizadores.put(email, c);
    }
    
    public Utilizador fazerlogin(String email, String password) throws UtilizadorNaoExisteException, PasswordIncorretaException{
        if(!utilizadores.containsKey(email))
            throw new UtilizadorNaoExisteException("Utilizador não existe");
        Utilizador u = utilizadores.get(email);
        
        if(u.validaCredenciais(email))
            throw new PasswordIncorretaException("Palavra passe está incorreta");        
        return u;
    }
} 

class PasswordIncorretaException extends Exception{
	public PasswordIncorretaException(){
		super();
	}

	public PasswordIncorretaException(String s){
		super(s);
	}
}

class UtilizadorNaoExisteException extends Exception{
	public UtilizadorNaoExisteException(){
		super();
	}

	public UtilizadorNaoExisteException(String s){
		super(s);
	}
}

class UtilizadorJaRegistadoException extends Exception{
	public UtilizadorJaRegistadoException(){
		super();
	}

	public UtilizadorJaRegistadoException(String s){
		super(s);
	}
}

