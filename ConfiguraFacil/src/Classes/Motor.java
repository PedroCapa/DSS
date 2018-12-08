package Classes;

import java.util.List;

public class Motor extends Peca{

    public Motor(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
    }

    public Motor() {
        super();
    }

    public Motor(Peca umaPeca) {
        super(umaPeca);
    }    
}
