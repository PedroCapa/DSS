package Classes;

import java.util.List;

public class Estofos extends Peca{

    public Estofos(int quantidade, String nome, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
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
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
