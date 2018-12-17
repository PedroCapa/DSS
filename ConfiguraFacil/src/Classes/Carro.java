package Classes;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Carro {
    private String id;
    private int estado;
    private List<String> pecas;
    private float custo;
    private LocalDate data;

    public Carro(String id, int estado, List<String> pecas, float custo, LocalDate data) {
        this.pecas = new ArrayList<>();
        for(String s: pecas)
            pecas.add(s);
        this.id = id;
        this.estado = estado;
        this.custo = custo;
        this.data = data;
    }

    public Carro() {
        this.pecas = new ArrayList<>();
        this.custo = 0;
        this.id = "";
        this.estado = 0;
        this.data = LocalDate.now();
    }
    
    public Carro(Carro umCarro){
        this.id = umCarro.getId();
        this.estado = umCarro.getEstado();
        this.pecas = umCarro.getPecas();
        this.custo = umCarro.getCusto();
        this.data = umCarro.getData();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
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
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public Carro clone(){
        return new Carro(this);
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
        return (this.pecas.equals(other.getPecas())  && this.custo != other.getCusto() && this.id.equals(other.getId())
                && this.estado == other.getEstado() && this.data.equals(other.getData()));
    }   
}
