

package configurafacil;

import java.util.List;


public class Estofos extends Peca{

    public Estofos(int quantidade, String nome, List<Peca> obrigatorias, List<Peca> incompativeis) {
        super(quantidade, nome, obrigatorias, incompativeis);
    }

    public Estofos() {
        super();
    }

    public Estofos(Peca umaPeca) {
        super(umaPeca);
    }   
}
