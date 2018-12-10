package Classes;

import java.util.List;

public class Cor extends Peca{

    public Cor(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
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

    public boolean equals(Object o){
        return super.equals(o);
    }
}