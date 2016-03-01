package br.com.clubprivate.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {

    private static final long serialVersionUID = 7556233351149084008L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GENERATOR")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return (obj instanceof AbstractModel) ? (this.getId() == null ? this == obj
                : this.getId().equals(((AbstractModel) obj).getId()))
                : false;
    }

}
