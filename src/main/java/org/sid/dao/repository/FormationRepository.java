package org.sid.dao.repository;

import org.sid.dao.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(collectionResourceRel="formationData",path="formations")
public interface FormationRepository extends JpaRepository<Formation, Long>{

	//@RestResource(path="/parNom")
	@Query("select f from Formation f where f.nom = :nom")
	public Formation findByNomFormation(@Param("nom") String x );
	
}
