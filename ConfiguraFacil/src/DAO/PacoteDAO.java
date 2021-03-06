/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.Pacote;
import Classes.Modelo;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class PacoteDAO implements Map<String, Pacote>{
    
    private Connection conn;
    
        /**
     * Método DAO que permite aceder à informação relacionada com os pacotes na base de dados
     * 
     * @author Eu
     */
    public PacoteDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
        /**
     * Método que cria um set de pacotes
     * 
     * @author Eu
     */
    @Override
    public Set<Map.Entry<String,Pacote>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Pacote>> entrySet() not implemented!");
    }
        /**
     * Método que cria uma coleção de pacotes
     * 
     * @return coleção criada
     * 
     * @author Eu
     */
    @Override
    public Collection<Pacote> values(){
        Collection<Pacote> pacotes = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Pacote pack = this.get(str);
            pacotes.add(pack);
        }
        return pacotes;
    }
        /**
     * Método que cria um set com os ids dos pacotes
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
            String str = "Select Nome From Pacote";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("Nome"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
        /**
     * Método que apaga caraterísticas de pacotes
     * 
     * @author Eu
     */
    @Override
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("Delete From Peca_Pacote");
            stm.executeUpdate("Delete From Pacote_Modelo");
            stm.executeUpdate("DELETE FROM Pacote");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método não implementado
     * 
     * @author Eu
     */
    @Override
    public void putAll(Map<? extends String,? extends Pacote> p) {
        throw new NullPointerException("Not implemented!");
    }
        /**
     * Método que remove um pacote da base de dados
     * 
     * @param key chave que dá acesso ao pacote
     * 
     * @return pacote removido da base de dados
     * 
     * @author Eu
     */
    @Override
    public Pacote remove(Object key) {
        try {
            String chave = (String)key;
            Pacote p = this.get(chave);
            Statement stm = conn.createStatement();
            String s = "Delete From Peca_Pacote Where Pacote_Nome='"+chave+"'";
            int j = stm.executeUpdate(s);
            String str = "DELETE FROM Pacote_Modelo Where Pacote_Nome='"+chave+"'";
            int k = stm.executeUpdate(str);
            String sql = "DELETE FROM Pacote Where Nome='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return p;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que insere caraterísticas num pacote
     * 
     * @param key chave que dá acesso ao pacote
     * 
     * @param value pacote cujas caraterísticas serão alteradas
     * 
     * @return pacote com novas caraterísticas
     * 
     * @author Eu
     */
    @Override
    public Pacote put(String key, Pacote value) {
        Pacote p = new Pacote(value);
        this.putPacote(key, value);
        this.putPecaPacote(key, value);
        return p;
    }
        /**
     * Método que insere num pacote as caraterísticas que estão relacionadas com ele
     * 
     * @param key chave que dá acesso ao pacote
     * 
     * @param value pacote que recebe as caraterísticas
     * 
     * @author Eu
     */
    public void putPacote(String key, Pacote value){
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Pacote VALUES ('"+key+"',"+value.getDesconto()+")";
            int i  = stm.executeUpdate(sql);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que insere num pacote as caraterísticas que estão relacionadas com este e com as peças
     * 
     * @param key chave que dá acesso à peça e ao pacote
     * 
     * @param value pacote que recebe as caraterísticas
     * 
     * @author Eu
     */
    public void putPecaPacote(String key, Pacote value){
        try {
            Statement stm = conn.createStatement();
            for(String str: value.getPecas()){
                String s = "Insert Peca_Pacote Values ('"+key+"','"+str+"')";
                stm.executeUpdate(s);
            }
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
        /**
     * Método que permite obter as caraterísticas do pacote
     * 
     * @param key chave que dá acesso ao pacote
     * 
     * @author Eu
     */
    @Override
    public Pacote get(Object key) {
        try {
            Pacote p = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Pacote WHERE Nome='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                p = new Pacote();
                p.setNome((String)key);
                p.setDesconto(rs.getFloat("Desconto"));
                this.getPecasPacote(p);
            }
            return p;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
        /**
     * Método que obtém as peças disponíveis num pacote
     * 
     * @param p pacote a ser verificado
     * 
     * @author Eu
     */
    public void getPecasPacote(Pacote p){
        try {
            String key = p.getNome();
            Statement stm = conn.createStatement();
            String str = "Select * From Peca_Pacote Where Pacote_Nome='"+key+"'";
            ResultSet res = stm.executeQuery(str);
            List<String> pecas = new ArrayList<>();
            while(res.next()){
                String peca = res.getString("Peca_Nome");
                pecas.add(peca);
            }
            p.setPecas(pecas);
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
            String sql = "SELECT * FROM Pacote WHERE Nome='"+(String)key+"'";
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
            String sql = "SELECT Nome FROM Pacote";
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
    * Método que obtém os pacotes disponíveis para um modelo
    * 
    * @param m modelo no qual se pretende verificar os pacotes
    */
    public void getPacoteModelo(Modelo m){
        try {
            List<Pacote> pacotes = new ArrayList<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Pacote_Nome FROM Pacote_Modelo Where Modelo_Nome='"+m.getNome()+"'");
            while(rs.next()){
                String nome = rs.getString("Pacote_Nome");
                Pacote p = this.get(nome);
                pacotes.add(p);
            }
            m.setPacotes(pacotes);
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
}
