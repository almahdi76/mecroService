package com.example.demo_tow.repo;

import com.example.demo_tow.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepo extends JpaRepository<Produit,Long> {

    @RestResource(path = "/byname")
    public Collection<Produit>findByNameProd(@Param("mc") String npd);

    @RestResource(path = "/world")
    public Collection<Produit>findByNameProdContains(@Param("mc") String npd);

    @RestResource(path = "/byPage")
    public Page<Produit> findByNameProdContains(@Param("mc") String npd,Pageable pageable);
}
