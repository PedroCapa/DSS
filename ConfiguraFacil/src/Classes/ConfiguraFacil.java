package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.*;
import Exceptions.*;
import java.time.LocalDate;

public class ConfiguraFacil {

   private Map<String, Utilizador> utilizadores;
   private Map<String, Carro> carros;
   private Map<String, Modelo> modelos;
   private Map<String, Peca> pecas;
   private Map<String, Pacote> pacotes;
   private List<Carro> producao;

    public ConfiguraFacil(Map<String, Utilizador> utilizadores, Map<String, Carro> carros, Map<String, Modelo> modelos, Map<String, Peca> pecas, Map<String, Pacote> pacotes, List<Carro> producao) {
        this.utilizadores = new HashMap<>(utilizadores);
        this.carros = new HashMap<>(carros);
        this.modelos = new HashMap<>(modelos);
        this.pecas = new HashMap<>(pecas);
        this.pacotes = new HashMap<>(pacotes);
        this.producao = new ArrayList<>(producao);
    }

    public ConfiguraFacil() {
        this.utilizadores = new HashMap<>();
        this.carros = new HashMap<>();
        this.modelos = new HashMap<>();
        this.pecas = new HashMap<>();
        this.pacotes = new HashMap<>();
        this.producao = new ArrayList<>();
    }
    
    public ConfiguraFacil(ConfiguraFacil umConfiguraFacil) {
        this.utilizadores = umConfiguraFacil.getUtilizadores();
        this.carros = umConfiguraFacil.getCarros();
        this.modelos = umConfiguraFacil.getModelos();
        this.pecas = umConfiguraFacil.getPecas();
        this.pacotes = umConfiguraFacil.getPacotes();
        this.producao = umConfiguraFacil.getProducao();
    }

    public Map<String, Utilizador> getUtilizadores() {
        return new HashMap<>(this.utilizadores);
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new HashMap<>(utilizadores);
    }

    public Map<String, Carro> getCarros() {
        return new HashMap<>(this.carros);
    }

    public void setCarros(Map<String, Carro> carros) {
        this.carros = new HashMap<>(carros);
    }

    public Map<String, Modelo> getModelos() {
        return new HashMap<>(this.modelos);
    }

    public void setModelos(Map<String, Modelo> modelos) {
        this.modelos = new HashMap<>(modelos);
    }

    public Map<String, Peca> getPecas() {
        return new HashMap<>(this.pecas);
    }

    public void setPecas(Map<String, Peca> pecas) {
        this.pecas = new HashMap<>(pecas);
    }

    public Map<String, Pacote> getPacotes() {
       return new HashMap<>(this.pacotes);
    }

    public void setPacotes(Map<String, Pacote> pacotes) {
         this.pacotes = new HashMap<>(pacotes);
    }

    public List<Carro> getProducao() {
        return new ArrayList<>(this.producao);
    }

    public void setProducao(List<Carro> producao) {
        this.producao = new ArrayList<>(producao);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.utilizadores);
        hash = 59 * hash + Objects.hashCode(this.carros);
        hash = 59 * hash + Objects.hashCode(this.modelos);
        hash = 59 * hash + Objects.hashCode(this.pecas);
        hash = 59 * hash + Objects.hashCode(this.pacotes);
        hash = 59 * hash + Objects.hashCode(this.producao);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        ConfiguraFacil other = (ConfiguraFacil) obj;
        return (this.utilizadores.equals(other.getUtilizadores()) && this.carros.equals(other.getCarros()) 
                && this.modelos.equals(other.getModelos()) && this.pecas.equals(other.getPecas()) 
                && this.pacotes.equals(other.getPacotes()) && this.producao.equals(other.getProducao()));
        }
    
    public void registaCliente(String nome, String password, String email)throws UtilizadorJaRegistadoException{
        if(this.utilizadores.containsKey(email)){
            throw new UtilizadorJaRegistadoException("Ja existe um utilizador com essa conta de email registado");
        }
        Cliente c = new Cliente(nome, password, email);
        this.utilizadores.put(email, c);
    }
    
    public Utilizador fazerLogin(String email, String password) throws UtilizadorNaoExisteException, PasswordIncorretaException{
        if(!utilizadores.containsKey(email))
            throw new UtilizadorNaoExisteException("Utilizador não existe");
        Utilizador u = utilizadores.get(email);
        
        if(u.validaCredenciais(email))
            throw new PasswordIncorretaException("Palavra passe está incorreta");        
        return u;
    }
    
    public List<Peca> getStockDisponivel(){
        return this.pecas.values().stream().collect(Collectors.toList());
    }
    
    public void carroPronto(String id) throws CarroNaoExisteException, NaoExisteCarroEmProducaoException{
        if(!carros.containsKey(id))
            throw new CarroNaoExisteException("Carro não existe no sistema");
        Carro c = carros.get(id);
        if(this.producao.contains(c) && c.getEstado() == 1)
            throw new NaoExisteCarroEmProducaoException("Nao existe carro em producao com o id " + id);
        this.producao.remove(c);
        c.carroPronto();
    }
    
    public List<Carro> getCarrosComprados(String email) throws UtilizadorNaoExisteException{
        if(!utilizadores.containsKey(email))
            throw new UtilizadorNaoExisteException("Utilizador não existe");
        Cliente c = (Cliente)this.utilizadores.get(email);
        List<Carro> l = new ArrayList<>();
        c.getCarros().forEach((nomes) -> {
            l.add(this.carros.get(nomes));
        });
        return l;
    }
    
    public boolean valido(List<String> pecas, List<String> proibidas){
        boolean flag = true;
        for(String str: pecas){
            for(String s: proibidas)
                if(!str.equals(s))
                flag = false;
        }
        return flag;
    }
    
    public boolean validaPecas(List<Peca> pecas){
        boolean flag = true;
        List<String> nomes = pecas.stream().map(p -> p.getNome()).collect(Collectors.toList());
        for(Peca p: pecas){
            List<String> proibidas = p.getIncompativeis();
            List<String> obrigatorias = p.getObrigatorias();
            boolean ob = nomes.retainAll(obrigatorias);
            boolean pr = valido(nomes, proibidas);
            if(!ob || !pr)
                flag = false;
        }
        return flag;
    }
    
    public void addStock(String nome, int numero) throws PecaNaoExisteException{
        boolean flag;
        if(!pecas.containsKey(nome))
            throw new PecaNaoExisteException("A nome da peça que tentou inserir não existe");
        Peca p = pecas.get(nome);
        int n = p.getQuantidade();
        p.addStock(numero);
        if(n == 0){
            for(int i = 0; i < this.producao.size() && p.getQuantidade() > 0; i++){
                Carro c = producao.get(i);
                flag = c.pecaEmFalta(nome);
                if(flag)
                    p.reduzStock();
            }       
        }
    }
    
    public Carro comprarCarro(List<Peca> pecas, Modelo m, float preco, Cliente c){
        Carro car = new Carro();
        List<String> nomes = pecas.stream().map(p -> p.getNome()).collect(Collectors.toList());
        
        car.setModelo(m);
        
        for(String s: nomes){
            int stock = this.pecas.get(s).getQuantidade();
            if(stock > 0){
                car.addPecaCarro(s);
                this.pecas.get(s).reduzStock();
            }
            else{
                car.addFaltaCarro(s);
            }
        }
        
        if(car.getFalta().isEmpty())
            car.setEstado(1);
        else car.setEstado(0);
        car.setId(c.getNome() + c.getCarros().size());
        car.setCusto(preco);
        car.setData(LocalDate.now());
        car.setCliente(c.getEmail());
        return car;
    }
    
    public float calculaPreco(Modelo m, List<Peca> pecas){
        float preco = m.getCustoBase();
        
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        return preco;
    }
    
    public float calculaPreco(Pacote p, Modelo m, List<Peca> pecas) throws PecaNaoExisteException{
        float preco = m.getCustoBase();
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        if(p != null){
            for(Peca peca: stringToPeca(p.getPecas())){
                preco = preco + peca.getPreco();
            }
            preco = preco - preco*p.getDesconto();
        }
        return preco;
    }
    
    public void insereCarroSistema(Cliente c, Carro car){
        String id = c.getNome() + c.getCarros().size();
        car.setId(id);
        producao.add(car);
        carros.put(id, car);
        c.addCarro(id);
    }
    
    public List<Peca> stringToPeca(List<String> sPecas) throws PecaNaoExisteException{
        List<Peca> pecas = new ArrayList<>();
        for(String s: sPecas){
            if(!this.pecas.containsKey(s))
                throw new PecaNaoExisteException("Peca " + s + " nao existe");
            pecas.add(this.pecas.get(s));
        }
        return pecas;
    }
}