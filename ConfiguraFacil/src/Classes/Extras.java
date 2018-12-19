package Classes;

import java.util.List;

public class Extras extends Peca{

    public Extras(int quantidade, String nome, String id, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, id, obrigatorias, incompativeis);
    }

    public Extras() {
        super();
    }

    public Extras(Peca umaPeca) {
        super(umaPeca);
    }
    
    public Extras clone(){
        return new Extras(this);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}