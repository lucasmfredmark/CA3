package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import security.IUser;
import security.PasswordStorage;

/**
 *
 * @author lucasmfredmark
 */
@Entity
@Table(name="tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByPasswordhash", query = "SELECT u FROM User u WHERE u.passwordhash = :passwordhash"),
    @NamedQuery(name = "User.findByPoints", query = "SELECT u FROM User u WHERE u.points = :points")})
public class User implements IUser, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 255)
    @Column(name = "passwordhash")
    private String passwordhash;
    @Column(name = "points")
    private Integer points;
    @ManyToMany(mappedBy = "userList")
    private List<Role> roleList;
    @OneToMany(mappedBy = "user")
    private List<Pokemon> pokemonList;
    @OneToMany(mappedBy = "user")
    private List<Team> teamList;
    @OneToMany(mappedBy = "followUser")
    private List<Follower> followerList;
    @OneToMany(mappedBy = "user")
    private List<Follower> followerList1;

    public User() {
    }

    public User(String username, String password) throws PasswordStorage.CannotPerformOperationException {
        this.username = username;
        this.passwordhash = PasswordStorage.createHash(password);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Integer getPoints() {
        return points;
    }

    public void addPoints(Integer points) {
        this.points += points;
    }
    
    public void removePoints(Integer points) {
        this.points -= points;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public void addRole(Role role) {
        if (roleList == null) {
            roleList = new ArrayList();
        }
        roleList.add(role);
        role.addUser(this);
    }

    @XmlTransient
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    
    public void addPokemon(Pokemon pokemon){
        this.pokemonList.add(pokemon);
    }

    @XmlTransient
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @XmlTransient
    public List<Follower> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<Follower> followerList) {
        this.followerList = followerList;
    }

    @XmlTransient
    public List<Follower> getFollowerList1() {
        return followerList1;
    }

    public void setFollowerList1(List<Follower> followerList1) {
        this.followerList1 = followerList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ username=" + username + " ]";
    }

    @Override
    public List<String> getRolesAsStrings() {
        if (roleList.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList();
        for (Role role : roleList) {
            rolesAsStrings.add(role.getRolename());
        }
        return rolesAsStrings;
    }

    @Override
    public String getUserName() {
        return getUsername();
    }

    @Override
    public String getPassword() {
        return passwordhash;
    }

    public void setPassword(String password) throws PasswordStorage.CannotPerformOperationException {
        this.passwordhash = PasswordStorage.createHash(password);
    }

}
