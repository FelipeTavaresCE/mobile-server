package br.com.clubprivate.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_voto", schema = "authentication")
@AttributeOverride(name = "id", column = @Column(name = "id_voto"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "authentication.voto_id_seq", allocationSize = 1)
public class Votacao extends AbstractModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3891838597208174573L;

	@NotNull
	@Column(name="VOTO_NUM_VOTOS")
	private Long votos;

	@NotNull
	@Column(name="VOTO_NUM_PONTOS")
	private Long pontos;

	@ManyToOne
	@JsonIgnore
	private Acompanhante acompanhante;

	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVotos() {
		return votos;
	}

	public void setVotos(Long votos) {
		this.votos = votos;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

 }
