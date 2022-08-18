package com.example.demo_tow.restService;

import com.example.demo_tow.model.Produit;
import com.example.demo_tow.repo.ProduitRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/prod")
public class ProduitRestService {

    private final ProduitRepo produitRepo;

    public ProduitRestService(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    //@RequestMapping("/listProduits")
    @GetMapping(value = "/listProduits")
    public List<Produit> listProduits(){
       return produitRepo.findAll();
    }

    @GetMapping(value = "/listProduits/{id}")
    public Produit unProduit(@PathVariable(name="id") Long id){
       return produitRepo.findById(id).get();
    }

    @PutMapping(value = "/listProduits/{id}")
    public Produit update(@PathVariable(name="id") Long id,@RequestBody Produit p){
        p.setId(id);
        return produitRepo.save(p);
    }

    @PostMapping(value = "/listProduits")
    public Produit enregistrer (@RequestBody Produit p){

        return produitRepo.save(p);
    }

    @DeleteMapping(value = "/listProduits/{id}")
    public void delate(@PathVariable(name="id") Long id){

        produitRepo.deleteById(id);
    }
}
