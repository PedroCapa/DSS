package Classes;

import java.util.List;

public class Extras extends Peca{

    public Extras(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
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
    
    public boolean equals(Object o){
        return super.equals(o);
    }
}