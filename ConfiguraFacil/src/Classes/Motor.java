package Classes;

import java.util.List;

public class Motor extends Peca{

    public Motor(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }

    public Motor() {
        super();
    }

    public Motor(Peca umaPeca) {
        super(umaPeca);
    }
    
    public Motor clone(){
        return new Motor(this);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
        
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
