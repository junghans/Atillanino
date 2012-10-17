package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;


/**
 * The persistent class for the MARKEN database table.
 * 
 */
@Entity
@Table(name="MARKEN", schema = "SCHUHLADEN")
public class Marke implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	private int id;

	private String marke;

	private String typ;

	//bi-directional many-to-one association to Schuh
	@OneToMany(mappedBy="marken",cascade = { PERSIST, MERGE })
	private List<Schuh> schuhes;

	public Marke() {
		schuhes=new ArrayList<Schuh>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarke() {
		return this.marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public List<Schuh> getSchuhes() {
		return this.schuhes;
	}

	public void setSchuhes(List<Schuh> schuhes) {
		this.schuhes = schuhes;
	}

	public String toString(){
		String s=""+getMarke()+"-"+getTyp()+"-"+getId()+"\n"+getSchuhes().size()+": ";
		for (Schuh schuh : getSchuhes()) {
			s+=" "+schuh.getId()+" ["+schuh.toString()+"];";
		}
		return s;
	}

}