package isi.aepad.tpintegrador.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrdenDeCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ORDENDECOMPRA")
	private Integer id;
	private Integer nro;
	private String fecha;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordenDeCompra", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<DetalleOrdenDeCompra> detalleOrdenDeCompra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNro() {
		return nro;
	}
	public void setNro(Integer nro) {
		this.nro = nro;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<DetalleOrdenDeCompra> getDetalleOrdenDeCompra() {
		return detalleOrdenDeCompra;
	}
	public void setDetalleOrdenDeCompra(List<DetalleOrdenDeCompra> detalleOrdenDeCompra) {
		this.detalleOrdenDeCompra = detalleOrdenDeCompra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((detalleOrdenDeCompra == null) ? 0 : detalleOrdenDeCompra.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nro == null) ? 0 : nro.hashCode());
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
		OrdenDeCompra other = (OrdenDeCompra) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (detalleOrdenDeCompra == null) {
			if (other.detalleOrdenDeCompra != null)
				return false;
		} else if (!detalleOrdenDeCompra.equals(other.detalleOrdenDeCompra))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nro == null) {
			if (other.nro != null)
				return false;
		} else if (!nro.equals(other.nro))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrdenDeCompra [id=" + id + ", nro=" + nro + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", detalleOrdenDeCompra=" + detalleOrdenDeCompra + "]";
	}
	
	
}
