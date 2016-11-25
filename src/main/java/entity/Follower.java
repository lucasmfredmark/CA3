package entity;

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
    @NamedQuery(name = "Follower.findAll", query = "SELECT f FROM Follower f"),
    @NamedQuery(name = "Follower.findByOwner", query = "SELECT f FROM Follower f WHERE f.user = :username"),
    @NamedQuery(name = "Follower.findById", query = "SELECT f FROM Follower f WHERE f.id = :id")})
public class Follower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "fk_user_follow_username", referencedColumnName = "username")
    @ManyToOne
    private User followUser;
    @JoinColumn(name = "fk_user_username", referencedColumnName = "username")
    @ManyToOne
    private User user;

    public Follower() {
    }

    public Follower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFollowUser() {
        return followUser;
    }

    public void setFollowUser(User followUser) {
        this.followUser = followUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Follower)) {
            return false;
        }
        Follower other = (Follower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Follower[ id=" + id + " ]";
    }
    
}
