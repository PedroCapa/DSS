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
