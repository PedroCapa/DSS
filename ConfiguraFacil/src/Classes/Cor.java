package Classes;

import java.util.List;
/**
 * Classe do tipo cor que e o tipo de peca
 */
public class Cor extends Peca{
    /**Construtor parametrizado da cor*/
    public Cor(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }
    /**Construtor vazio da cor*/
    public Cor() {
        super();
    }
    /**Construtor com uma cor*/
    public Cor(Cor umaCor) {
        super(umaCor);
    }
    /**
     * Metodo que faz uma copia da cor
     * 
     * @return uma cor com valor das variaveis de instancia mas com apontador diferente
     */
    public Cor clone(){
        return new Cor(this);
    }
    /**
     * Metodo que retorna o hashcode da cor
     * 
     * @return hashcode da cor
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se duas cores sao iguais
     * 
     * @param obj Objeto que ira ser comparado com a cor
     * 
     * @return true caso sejam iguais false caso contrario
     */
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    /**
     * Metodo que transforma uma cor numa string
     * 
     * @return a string da cor
     */
    @Override
    public String toString() {
        return super.toString();
    }
}