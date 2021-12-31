package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.AffidoDiFlussoEntity;
import com.spring.data.rest2.entities.FlussoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "AffidoDiFlussoEntity", path = "affidoDiFlusso")
public interface AffidoDiFlussoRepository extends PagingAndSortingRepository<AffidoDiFlussoEntity, Long> {

    //    http://localhost:8080/flusso/search/nameStartsWith?affido=su&sort=name,desc
    @RestResource(path = "affidoStartsWith", rel = "affidoStartsWith")
    Page<FlussoEntity> findByAffidoStartsWith(@Param("affido") String affido, Pageable p);
}
