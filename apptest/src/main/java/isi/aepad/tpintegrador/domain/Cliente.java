package isi.aepad.tpintegrador.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@OneToOne
	private Localidad localidad;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Pedido> pedidosRealizados = new ArrayList<Pedido>(); 
	
	@OneToOne
	private MedioDePago medioDePago;
	
	private int pagosRealizados;

	private Double puntosAcumulados;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<Pedido> getPedidosRealizados() {
		return pedidosRealizados;
	}

	public void setPedidosRealizados(List<Pedido> pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Double getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(Double puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
	
	public int getPagosRealizados() {
		return pagosRealizados;
	}

	public void setPagosRealizados(int pagosRealizados) {
		this.pagosRealizados = pagosRealizados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((medioDePago == null) ? 0 : medioDePago.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + pagosRealizados;
		result = prime * result + ((pedidosRealizados == null) ? 0 : pedidosRealizados.hashCode());
		result = prime * result + ((puntosAcumulados == null) ? 0 : puntosAcumulados.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (medioDePago == null) {
			if (other.medioDePago != null)
				return false;
		} else if (!medioDePago.equals(other.medioDePago))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pagosRealizados != other.pagosRealizados)
			return false;
		if (pedidosRealizados == null) {
			if (other.pedidosRealizados != null)
				return false;
		} else if (!pedidosRealizados.equals(other.pedidosRealizados))
			return false;
		if (puntosAcumulados == null) {
			if (other.puntosAcumulados != null)
				return false;
		} else if (!puntosAcumulados.equals(other.puntosAcumulados))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", pedidosRealizados="
				+ pedidosRealizados + ", medioDePago=" + medioDePago + ", pagosRealizados=" + pagosRealizados
				+ ", puntosAcumulados=" + puntosAcumulados + "]";
	}
	
	
}
