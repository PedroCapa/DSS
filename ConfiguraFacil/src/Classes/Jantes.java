package Classes;

import java.util.List;

public class Jantes extends Peca{

    public Jantes(int quantidade, String nome, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
    }

    public Jantes() {
        super();
    }

    public Jantes(Peca umaPeca) {
        super(umaPeca);
    }
    
    public Jantes clone(){
        return new Jantes(this);
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