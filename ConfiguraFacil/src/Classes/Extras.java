package Classes;

import java.util.List;

public class Extras extends Peca{

    public Extras(int quantidade, String nome, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
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
    
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}