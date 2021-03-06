package edu.uniajc.banco.app.entity;
// Generated 8/04/2019 05:09:58 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

/**
 * Tarjeta generated by hbm2java
 */
public class Tarjeta implements java.io.Serializable {

	private int idTarjeta;
	private String nombre;
	private String tipoTarjeta;
	private String password;
	private String bloqueo;
	private Set cuentas = new HashSet(0);

	public Tarjeta() {
	}

	public Tarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Tarjeta(int idTarjeta, String nombre, String tipoTarjeta, String password, String bloqueo, Set cuentas) {
		this.idTarjeta = idTarjeta;
		this.nombre = nombre;
		this.tipoTarjeta = tipoTarjeta;
		this.password = password;
		this.bloqueo = bloqueo;
		this.cuentas = cuentas;
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoTarjeta() {
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBloqueo() {
		return this.bloqueo;
	}

	public void setBloqueo(String bloqueo) {
		this.bloqueo = bloqueo;
	}

	public Set getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(Set cuentas) {
		this.cuentas = cuentas;
	}

}
