package entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucasmfredmark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p"),
    @NamedQuery(name = "Pokemon.findById", query = "SELECT p FROM Pokemon p WHERE p.id = :id"),
    @NamedQuery(name = "Pokemon.findByPokedexId", query = "SELECT p FROM Pokemon p WHERE p.pokedexId = :pokedexId")})
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pokedex_id")
    private Integer pokedexId;
    @JoinColumn(name = "fk_team_id", referencedColumnName = "id")
    @ManyToOne
    @Expose(serialize = false)
    private Team fkTeamId;
    @JoinColumn(name = "fk_user_username", referencedColumnName = "username")
    @ManyToOne
    @Expose(serialize = false)
    private User fkUserUsername;

    public Pokemon() {
    }

    public Pokemon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public Team getFkTeamId() {
        return fkTeamId;
    }

    public void setFkTeamId(Team fkTeamId) {
        this.fkTeamId = fkTeamId;
    }

    public User getFkUserUsername() {
        return fkUserUsername;
    }

    public void setFkUserUsername(User fkUserUsername) {
        this.fkUserUsername = fkUserUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pokemon[ id=" + id + " ]";
    }
    
}
