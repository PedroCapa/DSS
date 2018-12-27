/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Carro;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarroDAO implements Map<String, Carro>{
    
    private Connection conn;
    
        /**
     * Método DAO que permite aceder à informação relacionada com os carros na base de dados
     * 
     * @author Eu
     */
    public CarroDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
    
        /**
     * Método que cria um set de carros
     * 
     * @author Eu
     */
    @Override
    public Set<Map.Entry<String,Carro>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Carro>> entrySet() not implemented!");
    }
        /**
     * Método que cria uma coleção de carros
     * 
     * @return coleção criada
     * 
     * @author Eu
     */
    @Override
    public Collection<Carro> values(){
        Collection<Carro> carros = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Carro car = this.get(str);
            carros.add(car);
        }
        return carros;
    }
        /**
     * Método que cria um set com os ids dos carros
     * 
     * @return set dos ids
     * 
     * @author Eu
     */
    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select id From Carro";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("id"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que apaga caraterísticas de carros
     * 
     * @author Eu
     */
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("Delete From Peca_Carro");
            stm.executeUpdate("DELETE FROM Carro");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método não implementado
     * 
     * @author Eu
     */
    @Override
    public void putAll(Map<? extends String,? extends Carro> t) {
        throw new NullPointerException("Not implemented!");
    }
        /**
     * Método que remove caraterísticas de um carro específico
     * 
     * @param key chave que dá acesso ao carro
     * 
     * @author Eu
     */
    @Override
    public Carro remove(Object key) {
        try {
            String chave = (String)key;
            Carro car = this.get(chave);
            String s = "Delete From Peca_Carro Where Carro_id='"+chave+"'";
            Statement st = this.conn.createStatement();
            int j = st.executeUpdate(s);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Carro Where id='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return car;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que insere caraterísticas num carro
     * 
     * @param key chave que dá acesso ao carro
     * 
     * @param value carro cujas caraterísticas serão alteradas
     * 
     * @return carro com novas caraterísticas
     * 
     * @author Eu
     */
    @Override
    public Carro put(String key, Carro value) {
        try {
            String data = value.getData().toString();
            Date date = java.sql.Date.valueOf(data);
            String m = value.getModelo().getNome();
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Carro (id, Estado, Preco, Data, Modelo_Nome, Utilizador_Email) VALUES ";
            sql += "('"+key+"',"+value.getEstado()+",";
            sql += value.getCusto()+", '"+date+"', '"+m+"','"+value.getCliente()+"')";
            int i  = stm.executeUpdate(sql);
            this.putPecaCarro(key, value.getPecas(), value.getFalta());
            return new Carro(value);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que insere num carro as caraterísticas que estão relacionadas com este e com as peças
     * 
     * @param key chave que dá acesso à peça e ao carro
     * 
     * @param p lista de strings das peças colocadas
     * 
     * @param f lista de strings das peças não colocadas
     * 
     * @author Eu
     */
    public void putPecaCarro(String key, List<String> p, List<String> f){
        try {
            Statement stm = conn.createStatement();
            for(String str: p){
                String sql = "INSERT INTO Peca_Carro VALUES ('"+key+"', 1, '"+str+"')";
                int i = stm.executeUpdate(sql);
            }
            for(String s: f){
                String sql = "INSERT INTO Peca_Carro VALUES ('"+key+"', 0, '"+s+"')";
                int i = stm.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        /**
     * Método que permite obter as caraterísticas do carro
     * 
     * @param key chave que dá acesso ao carro
     * 
     * @author Eu
     */
    @Override
    public Carro get(Object key) {
        try {
            Carro car = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Carro WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                car = new Carro();
                car.setId(rs.getString("id"));
                car.setEstado(rs.getInt("Estado"));
                car.setCusto(rs.getFloat("Preco"));
                String modeloNome = rs.getString("Modelo_Nome");
                String clienteEmail = rs.getString("Utilizador_Email");
                Object o = rs.getObject("Data");
                String s = o.toString();
                LocalDate data = LocalDate.parse(s);
                car.setData(data);
                car.setCliente(clienteEmail);
                this.getPecaCarro((String)key, car);
                ModeloDAO m = new ModeloDAO();
                m.getModeloCarro((String)key, car, modeloNome);
            }
            return car;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que obtém as peças num carro (e as que faltam colocar)
     * 
     * @param key chave que dá acesso ao carro
     * 
     * @param value carro a ser verificado
     * 
     * @author Eu
     */
    public void getPecaCarro(String key, Carro value){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Peca_Carro WHERE Carro_id='"+key+"'";
            ResultSet rs = stm.executeQuery(sql);
            List<String> pecas = new ArrayList<>();
            List<String> falta = new ArrayList<>();
            while(rs.next()){
                if(rs.getBoolean("Colocada")){pecas.add(rs.getString("Peca_Nome"));}
                else {falta.add(rs.getString("Peca_Nome"));}
            }
            value.setFalta(falta);
            value.setPecas(pecas);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que verifica se a chave está correta
     * 
     * @param key chave a ser verificada
     * 
     * @return boolean que diz se a chave está correta ou não
     * 
     * @author Eu
     */
    @Override
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Carro WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que verifica se um dado objeto existe
     * 
     * @param value objeto a ser verificado
     * 
     * @author Eu
     */
    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
        /**
     * Método que verifica se uma string está vazia
     * 
     * @return boolean que diz se a string está vazia ou não
     * 
     * @author Eu
     */
    @Override
    public boolean isEmpty(){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT id FROM Carro";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que verifica o tamanho de uma statement
     * 
     * @return tamanho da statement
     * 
     * @author Eu
     */
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Carro");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que atualiza o estado de um carro
     * 
     * @param car Carro a ser atualizado
     * 
     * @author Eu
     */
    public void update(Carro car){
        try {
            String id = car.getId();
            int estado = car.getEstado();
            String sql = "Update Carro Set Estado="+estado+" Where id='"+id+"'";
            Statement stm = conn.createStatement();
            int i = stm.executeUpdate(sql);
            for(String str: car.getPecas()){
                String s = "Update Peca_Carro Set Colocada=1 Where Carro_id='"+id+"' AND Peca_Nome='"+str+"'";
                int j = stm.executeUpdate(s);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que atualiza o estado de todos os carros
     * 
     * @param carros Lista dos carros a serem atualizados
     * 
     * @author Eu
     */
    public void updateAll(List<Carro> carros){
        for(Carro c: carros){
            this.update(c);
        }
    }
        /**
     * Método que obtém a lista de carros à espera de serem produzidos
     * 
     * @return lista dos carros em espera
     * 
     * @author Eu
     */
    public List<Carro> getCarrosEspera(){
        try {
            Statement stm = conn.createStatement();
            String sql = "Select * From Carro Where Estado = 0";
            ResultSet res = stm.executeQuery(sql);
            List<Carro> carros = new ArrayList<>();
            while(res.next()){
                String id = res.getString("Id");
                Carro car = get(id);
                carros.add(car);
            }
            return carros;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que obtém a lista de carros em produção
     * 
     * @return lista dos carros em produção
     * 
     * @author Eu
     */
    public List<Carro> getCarrosProducao(){
        try {
            Statement stm = conn.createStatement();
            String sql = "Select * From Carro Where Estado = 1";
            ResultSet res = stm.executeQuery(sql);
            List<Carro> carros = new ArrayList<>();
            while(res.next()){
                String id = res.getString("Id");
                Carro car = get(id);
                carros.add(car);
            }
            return carros;
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
}
