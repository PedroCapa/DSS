/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import Classes.*;
import java.time.LocalDate;
/**
 *
 * @author Luis
 */
public class TesteDB {
    
    public static void main(String [] args){
        /*
        ModeloDAO m = new ModeloDAO();
        PacoteDAO pack = new PacoteDAO();
        List<Pacote> list = new ArrayList<>();
        list.add(pack.get("Nome"));
        list.add(pack.get("Eco"));
        Modelo model = new Modelo("Ford GT XyZ", list, 2500);
        m.put(model.getNome(), model);
        for(Modelo m1: m.values()) System.out.println(m1);
        */
        /*
        PacoteDAO pack = new PacoteDAO();
        List<String> pecas = new ArrayList<>();
        pecas.add("fhusahfhshif");
        pecas.add("Branco");
        Pacote p = new Pacote("Nome", (float)0.02, pecas);
        pack.put("Nome", p);
        for(Pacote pacote: pack.values()) System.out.println(pacote);
        */
        /*
        UtilizadorDAO u = new UtilizadorDAO();
        Utilizador c = new Cliente("Lucas Silva", "lucas", "abcefghijkl", new ArrayList<>());
        u.put(c.getEmail(), c);
        for(Utilizador user: u.values()) System.out.println(user);
        */
        /*
        PecaDAO pecaDAO = new PecaDAO();
        List<String> o = new ArrayList<>();
        List<String> i = new ArrayList<>();
        i.add("V 12");
        Peca peca = new Motor(2, "fhusahfhshif", (float)34.6, o, i);
        pecaDAO.remove(peca.getNome());
        pecaDAO.put(peca.getNome(), peca);
        Collection<Peca> pecas = pecaDAO.values();
        for(Peca p: pecas){
            System.out.println(p);
        }
        */
        CarroDAO c = new CarroDAO();
        ModeloDAO model = new ModeloDAO();
        Modelo m = model.get("Model T");
        List<String> falta = new ArrayList<>();
        falta.add("177 cu in");
        falta.add("Branco");
        falta.add("Ferro");
        falta.add("Couro Recaro Red");
        Carro car = new Carro(m, "fhalkfsh", 0, new ArrayList<>(), 25000, LocalDate.now(), falta, "tmp1998@hotmail.com");
        c.put(car.getId(), car);
        Collection<Carro> carros = c.values();
        for(Carro carro: carros) System.out.println(carro);        
    }
}
