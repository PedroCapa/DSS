package Classes;

public class Funcionario extends Utilizador{

    public Funcionario(String nome, String password, String email) {
        super(nome, password, email);
    }

    public Funcionario() {
        super();
    }
    
    public Funcionario(Funcionario umFuncionario){
        super(umFuncionario);
    }
    
    @Override
    public Funcionario clone(){
        return new Funcionario(this);
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
        return (super.equals(other));
    }
}