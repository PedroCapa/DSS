package Classes;

import java.util.Objects;
/**
 * Classe abstrata que tem como subclasse o funcionario e o cliente
 * 
 */
public abstract class Utilizador{
    /** Nome do utilizador*/
    private String nome;
    /**Email do utilizador que será usado para identificar, é a chave primária*/
    private String email;
    /**Password da conta de forma a garantir a segurança de cada conta*/
    private String password;
    /**Construtor com todas as variaveis de instancia do utilizador*/
    public Utilizador(String nome, String password, String email) {
        this.nome = nome;
        this.password = password;
        this.email = email;
    }
    /**Construtor vazio do utilizador*/
    public Utilizador(){
        this.nome = "";
        this.password = "";
        this.email = "";
    }
    /** Construtor com um utilizador*/
    public Utilizador(Utilizador umUtilizador){
        this.nome = umUtilizador.getNome();
        this.password = umUtilizador.getPassword();
        this.email = umUtilizador.getEmail();
    }
    /**
     * Metodo que retorna o nome do individuo
     * 
     * @return o nome do individuo
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo que altera o nome do utilizador
     * 
     * @param nome Nome que irá ser alterado o utilizador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que retorna a password do utilizador
     * 
     * @return password do utilizazdor
     */
    public String getPassword() {
        return password;
    }
    /**
     * Metodo que altera password do utilizador
     * 
     * @param password Nova password do utilizador
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Metodo que retorna o email do utilizador
     * 
     * @return o email do utilizador
     */
    public String getEmail() {
        return email;
    }
    /**
     * Metodo que altera o email do utilizador
     * 
     * @param email Novo email do utilizador
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que retorna o hashcode do utilizador
     * 
     * @return hashcode do utilizador
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.email);
    }
    /**
     * Metodo que verifica se dois utilizadores sao iguais
     * 
     * @param obj Objeto que ira ser comparado com o utilizador
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
        
        Utilizador other = (Utilizador) obj;
        return (this.nome.equals(other.getNome()) && this.password.equals(other.getPassword()) 
                && this.email.equals(other.getEmail()));
    }
    /**
     * Metodo que transforma um utilizador numa string
     * 
     * @return a string do utilizador
     */
    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", email=" + email + ", password=" + password + '}';
    }
    /**
     * Metodo que verifica se a password que o utilizador inseriu e a correta
     * 
     * @param pass Password inserido pelo utilizador
     * 
     * @return true caso a password corresponda a password do utilizador 0 caso contrario
     */
    public boolean validaCredenciais(String pass){
        boolean b;
        b = pass.equals(this.password);
        return b;
    }
}