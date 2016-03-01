package br.com.clubprivate.models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_acompanhante", schema = "authentication")
@AttributeOverride(name = "id", column = @Column(name = "id_acom"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "authentication.acom_id_seq", allocationSize = 1)
public class Acompanhante extends AbstractModel implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -3159603647992379097L;

	@NotNull
	@Column(name="ACOM_NOME")
	private String nome;

	@NotNull
	@Column(name="ACOM_IDADE")
	private Integer idade;

	@Lob
	@Column(name="ACOM_IMAGE")
	private byte[] photo;

//	@NotNull
	@Column(name="ACOM_PHONE_PRIMARIO")
	private String celularPrimario;

	@Column(name="ACOM_PHONE_SECUNDARIO")
	private String celularSecundario;

	@Column(name="ACOM_WHATSAPP")
	private String whatsApp;

	@NotNull
	@Column(name="ACOM_ALTURA")
	private Double altura;

	@NotNull
	@Column(name="ACOM_QUADRIL")
	private Double quadril;

	@Column(name="ACOM_VALOR")
	private BigDecimal valor;

//	@NotNull
	@Column(name="ACOM_LOCAIS")
	private String locais;

//	@NotNull
	@Column(name="ACOM_PESO")
	private Double peso;

//	@NotNull
	@Column(name="ACOM_NUMERO_PES")
	private Integer numCalcado;

	@Column(name="ACOM_OBERVACAO")
	private String obs;

	@JsonIgnore
	@OneToMany(mappedBy="acompanhante", cascade = CascadeType.ALL)
	private List<Votacao> votacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getCelularPrimario() {
		return celularPrimario;
	}

	public void setCelularPrimario(String celularPrimario) {
		this.celularPrimario = celularPrimario;
	}

	public String getCelularSecundario() {
		return celularSecundario;
	}

	public void setCelularSecundario(String celularSecundario) {
		this.celularSecundario = celularSecundario;
	}

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getQuadril() {
		return quadril;
	}

	public void setQuadril(Double quadril) {
		this.quadril = quadril;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getLocais() {
		return locais;
	}

	public void setLocais(String locais) {
		this.locais = locais;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getNumCalcado() {
		return numCalcado;
	}

	public void setNumCalcado(Integer numCalcado) {
		this.numCalcado = numCalcado;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Votacao> getVotacao() {
		return votacao;
	}

	public void setVotacao(List<Votacao> votacao) {
		this.votacao = votacao;
	}

}
