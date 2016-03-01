package br.com.clubprivate.models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user", schema = "authentication")
@AttributeOverride(name = "id", column = @Column(name = "id_user"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "authentication.user_id_seq", allocationSize = 1)
public class User extends AbstractModel implements Serializable {

	private static final long serialVersionUID = -2575224775520822854L;

	@NotNull
	private String name;

	@NotNull
	private int age;

	@Lob
	private byte[] photo;

	@JoinTable(schema = "authentication", name = "tb_user_tb_profile",
			joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id_user")},
			inverseJoinColumns = {@JoinColumn(name = "id_profile", referencedColumnName = "id_profile")})
	@ManyToMany(cascade = CascadeType.MERGE, targetEntity = Profile.class, fetch = FetchType.EAGER)
	private List<Profile> profiles;

	@OneToMany(mappedBy="user")
	private List<Votacao> votacao;

	private boolean bloqueado;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Profile> getProfiles() {
		if (profiles == null) {
			profiles = new ArrayList<>();
		}
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Votacao> getVotacao() {
		return votacao;
	}

	public void setVotacao(List<Votacao> votacao) {
		this.votacao = votacao;
	}

	public boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
