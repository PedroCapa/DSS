package Classes;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class Carro {
    private Modelo modelo;
    private String id;
    private int estado;
    private List<String> pecas;
    private float custo;
    private LocalDate data;
    private List<String> falta;
    private String cliente;
    
    public Carro(Modelo modelo, String id, int estado, List<String> pecas, float custo, LocalDate data, List<String> falta, String cliente) {
        this.modelo = modelo;
        this.pecas = new ArrayList<>();
        pecas.forEach((s) -> {
            this.pecas.add(s);
        });
        this.id = id;
        this.estado = estado;
        this.custo = custo;
        this.data = data;
        this.falta = new ArrayList<>();
        falta.forEach((s) -> {
            this.falta.add(s);
        });
        this.cliente = cliente;
    }

    public Carro() {
        this.modelo = new Modelo();
        this.pecas = new ArrayList<>();
        this.custo = 0;
        this.id = "";
        this.estado = 0;
        this.data = LocalDate.now();
        this.falta = new ArrayList<>();
    }
    
    public Carro(Carro umCarro){
        this.modelo = umCarro.getModelo();
        this.id = umCarro.getId();
        this.estado = umCarro.getEstado();
        this.pecas = umCarro.getPecas();
        this.custo = umCarro.getCusto();
        this.data = umCarro.getData();
        this.falta = umCarro.getFalta();
        this.cliente = umCarro.getCliente();
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = new Modelo(modelo);
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<String> getPecas() {
        return new ArrayList<>(this.pecas);
    }

    public void setPecas(List<String> pecas) {
        this.pecas = new ArrayList<>(pecas);
    }
    
    public float getCusto(){
        return this.custo;
    }
    
    public void setCusto(float custo){
        this.custo = custo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<String> getFalta() {
        return new ArrayList<>(this.falta);
    }

    public void setFalta(List<String> falta) {
       this.falta = new ArrayList<>(falta);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public Carro clone(){
        return new Carro(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Carro other = (Carro) obj;
        return (this.pecas.equals(other.getPecas())  && this.custo == other.getCusto() && this.id.equals(other.getId())
                && this.estado == other.getEstado() && this.data.equals(other.getData()) && this.cliente.equals(other.getCliente())
                && this.falta.equals(other.getFalta()) && this.modelo.equals(other.getModelo()));
    }

    @Override
    public String toString() {
        return "Carro{" + "modelo=" + modelo + ", id=" + id + ", estado=" + estado + ", pecas=" + pecas + ", custo=" + custo + ", data=" + data + ", falta=" + falta + '}';
    }
    
    public void carroPronto(){
        this.estado = 2;
    }
    
    public boolean remove(String nome){
        boolean flag;
        if(flag = this.falta.contains(nome)){
           this.falta.remove(nome);
           this.pecas.add(nome);            
        }
        if(this.falta.isEmpty())
            this.estado = 1;
        return flag;
    }
    
    public void addPecaCarro(String s){
        this.pecas.add(s);
    }
    
    public void addFaltaCarro(String s){
        this.falta.add(s);
    }
}