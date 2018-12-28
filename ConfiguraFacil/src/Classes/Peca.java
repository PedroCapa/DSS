package Classes;

import Exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Classe abstrata que tem como subclasse os diversos tipos de pecas
 * 
 */
public abstract class Peca {
    /**Quantidade disponivel do produto*/
    private int quantidade;
    /**Nome da peca*/
    private String nome;
    /**Custo da pecas*/
    private float preco;
    /**Lista dos nomes das pecas obrigatorias*/
    private List<String> obrigatorias;
    /**Lista dos nomes das pecas incompativeis*/
    private List<String> incompativeis;
    /**Construtor parametrizado da peca*/
    public Peca(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.obrigatorias = new ArrayList<>(obrigatorias);
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    /**Construtor vazio da pecas*/
    public Peca() {
        this.quantidade = 0;
        this.nome = "";
        this.preco = 0;
        this.obrigatorias = new ArrayList<>();
        this.incompativeis = new ArrayList<>();
    }
    /** Construtor com uma peca*/
    public Peca(Peca umaPeca){
        this.quantidade = umaPeca.getQuantidade();
        this.nome = umaPeca.getNome();
        this.preco = umaPeca.getPreco();
        this.obrigatorias = umaPeca.getObrigatorias();
        this.incompativeis = umaPeca.getIncompativeis();        
    }
    /**
     * Metodo que retorna a quantidade da peca
     * 
     * @return a quantidade disponivel da peca
     */
    public int getQuantidade() {
        return quantidade;
    }
    /**
     * Metodo que altera a quantidade da peca
     * 
     * @param quantidade Nova quantidade da peca
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Metodo que retorna o nome da peca
     * 
     * @return nome da peca
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo que altera o nome da peca
     * 
     * @param nome Novo nome da peca
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que retorna o preco da peca
     * 
     * @return O preco da peca
     */
    public float getPreco() {
        return preco;
    }
    /**
     * Metodo que altera o preco da peca
     * 
     * @param preco Novo preco da peca
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    /**
     * Metodo que retorna a lista de pecas obrigarias da peca
     * 
     * @return as pecas obrigarorias
     */
    public List<String> getObrigatorias() {
        return new ArrayList<>(this.obrigatorias);
    }
    /**
     * Metodo que altera a lista de pecas obrigatorias
     * 
     * @param obrigatorias Nova lista de pecas obrigatorias 
     */
    public void setObrigatorias(List<String> obrigatorias) {
        this.obrigatorias = new ArrayList<>(obrigatorias);
    }
    /**
     * Metodo que retorna a lista de pecas incompativeis
     * 
     * @return pecas incompativeis
     */
    public List<String> getIncompativeis() {
        return new ArrayList<>(this.incompativeis);
    }
    /**
     * Metodo que altera a lista de pecas incompativeis
     * 
     * @param incompativeis nova lista de nomes das pecas incompativeis
     */
    public void setIncompativeis(List<String> incompativeis) {
        this.incompativeis = new ArrayList<>(incompativeis);
    }
    /**
     * Metodo que retorna o hashcode da peca
     * 
     * @return hashcode da peca
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome);
    }
    /**
     * Metodo que transforma uma peca numa string
     * 
     * @return a string da peca
     */
    @Override
    public String toString() {
        return "Peca{" + "quantidade=" + quantidade + ", nome=" + nome + ", preco=" + preco + ", obrigatorias=" + obrigatorias + ", incompativeis=" + incompativeis + '}';
    }
    /**
     * Metodo que verifica se duas pecas sao iguais
     * 
     * @param obj Objeto que ira ser comparado com a peca
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
        
        Peca other = (Peca) obj;
        return (this.quantidade != other.quantidade && this.nome.equals(other.nome) && this.preco == other.getPreco()
            && this.obrigatorias.equals(other.obrigatorias) && this.incompativeis.equals(other.getIncompativeis()));
    }
    /**
     * Metodo que adiciona uma peca proibida a lista de proibidas
     * 
     * @param p nome da peca que se pretende adicionar
     * 
     * @throws PecaJaExisteException Caso essa peça ja esteja nas proibidas
     */
    public void addProibida(String p)throws PecaJaExisteException{
        if(this.incompativeis.contains(p))
            throw new PecaJaExisteException("Essa peca ja era considerada incompativel");
        this.incompativeis.add(p);
    }
    /**
     * Metodo que adiciona uma peca obrigatoria a lista de pecas obrigatorias
     * 
     * @param p
     * 
     * @throws PecaJaExisteException 
     */
    public void addObrigatoria(String p)throws PecaJaExisteException{
        if(this.incompativeis.contains(p))
            throw new PecaJaExisteException("Essa peca ja era considerada incompativel");
        this.incompativeis.add(p);
    }
    /**
     * Metodo que adiciona stock
     * 
     * @param numero Quantidade que ira ser aumentada o numero de pecas
     */
    public void addStock(int numero){
        this.quantidade = this.quantidade + numero;
    }
    /**
     * Metodo que decrementa a quantidade do produto
     * 
     */
    public void reduzStock(){
        this.quantidade--;
    }
}