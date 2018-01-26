package org.sid.web.springMVC;

import java.util.List;

import org.sid.dao.entity.Formation;
import org.sid.dao.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Component
@RestController
public class FormationWebServiceRest2 {

	@Autowired
	private FormationRepository fr;
	
	@RequestMapping(value="/formations",method=RequestMethod.GET)
	public List<Formation> list()
	{
		return fr.findAll();
	}
	
	@RequestMapping(value="/formations/{id}",method=RequestMethod.GET)
	public Formation getOne(@PathVariable(value="id") Long id)
	{
		return fr.findOne(id);
	}
	@RequestMapping(value="/formations",method=RequestMethod.POST)
	public Formation add(@RequestBody Formation f)
	{
		return fr.save(f);
	}
	
	@RequestMapping(value="/formations/{id}",method=RequestMethod.PUT)
	public Formation replace(@PathVariable(value="id") Long id ,@RequestBody Formation f)
	{
		f.setId(id);
		return fr.save(f);
	}
	
	@RequestMapping(value="/formations/{id}",method=RequestMethod.PATCH)
	public Formation update(@PathVariable(value="id") Long id ,@RequestBody Formation f)
	{
		Formation ff = fr.findOne(id);
		if(f.getDuree()!=0)
		{
			ff.setDuree(f.getDuree());
		}
		if(f.getNom()!=null){
			ff.setNom(f.getNom());
		}
		if(f.getEtudiants()!=null)
		{
			ff.setEtudiants(f.getEtudiants());
		}
		return fr.save(ff);
	}
	
	@RequestMapping(value="/formations/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable(value="id") Long id)
	{
		try{
			fr.delete(id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}
	
}
