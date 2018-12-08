
package configurafacil;

import java.util.Objects;

public class Funcionario {
    
    private String nome;
    private String password;

    public Funcionario(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public Funcionario() {
        this.nome = "";
        this.password = "";
    }
    
    public Funcionario(Funcionario umCliente){
        this.nome = umCliente.getNome();
        this.password = umCliente.getPassword();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Funcionario other = (Funcionario) obj;
        
        if (this.nome.equals(other.nome) && this.password.equals(other.password)) {
            return true;
        }
        return false;
    }
}
