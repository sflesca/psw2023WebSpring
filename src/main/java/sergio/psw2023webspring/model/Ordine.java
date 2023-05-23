package sergio.psw2023webspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

@Entity
public class Ordine {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordine_id")
    private Collection<DettaglioOrdine> dettagli = new LinkedList<>();

    public Collection<DettaglioOrdine> getDettagli() {
        return dettagli;
    }

    public void setDettagli(Collection<DettaglioOrdine> dettagli) {
        this.dettagli = dettagli;
    }
}
