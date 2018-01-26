package org.sid.web.springMVC;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class EtudiantWebServiceRest2 {

	@Autowired
	private EtudiantRepository er;
	
	@RequestMapping(value="/etudiants" , method=RequestMethod.GET)
	public List<Etudiant> list()
	{
		return er.findAll();
	}
	
	@RequestMapping(value="/etudiants/{id}",method=RequestMethod.GET)
	public Etudiant getOne(@PathVariable(value="id") Long id)
	{
		return er.findOne(id);
	}
	@RequestMapping(value="/etudiants",method=RequestMethod.POST)
	public Etudiant add(@RequestBody Etudiant e)
	{
		return er.save(e);
	}
	
	@RequestMapping(value="/etudiants/{id}",method=RequestMethod.PUT)
	public Etudiant replace(@PathVariable(value="id") Long id ,@RequestBody Etudiant e)
	{
		e.setId(id);
		return er.save(e);
	}
	
	@RequestMapping(value="/etudiants/{id}",method=RequestMethod.PATCH)
	public Etudiant update(@PathVariable(value="id") Long id ,@RequestBody Etudiant e)
	{
		Etudiant ee = er.findOne(id);
		if(e.getNom()!=null)
		{
			ee.setNom(e.getNom());
		}
		if(e.getPrenom()!=null)
		{
			ee.setPrenom(e.getPrenom());
		}
		if(e.getFormation()!=null)
		{
			ee.setFormation(e.getFormation());
		}
		return er.save(ee);
	}
	
	@RequestMapping(value="/etudiants/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable(value="id") Long id)
	{
		try
		{
			er.delete(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
}
