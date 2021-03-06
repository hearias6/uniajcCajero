package edu.uniajc.banco.app.entity;
// Generated 8/04/2019 05:09:58 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;

/**
 * LogTrasaccion generated by hbm2java
 */
public class LogTrasaccion implements java.io.Serializable {

	private int idLogTrasaccion;
	private Cuenta cuenta;
	private Date fecha;
	private String hora;
	private Integer idCajero;
	private String consignatario;
	private String monto;
	private String estado;

	public LogTrasaccion() {
	}

	public LogTrasaccion(int idLogTrasaccion) {
		this.idLogTrasaccion = idLogTrasaccion;
	}

	public LogTrasaccion(int idLogTrasaccion, Cuenta cuenta, Date fecha, String hora, Integer idCajero,
			String consignatario, String monto, String estado) {
		this.idLogTrasaccion = idLogTrasaccion;
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.hora = hora;
		this.idCajero = idCajero;
		this.consignatario = consignatario;
		this.monto = monto;
		this.estado = estado;
	}

	public int getIdLogTrasaccion() {
		return this.idLogTrasaccion;
	}

	public void setIdLogTrasaccion(int idLogTrasaccion) {
		this.idLogTrasaccion = idLogTrasaccion;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getIdCajero() {
		return this.idCajero;
	}

	public void setIdCajero(Integer idCajero) {
		this.idCajero = idCajero;
	}

	public String getConsignatario() {
		return this.consignatario;
	}

	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}

	public String getMonto() {
		return this.monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
