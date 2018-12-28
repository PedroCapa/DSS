/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Modelo;
import Classes.Pacote;
import Classes.Carro;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.sql.*;


public class ModeloDAO implements Map<String, Modelo>{
        
    private Connection conn;
    
        /**
     * Método DAO que permite aceder à informação relacionada com os modelos na base de dados
     * 
     * @author Eu
     */
    public ModeloDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
        /**
     * Método que cria um set de modelos
     * 
     * @author Eu
     */
    @Override
    public Set<Map.Entry<String,Modelo>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Modelo>> entrySet() not implemented!");
    }
        /**
     * Método que cria uma coleção de modelos
     * 
     * @return coleção criada
     * 
     * @author Eu
     */
    @Override
    public Collection<Modelo> values(){
        Collection<Modelo> modelos = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Modelo m = this.get(str);
            modelos.add(m);
        }
        return modelos;
    }
        /**
     * Método que cria um set com os ids dos modelos
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
            String str = "Select Nome From Modelo";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("Nome"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que apaga caraterísticas de modelos
     * 
     * @author Eu
     */
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("Delete From Pacote_Modelo");
            stm.executeUpdate("Delete From Peca_Carro");
            stm.executeUpdate("Delete From Carro");
            stm.executeUpdate("DELETE FROM Modelo");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método não implementado
     * 
     * @author Eu
     */
    @Override
    public void putAll(Map<? extends String,? extends Modelo> p) {
        throw new NullPointerException("Not implemented!");
    }
        /**
     * Método que remove um modelo da base de dados
     * 
     * @param key chave que dá acesso ao modelo
     * 
     * @return modelo removido da base de dados
     * 
     * @author Eu
     */
    @Override
    public Modelo remove(Object key) {
        try {
            String chave = (String)key;
            Modelo m = this.get(chave);
            Statement stm = conn.createStatement();
            String s1 = "Delete From Pacote_Modelo Where Modelo_Nome='"+chave+"'";
            int j = stm.executeUpdate(s1);
            String sql = "DELETE FROM Modelo Where Nome='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return m;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que insere caraterísticas num modelo
     * 
     * @param key chave que dá acesso ao modelo
     * 
     * @param value modelo cujas caraterísticas serão alteradas
     * 
     * @return modelo com novas caraterísticas
     * 
     * @author Eu
     */
    @Override
    public Modelo put(String key, Modelo value) {
        Modelo m = new Modelo(value);
        this.putModelo(key, value);
        this.putPacoteModelo(key, value);
        return m;
    }
        /**
     * Método que insere num modelo as caraterísticas que estão relacionadas com ele
     * 
     * @param key chave que dá acesso ao modelo
     * 
     * @param value modelo que recebe as caraterísticas
     * 
     * @author Eu
     */
    public void putModelo(String key, Modelo value){
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Modelo VALUES ('"+key+"',"+value.getCustoBase()+")";
            int i  = stm.executeUpdate(sql);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que insere num modelo as caraterísticas que estão relacionadas com este e com os pacotes
     * 
     * @param key chave que dá acesso ao modelo e ao pacote
     * 
     * @param value modelo que recebe as caraterísticas
     * 
     * @author Eu
     */
    public void putPacoteModelo(String key, Modelo value){
        try {
            Statement stm = conn.createStatement();
            for(Pacote p: value.getPacotes()){
                String str = p.getNome();
                String s = "Insert Pacote_Modelo Values ('"+key+"','"+str+"')";
                stm.executeUpdate(s);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que permite obter as caraterísticas do modelo
     * 
     * @param key chave que dá acesso ao modelo
     * 
     * @author Eu
     */
    @Override
    public Modelo get(Object key) {
        try {
            Modelo m = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Modelo WHERE Nome='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                m = new Modelo();
                m.setNome((String)key);
                m.setCustoBase(rs.getFloat("CustoBase"));
                PacoteDAO p = new PacoteDAO();
                p.getPacoteModelo(m);
            }
            return m;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
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
            String sql = "SELECT * FROM Modelo WHERE Nome='"+(String)key+"'";
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
            String sql = "SELECT Nome FROM Modelo";
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
            ResultSet rs = stm.executeQuery("SELECT Nome FROM Pacote");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que obtém a partir da base de dados o modelo de um carro
     * 
     * @param key chave que dá acesso ao carro e ao modelo
     * 
     * @param car carro a ser verificado
     * 
     * @param nome modelo do carro verificado
     * 
     * @author Eu
     */
    public void getModeloCarro(String key, Carro car, String nome){
        Modelo m = this.get(nome);
        car.setModelo(m);
    }
}
