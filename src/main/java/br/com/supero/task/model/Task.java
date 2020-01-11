package br.com.supero.task.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Task {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
    @Enumerated(EnumType.STRING)
	private Situacao situacao=Situacao.NOVA;
	private String descricao;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataConclusao;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataCancelamento;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
    @PrePersist
    protected void onCreate() {
    	dataAtualizacao = dataCriacao = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	dataAtualizacao = new Date();
    	if (this.situacao.getEstado()==40)
    		dataConclusao = new Date();
    }
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

    public String getSituacaoIcone() {
        return this.situacao.getAparencia();
    }



}
