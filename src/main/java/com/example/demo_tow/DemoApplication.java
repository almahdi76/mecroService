package com.example.demo_tow;

import com.example.demo_tow.model.Produit;
import com.example.demo_tow.repo.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final ProduitRepo produirRepo;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public DemoApplication(ProduitRepo produirRepo) {
		this.produirRepo = produirRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
//		produirRepo.save(new Produit(null,"LG 15",1500.22));
//		produirRepo.save(new Produit(null,"Hp 15",373.));
//		produirRepo.save(new Produit(null,"Nokia",3000.77));
	}
}
