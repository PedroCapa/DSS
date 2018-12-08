package Classes;

public class Funcionario extends Utilizador{
    
    private int id;

    public Funcionario(String nome, String password) {
        super(nome, password);
    }

    public Funcionario() {
        super();
    }
    
    public Funcionario(Funcionario umFuncionario){
        super(umFuncionario);
        this.id = umFuncionario.getId();
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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
        
        return (super.equals(other) && this.id == other.getId());
    }
}