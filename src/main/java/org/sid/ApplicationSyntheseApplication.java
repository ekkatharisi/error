package org.sid;

import java.util.ArrayList;
import org.sid.dao.entity.Etudiant;
import org.sid.dao.entity.Formation;
import org.sid.dao.repository.EtudiantRepository;
import org.sid.dao.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationSyntheseApplication implements CommandLineRunner {

	@Autowired
	private EtudiantRepository er;
	@Autowired
	private FormationRepository fr;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationSyntheseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// les formations
		Formation f = new Formation();
		f.setDuree(30);
		f.setNom("JEE");
		f.setEtudiants(new ArrayList<Etudiant>());
		fr.save(f);
		Formation f2 = new Formation();
		f2.setDuree(60);
		f2.setNom("Oracle");
		f2.setEtudiants(new ArrayList<Etudiant>());
		fr.save(f2);
		Formation f3 = new Formation();
		f3.setDuree(45);
		f3.setNom("dotNet");
		f3.setEtudiants(new ArrayList<Etudiant>());
		fr.save(f3);
		Formation f4 = new Formation();
		f4.setDuree(32);
		f4.setNom("Java");
		f4.setEtudiants(new ArrayList<Etudiant>());
		fr.save(f4);
		//les etudiants
		Etudiant e = new Etudiant(); 
		e.setFormation(f);
		e.setNom("chaabaoui");
		e.setPrenom("aymene");
		er.save(e);
		Etudiant e2 = new Etudiant(); 
		e2.setFormation(f);
		e2.setNom("chaabaoui");
		e2.setPrenom("adnane");
		er.save(e2);
		Etudiant e4 = new Etudiant(); 
		e4.setFormation(f);
		e4.setNom("manaf");
		e4.setPrenom("nabil");
		er.save(e4);
		Etudiant e3 = new Etudiant(); 
		e3.setFormation(f2);
		e3.setNom("abass");
		e3.setPrenom("alaoui");
		er.save(e3);
		Etudiant e5 = new Etudiant(); 
		e5.setFormation(f2);
		e5.setNom("youssefi");
		e5.setPrenom("mohamed");
		er.save(e5);
		Etudiant e6 = new Etudiant(); 
		e6.setFormation(f3);
		e6.setNom("chaabaoui");
		e6.setPrenom("aymene");
		er.save(e6);
		
		f = fr.findByNomFormation("JEE");
		f.getEtudiants().add(e);
		f.getEtudiants().add(e2);
		f.getEtudiants().add(e4);
		fr.save(f);
		f2 = fr.findByNomFormation("Oracle");
		f2.getEtudiants().add(e5);
		f2.getEtudiants().add(e3);
		fr.save(f2);
		f3 = fr.findByNomFormation("dotNet");
		f3.getEtudiants().add(e6);
		fr.save(f3);
		
	}
	
	
}
