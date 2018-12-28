package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que contem a lista de pecas associada a uma opcao
 * 
 */
public class Pacote {
    /**Nome do pacote*/
    private String nome;
    /**Desconto nos precos das pecas no caso da escolha de desconto*/
    private float desconto;
    /**Nome das pecas que estao incluidas no pacote*/
    private List<String> pecas;
    /**Construtor parametrizado do pacote*/
    public Pacote(String nome, float desconto, List<String> pecas) {
        this.nome = nome;
        this.desconto = desconto;
        this.pecas = new ArrayList<>(pecas);
    }
    /**Construtor vazio do pacote*/
    public Pacote(){
        this.nome = "";
        this.desconto = 0;
        this.pecas = new ArrayList<>();
    }
    /**Construtor que recebe como argumento um pacote*/
    public Pacote(Pacote umPacote){
        this.nome = umPacote.getNome();
        this.desconto = umPacote.getDesconto();
        this.pecas = umPacote.getPecas();
    }
    /**
     * Metod que retorna o nome do pacote 
     * 
     * @return o nome do pacote
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo que altera o nome do pacote
     * 
     * @param nome Novo nome do pacote
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que retorna o desconto do pacote
     * 
     * @return o desconto de pacote
     */
    public float getDesconto() {
        return desconto;
    }
    /**
     * Metodo que altera o desconto do pacote
     * 
     * @param desconto novo desconto do pacote
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    /**
     * Metodo que retorna o nome das pecas do pacote
     * 
     * @return o nome das pecas do pacote
     */
    public List<String> getPecas() {
        return new ArrayList<>(this.pecas);
    }
    /**
     * Metodo que altera o nome das pecas associadas ao pacote
     * 
     * @param pecas novas pecas associadas ao pacote
     */
    public void setPecas(List<String> pecas) {
        this.pecas = new ArrayList<>(pecas);
    }
    /**
     * Metodo que faz uma copia do pacote
     * 
     * @return um pacote com valor das variaveis de instancia mas com apontador diferente
     */
    @Override
    public Pacote clone(){
        return new Pacote(this);
    }
    /**
     * Metodo que retorna o hashcode do pacote
     * 
     * @return hashcode do pacote
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome);
    }
    /**
     * Metodo que verifica se dois pacotes sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o pacote
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

        Pacote other = (Pacote) obj;
        return (this.nome.equals(other.getNome()) && this.desconto == other.getDesconto() 
                && this.pecas.equals(other.getPecas()));
    }
    /**
     * Metodo que transforma um pacote numa string
     * 
     * @return a string do pacote
     */
    @Override
    public String toString() {
        return "Pacote{" + "nome=" + nome + ", desconto=" + desconto + ", pecas=" + pecas + '}';
    }
    /**
     * Metodo que adiciona uma peca a lista de pecas associadas ao pacote
     * 
     * @param peca Peca que e adicionada a lista de pecas associadas ao pacote
     */
    public void addPeca(String peca){
        this.pecas.add(peca);
    }
}