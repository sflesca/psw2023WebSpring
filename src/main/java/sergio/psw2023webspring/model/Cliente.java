package sergio.psw2023webspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Cliente extends Persona{
    @Basic
    private String tessera;

    public String getTessera() {
        return tessera;
    }

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Collection<Ordine> ordini;

    public Collection<Ordine> getOrdini() {
        return ordini;
    }


    public void setOrdini(Collection<Ordine> ordini) {
        this.ordini = ordini;
    }
}
