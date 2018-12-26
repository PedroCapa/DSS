/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Exceptions.*;
import Classes.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Luis
 */
public class ConfiguraFacil {
    
    private CarroDAO carros;
    private ModeloDAO modelos;
    private PacoteDAO pacotes;
    private PecaDAO pecas;
    private UtilizadorDAO utilizadores;
    
    public ConfiguraFacil(){
        this.carros = new CarroDAO();
        this.modelos = new ModeloDAO();
        this.pacotes = new PacoteDAO();
        this.pecas = new PecaDAO();
        this.utilizadores = new UtilizadorDAO();
    }
    
    /*
    Não devia de retornar um Cliente?????????????????????????????????????????????????????
    */
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
        if(!c.emProducao())
            throw new NaoExisteCarroEmProducaoException("Nao existe carro em producao com o id " + id);
        c.carroPronto();
    }
    
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
    
    public Carro comprarCarro(List<Peca> pecas, Modelo m, float preco, Cliente c){
        Carro car = new Carro();
        car.setModelo(m);
        
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
        car.setId(c.getNome() + c.getCarros().size());
        car.setCusto(preco);
        car.setData(LocalDate.now());
        car.setCliente(c.getEmail());
        return car;
    }
    
    public void insereCarroSistema(Cliente c, Carro car){
        String id = car.getId();
        carros.put(id, car);
        c.addCarro(id);
    }
    
    public float calculaPreco(Modelo m, List<Peca> pecas){
        float preco = m.getCustoBase();
        
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        return preco;
    }
    
    public float precoPacote(Pacote p){
        float f = 0;
        List<Peca> list = p.getPecas().stream().map(s -> this.pecas.get(s)).collect(Collectors.toList());
        for(Peca peca: list)
            f = f + peca.getPreco();
        return f;
    }
    
    public float calculaPreco(Pacote p, Modelo m, List<Peca> pecas) throws PecaNaoExisteException{
        float preco = m.getCustoBase();
        for(Peca peca: pecas)
            preco = preco + peca.getPreco();
        
        if(p != null){
            preco = (preco + precoPacote(p))* (1 - p.getDesconto());
        }
        return preco;
    }
}