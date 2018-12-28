package Classes;

import java.util.List;
import java.util.ArrayList;
/**
 * Classe cliente que e uma extensão dos utilizadores com uma lista de carros
 * 
 */
public class Cliente extends Utilizador{
    /**Lista de carros comprados pelo cliente*/
    private List<String> carros;
    /**Construtor parametrizado do cliente*/
    public Cliente(String nome, String password, String email, List<String> carros) {
        super(nome, password, email);
        this.carros = new ArrayList<>(carros);
    }
    /**Construtor parametrizado do cliente*/
    public Cliente(String nome, String password, String email){
        super(nome, password, email);
        this.carros = new ArrayList<>();
    }
    /**Construtor vazio do cliente*/
    public Cliente() {
        super();
        this.carros = new ArrayList<>();
    }
    /**Construtor de um Cliente*/
    public Cliente(Cliente umCliente){
        super(umCliente);
        this.carros = umCliente.getCarros();
    }
    /**
     * Metod que retorna a lista de carros de um cliente
     * 
     * @return a lista de carros comprados de um cliente
     */
    public List<String> getCarros() {
        return new ArrayList<>(this.carros);
    }
    /**
     * Metodo que altera a lista de carros comprados de um utilizador
     * 
     * @param Carros Nova lista de carros comprados pelo utilizador
     */
    public void setCarros(List<String> Carros) {
        this.carros = new ArrayList<>(carros);
    }
    /**
     * Metodo que faz uma copia do cliente
     * 
     * @return um clietne com valor das variaveis de instancia mas com apontador diferente
     */
    @Override
    public Cliente clone(){
        return new Cliente(this);
    }
    /**
     * Metodo que retorna o hashcode do cliente
     * 
     * @return hashcode do cliente
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se dois clientes sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o cliente
     * 
     * @return true caso sejam iguais false caso contrario
     */
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
    /**
     * Metodo que transforma um cliente numa string
     * 
     * @return a string do pacote
     */
    @Override
    public String toString() {
        return "Cliente{" + "carros=" + carros + '}' + super.toString();
    }
    /**
     * Metodo que adiciona um carro comprado ao cliente
     * 
     * @param s 
     */
    public void addCarro(String s){
        this.carros.add(s);
    }
}