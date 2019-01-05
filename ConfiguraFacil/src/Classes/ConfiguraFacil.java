package Classes;
import Exceptions.*;
import DAO.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe principal que contem a informacao de outras classes
 * 
 */
public class ConfiguraFacil {
    /**Variavel que acede a base de dados da tabela dos carros*/
    private CarroDAO carros;
    /**Variavel que acede a base de dados da tabela dos modelos*/
    private ModeloDAO modelos;
    /**Variavel que acede a base de dados da tabela pacotes*/
    private PacoteDAO pacotes;
    /**Variavle que acede a base de dados da tabela das pecas*/
    private PecaDAO pecas;
    /**Variavel que acede a base de dados da tabela dos utilizadores*/
    private UtilizadorDAO utilizadores;
    /**Construtor vazio do sistema*/
    public ConfiguraFacil(){
        this.carros = new CarroDAO();
        this.modelos = new ModeloDAO();
        this.pacotes = new PacoteDAO();
        this.pecas = new PecaDAO();
        this.utilizadores = new UtilizadorDAO();
    }
    /**
     * Metodo que retorna um modelo
     * 
     * @param m Nome do modelo que se pretende retornar
     * 
     * @return o modelo m
     */
    public Modelo getModelo(String m){
        return this.modelos.get(m);
    }
    /**
     * Metodo que retorna um pacote
     * 
     * @param p Nome do pacote que se pretende retornar
     * 
     * @return o pacote p
     */
    public Pacote getPacote(String p){
        return this.pacotes.get(p);
    }
    /**
     * Metodo que retorna a lista de pecas
     * 
     * @return 
     */
    public List<Peca> getPecas(){
        return this.pecas.values().stream().collect(Collectors.toList());
    }
    /**
     * Metodo que retorna uma peca
     * 
     * @param peca Nome da peca que se pretende retornar
     * 
     * @return peca com nome peca
     */
    public Peca getPeca(String peca){
        Peca p = this.pecas.get(peca);
        return p;
    }
    /**
     * Metodo que insere na base de dados um cliente
     * 
     * @param nome Nome do cliente
     * 
     * @param password Palavra chave do cliente
     * 
     * @param email Email do cliente que sera a sua chave primaria
     * 
     * @return cliente que foi registado
     * 
     * @throws UtilizadorJaRegistadoException Exceção atirada caso o utilizador que se pretenda inserir na base de dados ja exista
     */
    public Cliente registaCliente(String nome, String password, String email)throws UtilizadorJaRegistadoException{
        if(this.utilizadores.containsKey(email)){
            throw new UtilizadorJaRegistadoException("Ja existe um utilizador com essa conta de email registado");
        }
        Cliente c = new Cliente(nome, password, email);
        this.utilizadores.put(email, c);
        return c;
    }
    /**
     * Metodo que verifica se o utilizador pode aceder aos seus dados
     * 
     * @param email Email do utilizador que pretende iniciar 
     * 
     * @param password Password inserida. Ira ser verificada se sera a palavra passe correta
     * 
     * @return O utilizador que iniciou sessão
     * 
     * @throws UtilizadorNaoExisteException No caso do email inserido não corresponder a nenhum utilizador
     * 
     * @throws PasswordIncorretaException No caso da palavra passe estar incorreta
     */
    public Utilizador fazerLogin(String email, String password) throws UtilizadorNaoExisteException, PasswordIncorretaException{
        if(!utilizadores.containsKey(email))
            throw new UtilizadorNaoExisteException("Utilizador não existe");
        Utilizador u = utilizadores.get(email);
        if(!u.validaCredenciais(password))
            throw new PasswordIncorretaException("Palavra passe está incorreta");        
        return u;
    }
    /**
     * Metodo que retorna todas as pecas
     * 
     * @return lista de todas as pecas guardadas na BD
     */
    public List<Peca> getStockDisponivel(){
        return this.pecas.values().stream().collect(Collectors.toList());
    }
    /**
     * Metodo que muda o estado do carro para pronto
     * 
     * @param id Identificador do carro que se pretende mudar o estado
     * 
     * @throws CarroNaoExisteException No caso do carro nao existir no sistema 
     * 
     * @throws NaoExisteCarroEmProducaoException No caso do carro não se encontrar em producao
     */
    public void carroPronto(String id) throws CarroNaoExisteException, NaoExisteCarroEmProducaoException{
        if(!carros.containsKey(id))
            throw new CarroNaoExisteException("Carro não existe no sistema");
        Carro c = carros.get(id);
        if(!c.emProducao())
            throw new NaoExisteCarroEmProducaoException("Nao existe carro em producao com o id " + id);
        c.carroPronto();
        this.carros.update(c);
    }
    /**
     * Metodo que retorna os carros comprados por um cliente
     * 
     * @param email Email do utilizador que se pretende visualizar a lista de carros comprados
     * 
     * @return Lista de carros comprados pelo utilizador email
     * 
     * @throws UtilizadorNaoExisteException No caso do email não existir
     */
    public List<Carro> getCarrosComprados(String email) throws UtilizadorNaoExisteException{
        if(!utilizadores.containsCliente(email))
            throw new UtilizadorNaoExisteException("Utilizador não existe");
        Cliente c = (Cliente)this.utilizadores.get(email);
        List<Carro> l = new ArrayList<>();
        c.getCarros().forEach((nomes) -> {
            l.add(this.carros.get(nomes));
        });
        return l;
    }
    /**
     * Metodo que verifica se as pecas que estao no carro são validas
     * 
     * @param pecas lista de pecas que estao no carro
     * 
     * @param proibidas Lista de pecas proibidas que se pretende intersetar com as pecas
     * 
     * @return true no caso de nenhuma das pecas proibidas estar presente nas pecas false caso contrario
     */
    public boolean valido(List<String> pecas, List<String> proibidas){
        boolean flag = true;
        for(String str: pecas){
            for(String s: proibidas)
                if(str.equals(s))
                flag = false;
        }
        return flag;
    }
    /**
     * Método que verifica se todas as peças obrigatórias estão colocadas
     * @param pecas Peças esolhidas na compra do carro
     * @param obrigatorias Peças obrigatorias de uma determinada peça
     * @return true se todas as peças obrigatórias estão no parametro pecas, false caso contrário
     */
    public boolean contem(List<String> pecas, List<String> obrigatorias){
        boolean flag = true;
        for(String s: obrigatorias)
            if(!pecas.contains(s))
                flag = false;
        return flag;
    }
    /**
     * Metodo que verifica se as pecas são validas 
     * 
     * @param pecas Lista de pecas que se pretende verificar 
     * 
     * @return true caso as pecas sejam validas false caso contrario
     */
    public boolean validaPecas(List<Peca> pecas){
        boolean flag = true;
        List<String> nomes = pecas.stream().map(p -> p.getNome()).collect(Collectors.toList());
        for(Peca p: pecas){
            List<String> proibidas = p.getIncompativeis();
            List<String> obrigatorias = p.getObrigatorias();
            boolean ob = contem(nomes, obrigatorias);
            boolean pr = valido(nomes, proibidas);
            if(!ob || !pr)
                flag = false;
        }
        return flag;
    }
    /**
     * Metodo que adiciona stock a uma peça
     * 
     * @param nome Nome da peca que se pretende inserir stock
     * 
     * @param numero Quantidade a aumentar da peca
     * 
     * @throws PecaNaoExisteException No caso da peca inserida nao existir
     */
    public void addStock(String nome, int numero) throws PecaNaoExisteException{
        boolean flag;
        if(!pecas.containsKey(nome))
            throw new PecaNaoExisteException("A nome da peça que tentou inserir não existe");
        Peca p = pecas.get(nome);
        int n = p.getQuantidade();
        p.addStock(numero);
        List<Carro> espera = this.carros.getCarrosEspera();
        if(n == 0){
            for(int i = 0; i < espera.size() && p.getQuantidade() > 0; i++){
                Carro c = espera.get(i);
                flag = c.pecaEmFalta(nome);
                if(flag)
                    p.reduzStock();
            }       
        }
        this.pecas.update(p);
        this.carros.updateAll(espera);
    }
    /**
     * Metodo que cria um carro e é inserido no sistema
     * 
     * @param pecas Lista de pecas escolhidas para o carro
     * 
     * @param m Modelo do carro
     * 
     * @param pacote Pacote escolhido para o carro
     * 
     * @param preco preco do carro
     * 
     * @param c cliente que comprou o carro
     * 
     * @return Carro criado
     */
    public Carro comprarCarro(List<Peca> pecas, Modelo m, Pacote pacote, float preco, Cliente c){
        Carro car = new Carro();
        car.setModelo(m);
        if(pacote != null)
            pecas.addAll(stringToPeca(pacote.getPecas()));
        for(Peca p: pecas){
            int stock = p.getQuantidade();
            String nome = p.getNome();
            if(stock > 0){
                car.addPecaCarro(nome);
                p.reduzStock();
                this.pecas.update(p);
            }
            else{
                car.addFaltaCarro(nome);
            }
        }
        
        if(car.getFalta().isEmpty())
            car.setEstado(1);
        else car.setEstado(0);
        car.setId(c.getEmail() + c.getCarros().size());
        car.setCusto(preco);
        car.setData(LocalDate.now());
        car.setCliente(c.getEmail());
        insereCarroSistema(c, car);
        return car;
    }
    /**
     * Metodo que insere no sistema um carro
     * 
     * @param c Cliente que comprou o carro
     * 
     * @param car Carro que se pretende inserir no sistema
     */
    public void insereCarroSistema(Cliente c, Carro car){
        String id = car.getId();
        carros.put(id, car);
        c.addCarro(id);
    }
    /**
     * Metodo que calcula o preco do modelo com um conjunto de pecas
     * 
     * @param m Modelo comprado
     * 
     * @param pecas Lista de pecas extras excolhidas
     * 
     * @return o preco total do carro
     */
    public float calculaPreco(Modelo m, List<Peca> pecas){
        float preco = m.getCustoBase();
        
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        return preco;
    }
    /**
     * Metodo que calcula o preco do pacote
     * 
     * @param p Pacote que se pretende verificar o preco
     * 
     * @return O preco do pacote
     */
    public float precoPacote(Pacote p){
        float f = 0;
        List<Peca> list = p.getPecas().stream().map(s -> this.pecas.get(s)).collect(Collectors.toList());
        for(Peca peca: list)
            f = f + peca.getPreco();
        return f*(1 - p.getDesconto());
    }
    /**
     * Metodo que calcula o preco do carro com um pacote
     * 
     * @param p Pacote escolhido
     * 
     * @param m Modelo escolhido para o carro
     * 
     * @param pecas Lista dos extras escolhidos
     * 
     * @return o preco do carro
     * 
     * @throws PecaNaoExisteException No caso da lista de pecas n existirem no sistema
     */
    public float calculaPreco(Pacote p, Modelo m, List<Peca> pecas) throws PecaNaoExisteException{
        float preco = m.getCustoBase();
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        if(p != null){
            preco = preco + precoPacote(p);
        }
        return preco;
    }
    /**
     * Metodo que dado uma lista de string tranforma-as em pecas
     * 
     * @param sPecas Lista de strings que se pretende transformar em pecas
     * 
     * @return Lista de pecas que corresponde as strings do sPecas
     */
    public List<Peca> stringToPeca(List<String> sPecas){
        List<Peca> p = new ArrayList<>();
        for(String s: sPecas)
            p.add(this.pecas.get(s));
        return p;
    }
    /**
     * Metodo que verifica se existe algum pacote com determindao orcamento
     * 
     * @param m Modelo escolhido
     * 
     * @param preco Orcamento disponivel
     * 
     * @return true caso exista pacote com o valor menor do que preco false caso contrario
     */
    public boolean estaDentro(Modelo m, float preco){
        boolean b = false;
        for(Pacote p: m.getPacotes()){
            float valor = precoPacote(p);            
            if(preco > (valor + m.getCustoBase()))
                b = true;
        }
        return b;
    }
    /**
     * Metodo que calcula o valor de uma lista de pecas
     * 
     * @param pecas Lista de pecas que se vai verificar o valor
     * 
     * @return O valor das pecas
     */
    public float valorListaPecas(List<Peca> pecas){
        float res = 0;
        for(Peca p: pecas)
            res = res + p.getPreco();
        return res;
    }
    /**
     * Metodo que acrescenta as peças obrigatorias de um pacote
     * 
     * @param peca Peca que se vai verificar as obrigatorias
     * 
     * @param pecas Extras que o pacote precisa
     * 
     * @param obg List de pecas obrigatorias da peca
     */
    public void podeEntrar(Peca peca, List<Peca> pecas, List<Peca> obg){
        for(Peca p: obg){
            if(!pecas.contains(p) && p instanceof Extras){
                pecas.add(p);
                podeEntrar(p, pecas, stringToPeca(p.getObrigatorias()));
            }
        }
    }
    /**
     * Metodo que verifica se e possivel que os componentes extras do pacote cabem no orçamento
     * 
     * @param pecas Lista de pecas do pacote
     * 
     * @return list de pecas obrigatorias
     */
    public List<Peca> podeEntrar(List<Peca> pecas){
        List<Peca> com = new ArrayList<>();
        List<Peca> obg = new ArrayList<>();
        for(Peca p: pecas){
            obg = stringToPeca(p.getObrigatorias());
            podeEntrar(p, com, obg);
        }
        return com;
    }
    
    /**
     * Metodo que verifica qual o melhor pacote com um determinado orcamento
     * 
     * @param m Modelo escolhido
     * 
     * @param orc Orcamento restante para escolher um pacote
     * 
     * @return o pacote que mais se adequa ao orcamento
     */
    public Pacote melhorPacote(Modelo m, float orc){
        float f = 0;
        List<Peca> obg = new ArrayList<>();
        Pacote melhor = null;
        for(Pacote p: m.getPacotes()){
            float preco = precoPacote(p);
            obg = podeEntrar(stringToPeca(p.getPecas()));
            if(preco > f && (orc - preco - valorListaPecas(obg)) > 0){
                melhor = p;
                f = preco;
            }
        }
        return melhor;
    }
    /**
     * Metodo que retorna todos os extras das pecas
     * 
     * @return pecas que sao do tipo extras
     */
    public List<Peca> getExtras(){
        return this.pecas.values().stream().filter(p -> p instanceof Extras).collect(Collectors.toList());
    }
    /**
     * Metodo que retorna a peca mais cara contida no argumento
     * 
     * @param extras lista de pecas que se pretende verificar qual e a mais cara
     * 
     * @return Peca mais cara
     */
    public Peca getPecaMaisCara(List<Peca> extras){
        Peca p = extras.get(0);
        for(Peca peca: extras){
            if(peca.getPreco()> p.getPreco())
                p = peca;
        }
        return p;
    }
    /**
     * Metodo que retorna o preco das pecas obrigatorias
     * 
     * @param pecas Lista de pecas obrigatorias de uma determinada pecas
     * 
     * @return valor das pecas obrigatorias
     */
    public float getPrecoObrigatorias(List<Peca> pecas){
        float f = 0;
        for(Peca p: pecas){
            f = f + p.getPreco();
        }
        return f;
    }
    /**
     * Verifica quais são todas as peças obrigatorias necessarias para a instalação de peca cara, porque as obrigatorias tambem têm
     * pecas que são obrigatorias
     * 
     * @param cara Peca que se verifica quais são as suas obrigatorias
     * 
     * @param obg A lista de pecas obrigatorias da peca p
     * 
     * @param componentes Componentes que o carro ja apresenta
     * 
     * @param valida Lista temporaria das pecas que ao adicionar a peca p são obrigadas a inserir
     * 
     * @return true caso seja possivel inserir a peca p false caso contrario
     */
    public boolean adicionaObrigatorias(Peca cara, List<Peca> obg, List<Peca> componentes, List<Peca> valida){
        boolean flag = true;
        for(Peca p: obg){
            if(!componentes.contains(p) && p instanceof Extras && !valida.contains(p)){
                valida.add(p);
            }
            else if (!componentes.contains(p))
                return false;
            flag = adicionaObrigatorias(p, stringToPeca(p.getObrigatorias()), componentes, valida);
            if(!flag)
                return false;
        }
        return true;
    }
    
    /**
     * Metodo que calcula quais sao os melhores extras com um determindo preco
     * 
     * @param preco Orcamento dispivel para as pecas extras
     *
     * @param pacote Pacote escolhido
     * 
     * @return Lista de pecas extras do carro
     */
    public List<Peca> componentesExtra(float preco, Pacote pacote){
        List<Peca> componentes = new ArrayList<>();
        List<Peca> extras = getExtras().stream().filter(peca -> peca.getPreco() < preco).collect(Collectors.toList());
        float orc = preco;
        List<Peca> extrasPacote = podeEntrar(stringToPeca(pacote.getPecas()));
        componentes.addAll(extrasPacote);
        extras.removeAll(extrasPacote);
        orc = orc - valorListaPecas(extras);
        while(extras.size() > 0){
            Peca cara = getPecaMaisCara(extras);
            List<Peca> obrigatorias = stringToPeca(cara.getObrigatorias());
            List<Peca> valida = new ArrayList<>();
            List<Peca> tmp = new ArrayList<>(componentes);
            boolean flag = adicionaObrigatorias(cara, obrigatorias, componentes, valida);
            tmp.addAll(valida);
            tmp.addAll(stringToPeca(pacote.getPecas()));
            if(flag && getPrecoObrigatorias(valida) + cara.getPreco() <= orc && validaPecas(tmp)){
                orc = orc - getPrecoObrigatorias(valida) - cara.getPreco();
                componentes.add(cara);
                componentes.addAll(valida);
                extras.removeAll(valida);
            }
            extras.remove(cara);
        }
        return componentes;
    }
    /**
     * Metodo que caclcula quais sao os melhores componentes para um determinado modelo e orcamento
     * 
     * @param m Modelo escolhido
     * 
     * @param preco Orcamento disponivel para o carro
     * 
     * @return Melhor pacote possivel para um determindo orcamento
     * 
     * @throws CustoDemasiadoBaixoException 
     */
    public Pacote configuracaoOtimaPacote(Modelo m, float preco) throws CustoDemasiadoBaixoException{
        if(m.getCustoBase() > preco)
            throw new CustoDemasiadoBaixoException("O preco esta abaixo do custo do modelo");
        if(!estaDentro(m, preco)){
            throw new CustoDemasiadoBaixoException("O preco esta abaixo do valor das pecas basicas");
        }
        Pacote pacote = melhorPacote(m, preco - m.getCustoBase());
        if(pacote == null)
            throw new CustoDemasiadoBaixoException("O preco esta abaixo do valor das pecas extras");
        return pacote;
    }
    /**
     * Metodo que retorna a lista de carros em producao
     * 
     * @return Lista de carros em producao
     */
    public List<Carro> getCarrosProducao(){
        return this.carros.getCarrosProducao();
    }
}
