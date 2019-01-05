package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Classe que representa o modelo do carro 
 * 
 */
public class Modelo {
    /**Nome do modelo*/
    private String nome;
    /**Lista de pacotes do modelo*/
    private List<Pacote> pacotes;
    /**Custo base do pacote*/
    private float custoBase;
    /**Construtor parametrizado do modelo*/
    public Modelo(String nome, List<Pacote> pacotes, float custoBase) {
        this.nome = nome;
        this.pacotes = new ArrayList<>(pacotes);
        this.custoBase = custoBase;
    }
    /**Construtor vazio do modelo*/
    public Modelo(){
        this.nome = "";
        this.pacotes = new ArrayList<>();
        this.custoBase = 0;
    }
    /**Construtor com um modelo*/
    public Modelo(Modelo umModelo){
        this.nome = umModelo.getNome();
        this.pacotes = umModelo.getPacotes();
        this.custoBase = umModelo.getCustoBase();
    }
    /**
     * Metodo que retorna o nome do modelo
     * 
     * @return o nome do modelo
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo que altera o nome do modelo
     * 
     * @param nome Novo nome do modelo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que retorna a lista de pacotes do modelo
     * 
     * @return a lista de paoctes do modelo
     */
    public List<Pacote> getPacotes() {
        return new ArrayList<>(this.pacotes);
    }
    /**
     * Metodo que altera a lista de pacotes do modelo
     * 
     * @param pacotes Lista de pacotes do modelo
     */
    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = new ArrayList<>(pacotes);
    }
    /**
     * Metodo que retorna o custo base do modelo
     * 
     * @return custo base do modelo
     */
    public float getCustoBase() {
        return custoBase;
    }
    /**
     * Metod que altera o custo base do modelo
     * 
     * @param custoBase novo custo base do modelo
     */
    public void setCustoBase(float custoBase) {
        this.custoBase = custoBase;
    }
    /**
     * Metodo que faz uma copia do modelo
     * 
     * @return um modelo com valor das variaveis de instancia mas com apontador diferente
     */
    @Override
    public Modelo clone(){
        return new Modelo(this);
    }
    /**
     * Metodo que retorna o hashcode do modelo
     * 
     * @return hashcode do modelo
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome);
    }
    /**
     * Metodo que verifica se dois modelos sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o modelo
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
        
        Modelo other = (Modelo) obj;
        return (this.custoBase == other.getCustoBase() && this.nome.equals(other.getNome()) 
            && this.pacotes.equals(other.getPacotes()));
    }
    /**
     * Metodo que transforma um modelo numa string
     * 
     * @return a string do modelo
     */
    @Override
    public String toString() {
        return "Modelo{" + "nome=" + nome + ", pacotes=" + pacotes + ", custoBase=" + custoBase + '}';
    }
}
