package Classes;
/**
 * Classe do funcionario, ator que muda o estado das pecas e dos carros
 * 
 */
public class Funcionario extends Utilizador{
    /**Construtor parametrizado do funcionario*/
    public Funcionario(String nome, String password, String email) {
        super(nome, password, email);
    }
    /**Construtor vazio do funcionario*/
    public Funcionario() {
        super();
    }
    /**Construtor que recebe um funcionario*/
    public Funcionario(Funcionario umFuncionario){
        super(umFuncionario);        
    }
    /**
     * Metodo que faz uma copia do funcionario
     * 
     * @return um funcionario com valor das variaveis de instancia mas com apontador diferente
     */
    @Override
    public Funcionario clone(){
        return new Funcionario(this);
    }
    /**
     * Metodo que retorna o hashcode do funcionario
     * 
     * @return hashcode do funcionario
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Metodo que verifica se dois funcionarios sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o funcionario
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
        
        Funcionario other = (Funcionario) obj;
        return (super.equals(other));
    }
    /**
     * Metodo que transforma um funcionario numa string
     * 
     * @return a string do funcionario
     */
    @Override
    public String toString() {
        return super.toString();
    }
}