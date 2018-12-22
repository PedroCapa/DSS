package Classes;

import java.util.List;

public class Cor extends Peca{

    public Cor(int quantidade, String nome, float preco, List<String> obrigatorias, List<String> incompativeis) {
        super(quantidade, nome, preco, obrigatorias, incompativeis);
    }

    public Cor() {
        super();
    }

    public Cor(Peca umaPeca) {
        super(umaPeca);
    }
    
    public Cor clone(){
        return new Cor(this);
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