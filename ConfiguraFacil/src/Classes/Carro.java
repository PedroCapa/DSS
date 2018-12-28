package Classes;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;
/**
 * Classe que contem informacao do carro
 * 
 */
public class Carro {
    /**Modelo do carro*/
    private Modelo modelo;
    /**Identificador do carro*/
    private String id;
    /**Estado carro. Em espera, em producao ou pronto*/
    private int estado;
    /**Lista dos nomes das pecas dos carros*/
    private List<String> pecas;
    /**Custo total do carro*/
    private float custo;
    /**Data da compra do carro*/
    private LocalDate data;
    /**Lista de pecas em falta do carro*/
    private List<String> falta;
    /**Email do cliente que pertence o carro*/
    private String cliente;
    /**Construtor parametrizado do carro*/
    public Carro(Modelo modelo, String id, int estado, List<String> pecas, float custo, LocalDate data, List<String> falta, String cliente) {
        this.modelo = modelo;
        this.pecas = new ArrayList<>();
        pecas.forEach((s) -> {
            this.pecas.add(s);
        });
        this.id = id;
        this.estado = estado;
        this.custo = custo;
        this.data = data;
        this.falta = new ArrayList<>();
        falta.forEach((s) -> {
            this.falta.add(s);
        });
        this.cliente = cliente;
    }
    /**Construtor vazio do carro*/
    public Carro() {
        this.modelo = new Modelo();
        this.pecas = new ArrayList<>();
        this.custo = 0;
        this.id = "";
        this.estado = 0;
        this.data = LocalDate.now();
        this.falta = new ArrayList<>();
        this.cliente = null;
    }
    /**Construtor de um Carro*/
    public Carro(Carro umCarro){
        this.modelo = umCarro.getModelo();
        this.id = umCarro.getId();
        this.estado = umCarro.getEstado();
        this.pecas = umCarro.getPecas();
        this.custo = umCarro.getCusto();
        this.data = umCarro.getData();
        this.falta = umCarro.getFalta();
        this.cliente = umCarro.getCliente();
    }
    /**
     * Metodo que retorna o modelo do carro
     * 
     * @return modelo do carros
     */
    public Modelo getModelo() {
        return this.modelo;
    }
    /***
     * Metodo que altera o modelo do carro
     * 
     * @param modelo novo modelo do carro
     */
    public void setModelo(Modelo modelo) {
        this.modelo = new Modelo(modelo);
    }
    /**
     * Metodo que retorna o Id do carro
     * 
     * @return id do carro
     */
    public String getId() {
        return this.id;
    }
    /**
     * Metod que altera o id do carro
     * 
     * @param id nodo id do carro
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Metodo que retorna o estado do carros
     * 
     * @return o estado do carro
     */
    public int getEstado() {
        return this.estado;
    }
    /**
     * Metodo que altera o estado do carro
     * 
     * @param estado novo estado do carro
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    /**
     * Metodo que retorna a lista de pecas do carro
     * 
     * @return a lista de pecas do carro
     */
    public List<String> getPecas() {
        return new ArrayList<>(this.pecas);
    }
    /**
     * Metodo que altera a lista de pecas do carro
     * 
     * @param pecas novas pecas do carro
     */
    public void setPecas(List<String> pecas) {
        this.pecas = new ArrayList<>(pecas);
    }
    /**
     * Metodo que retorna o custo do carro
     * 
     * @return o custo do carro
     */
    public float getCusto(){
        return this.custo;
    }
    /**
     * Metodo que altera o custo do carro
     * 
     * @param custo novo custo do carro
     */
    public void setCusto(float custo){
        this.custo = custo;
    }
    /**
     * Metodo que retorna a data da compra do carro
     * 
     * @return a data da compra do carro
     */
    public LocalDate getData() {
        return this.data;
    }
    /**
     * Metodo que altera a data de compra do carro
     * 
     * @param data data da compra do carro
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    /**
     * Metodo que retorna a lista de pecas em falta do carro
     * 
     * @return 
     */
    public List<String> getFalta() {
        return new ArrayList<>(this.falta);
    }
    /**
     * Metodo que altera a lista de pecas em falta do carro
     * 
     * @param falta nova lista de pecas em falta
     */
    public void setFalta(List<String> falta) {
       this.falta = new ArrayList<>(falta);
    }
    /**
     * Metodo que retorna o email do cliente que comprou o carro
     * 
     * @return o email do cliente que comprou o carro
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * Metodo que altera o email do cliente que comprou o carro
     * 
     * @param cliente novo cliente que comprou o carro
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo que retorna o hashcode do carro
     * 
     * @return hashcode do carro
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
    /**
     * Metodo que faz uma copia do carro
     * 
     * @return um carro com valor das variaveis de instancia mas com apontador diferente
     */
    @Override
    public Carro clone(){
        return new Carro(this);
    }
    /**
     * Metodo que verifica se dois carros sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o carro
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
        
        Carro other = (Carro) obj;
        return (this.pecas.equals(other.getPecas())  && this.custo == other.getCusto() && this.id.equals(other.getId())
                && this.estado == other.getEstado() && this.data.equals(other.getData()) && this.cliente.equals(other.getCliente())
                && this.falta.equals(other.getFalta()) && this.modelo.equals(other.getModelo()));
    }
    /**
     * Metodo que transforma um carro numa string
     * 
     * @return a string do carro
     */
    @Override
    public String toString() {
        return "Carro{" + "modelo=" + modelo + ", id=" + id + ", estado=" + estado + ", pecas=" + pecas + ", custo=" + custo + ", data=" + data + ", falta=" + falta + '}';
    }
    /**
     * Metodo que altera o estado do carro para pronto
     * 
     */
    public void carroPronto(){
        this.estado = 2;
    }
    /**
     * Metodo que remove uma peca das pecas em falta 
     * 
     * @param nome peca que sera removida
     * 
     * @return true caso seja removido 0 caso contrario
     */
    public boolean pecaEmFalta(String nome){
        boolean flag;
        if(flag = this.falta.contains(nome)){
           this.falta.remove(nome);
           this.pecas.add(nome);            
        }
        if(this.falta.isEmpty())
            this.estado = 1;
        return flag;
    }
    /**
     * Metodo que adiciona uma peca ao carro
     * 
     * @param s peca que sera adicionada
     */
    public void addPecaCarro(String s){
        this.pecas.add(s);
    }
    /**
     * Metodo que adiciona uma peca em falta ao carro
     * 
     * @param s peca que sera adicionada as pecas em falta do carro
     */
    public void addFaltaCarro(String s){
        this.falta.add(s);
    }
    /**
     * Metodo que verifica se o carro esta em producao 
     * 
     * @return true caso estado seja 1 false caso contrario
     */
    public boolean emProducao(){
        return (this.estado == 1);
    }
}