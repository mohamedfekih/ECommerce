package com.ebiznext.ecommerce.model;

import java.util.ArrayList;
import java.util.List;



public class Panier {
    private Integer id;
	private List<LinePanier> linesPanier;
	
	 public Panier(Integer id)
	    {
		 this.id=id;
	    }
	
	 public Panier()
	    {
		 linesPanier = new ArrayList<LinePanier>();
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	 
	public List<LinePanier> getLinesPanier() {
		return linesPanier;
	}

	public void setLinesPanier(List<LinePanier> linesPanier) {
		this.linesPanier = linesPanier;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linesPanier == null) ? 0 : linesPanier.hashCode());
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
		Panier other = (Panier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linesPanier == null) {
			if (other.linesPanier != null)
				return false;
		} else if (!linesPanier.equals(other.linesPanier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", linesPanier=" + linesPanier + "]";
	}


	 
}
