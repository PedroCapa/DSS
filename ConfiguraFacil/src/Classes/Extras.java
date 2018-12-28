package Classes;

import java.util.List;
/**
 * Classe do tipo Extras que e o tipo de peca
 */
public class Extras extends Peca{
    /**Construtor parametrizado dos extras*/
    public Extras(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }
    /**Construtor vazio do motor*/
    public Extras() {
        super();
    }
    /**Construtor com um extra*/
    public Extras(Peca umaPeca) {
        super(umaPeca);
    }
    /**
     * Metodo que faz uma copia do extra
     * 
     * @return um extra com valor das variaveis de instancia mas com apontador diferente
     */
    public Extras clone(){
        return new Extras(this);
    }
    /**
     * Metodo que retorna o hashcode do extra
     * 
     * @return hashcode do extra
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se dois extras sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o extra
     * 
     * @return true caso sejam iguais false caso contrario
     */
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    /**
     * Metodo que transforma um extra numa string
     * 
     * @return a string do extra
     */
    @Override
    public String toString() {
        return super.toString();
    }
}