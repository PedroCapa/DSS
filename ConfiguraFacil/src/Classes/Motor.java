package Classes;

import java.util.List;
/**
 * Classe do tipo motor que e o tipo de peca
 */
public class Motor extends Peca{
    /**Construtor parametrizado do motor*/
    public Motor(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }
    /**Construtor vazio do motor*/
    public Motor() {
        super();
    }
    /**Construtor com um motor*/
    public Motor(Motor umMotor) {
        super(umMotor);
    }
    /**
     * Metodo que faz uma copia do motor
     * 
     * @return um motor com valor das variaveis de instancia mas com apontador diferente
     */
    public Motor clone(){
        return new Motor(this);
    }
    /**
     * Metodo que retorna o hashcode do motor
     * 
     * @return hashcode do motor
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se dois motores sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o motor
     * 
     * @return true caso sejam iguais false caso contrario
     */
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    /**
     * Metodo que transforma um motor numa string
     * 
     * @return a string do motor
     */
    @Override
    public String toString() {
        return super.toString();
    }    
}
