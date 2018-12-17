package Classes;

import java.util.List;

public class Estofos extends Peca{

    public Estofos(int quantidade, String nome, String id, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, id, obrigatorias, incompativeis);
    }

    public Estofos() {
        super();
    }

    public Estofos(Peca umaPeca) {
        super(umaPeca);
    }   
    
    public Estofos clone(){
        return new Estofos(this);
    }
    
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
