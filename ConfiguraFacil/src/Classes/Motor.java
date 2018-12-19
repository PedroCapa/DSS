package Classes;

import java.util.List;
import java.util.Objects;

public class Motor extends Peca{

    public Motor(int quantidade, String nome, String id, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, id, obrigatorias, incompativeis);
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
        
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
