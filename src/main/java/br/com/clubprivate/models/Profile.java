package br.com.clubprivate.models;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_profile", schema = "authentication")
@AttributeOverride(name = "id", column = @Column(name = "id_profile"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "authentication.profile_id_seq", allocationSize = 1)
public class Profile extends AbstractModel implements Serializable {

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "profiles")
    private List<User> users;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
