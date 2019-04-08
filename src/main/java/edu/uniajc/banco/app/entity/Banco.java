package edu.uniajc.banco.app.entity;
// Generated 8/04/2019 05:09:58 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity()
@Table (name="banco")
public class Banco implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="idBANCO")
	private int idBanco;
	
	@NotNull
	@NotEmpty
	@Column(name="nit")
	private String nit;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
	private Set cuentas = new HashSet(0);

	public Banco() {
	}

	public Banco(int idBanco, String nit, String nombre, String telefono) {
		this.idBanco = idBanco;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Banco(int idBanco, String nit, String nombre, String telefono, Set cuentas) {
		this.idBanco = idBanco;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		this.cuentas = cuentas;
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(Set cuentas) {
		this.cuentas = cuentas;
	}

}
