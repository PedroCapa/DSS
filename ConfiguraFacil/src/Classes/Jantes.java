package Classes;

import java.util.List;

public class Jantes extends Peca{

    public Jantes(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
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
    
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}