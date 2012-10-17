package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;


/**
 * The persistent class for the SCHUHE database table.
 * 
 */
@Entity
@Table(name="SCHUHE", schema = "SCHUHLADEN")
public class Schuh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String gender;

	@Column(name="\"größe\"")
	private int größe;

	private int menge;

	@Column(name="\"preis\"")
	private BigDecimal preis;

	//bi-directional many-to-one association to Marke
	@ManyToOne
	private Marke marken;

	public Schuh() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGröße() {
		return this.größe;
	}

	public void setGröße(int größe) {
		this.größe = größe;
	}

	public int getMenge() {
		return this.menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public BigDecimal getPreis() {
		return this.preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	public Marke getMarken() {
		return this.marken;
	}

	public void setMarken(Marke marken) {
		this.marken = marken;
	}
	public String toString(){
		return "#"+getId()+"-"+getPreis()+"€-"+getGender()+"-"+getGröße();
	}

}