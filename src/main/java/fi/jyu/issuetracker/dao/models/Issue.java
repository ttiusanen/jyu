package fi.jyu.issuetracker.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

@Entity
@Table(name = "Issue")
public class Issue implements Serializable {
	
	/**
	 * Auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -7975098490590780899L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "description")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return id + ", " + description;
		
	}
	
}
