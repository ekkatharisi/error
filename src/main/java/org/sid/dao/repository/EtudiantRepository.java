package org.sid.dao.repository;

import java.util.List;

import org.sid.dao.entity.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(collectionResourceRel="etudiantData",path="etudiants")
public interface EtudiantRepository extends JpaRepository<Etudiant , Long> {
	
	
	//@RestResource(path="/parNom")
	//@Query("select e from Etudiant e where LOWER(e.nom) like CONCAT(LOWER(':mc'),'%')")
	//public List<Etudiant> findByNomStartingWith(@Param("nom") String nom);
	
	
}
