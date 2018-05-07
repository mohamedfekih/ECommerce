package com.ebiznext.ecommerce.model;

public class Transaction {
	private Integer id;
	private boolean status;
	private Panier panier;
	
	private Transaction() {
		
	}
	
	private Transaction(boolean status, Panier panier) {
		this.status=status;
		this.panier=panier;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the panier
	 */
	public Panier getPanier() {
		return panier;
	}

	/**
	 * @param panier the panier to set
	 */
	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((panier == null) ? 0 : panier.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (panier == null) {
			if (other.panier != null)
				return false;
		} else if (!panier.equals(other.panier))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
	
}
