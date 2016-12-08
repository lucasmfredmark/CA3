/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucasmfredmark
 */
@Entity
@Table(name = "pokemon_prices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PokemonPrice.findAll", query = "SELECT p FROM PokemonPrice p"),
    @NamedQuery(name = "PokemonPrice.findByPokedexId", query = "SELECT p FROM PokemonPrice p WHERE p.pokedexId = :pokedexId"),
    @NamedQuery(name = "PokemonPrice.findByPrice", query = "SELECT p FROM PokemonPrice p WHERE p.price = :price")})
public class PokemonPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pokedex_id")
    private Integer pokedexId;
    @Column(name = "price")
    private Integer price;

    public PokemonPrice() {
    }

    public PokemonPrice(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pokedexId != null ? pokedexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PokemonPrice)) {
            return false;
        }
        PokemonPrice other = (PokemonPrice) object;
        if ((this.pokedexId == null && other.pokedexId != null) || (this.pokedexId != null && !this.pokedexId.equals(other.pokedexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PokemonPrice[ pokedexId=" + pokedexId + " ]";
    }
    
}
