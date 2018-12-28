package Classes;

import java.util.List;
/**
 * Classe do tipo estofos que e o tipo de peca
 */
public class Estofos extends Peca{
    /**Construtor parametrizado do estofo*/
    public Estofos(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }
    /**Construtor vazio do estofo*/
    public Estofos() {
        super();
    }
    /**Construtor com um estofo*/
    public Estofos(Peca umaPeca) {
        super(umaPeca);
    }   
    /**
     * Metodo que faz uma copia do estofo
     * 
     * @return uns estofos com valor das variaveis de instancia mas com apontador diferente
     */
    public Estofos clone(){
        return new Estofos(this);
    }
    /**
     * Metodo que retorna o hashcode do estofo
     * 
     * @return hashcode do estofo
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se dois estofos sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o estofo
     * 
     * @return true caso sejam iguais false caso contrario
     */
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    /**
     * Metodo que transforma um estofo numa string
     * 
     * @return a string dos estofos
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
