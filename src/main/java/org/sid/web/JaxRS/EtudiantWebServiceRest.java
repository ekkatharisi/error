package org.sid.web.JaxRS;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sid.dao.entity.Etudiant;
import org.sid.dao.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/scolarite")
public class EtudiantWebServiceRest {

	@Autowired
	private EtudiantRepository er;
	
	@GET
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> list()
	{
		return er.findAll();
	}
	@GET
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getOne(@PathParam(value="id") Long id)
	{
		return er.findOne(id);
	}
	
	@POST
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant add(Etudiant e)
	{
		return er.save(e);
	}
	
	@PUT
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant update(@PathParam(value="id") Long id , Etudiant e)
	{
		e.setId(id);
		return er.save(e);
	}
	
	@DELETE
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value="id") Long id)
	{
		er.delete(id);
	}
}
