package org.sid.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements  Serializable {
	//@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	//@ManyToOne
	//@JoinColumn(name="id_formation")
	private Formation formation;
}
