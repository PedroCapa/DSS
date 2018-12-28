package Classes;

import java.util.List;
/**
 * Classe do tipo jantes que e o tipo de peca
 */
public class Jantes extends Peca{
    /**Construtor parametrizado das jantes*/
    public Jantes(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }
    /**Construtor vazio das jantes*/
    public Jantes() {
        super();
    }
    /**Construtor com uma jante*/
    public Jantes(Jantes umaJantes) {
        super(umaJantes);
    }
    /**
     * Metodo que faz uma copia das jantes
     * 
     * @return uma jante com valor das variaveis de instancia mas com apontador diferente
     */
    public Jantes clone(){
        return new Jantes(this);
    }
    /**
     * Metodo que retorna o hashcode das jantes
     * 
     * @return hashcode das jantes
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se duas jantes sao iguais
     * 
     * @param obj Objeto que ira ser comparado com a jante
     * 
     * @return true caso sejam iguais false caso contrario
     */
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    /**
     * Metodo que transforma uma jante numa string
     * 
     * @return a string das jantes
     */
    @Override
    public String toString() {
        return super.toString();
    }    
}