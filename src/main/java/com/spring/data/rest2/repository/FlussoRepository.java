package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import com.spring.data.rest2.entities.FlussoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "FlussoEntity", path = "flusso", excerptProjection = FlussoProjection.class)
public interface FlussoRepository extends PagingAndSortingRepository<FlussoEntity, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page<FlussoEntity> findByNameStartsWith(@Param("name") String name, Pageable p);

    List<FlussoProjection> findAllById(Long id);
}
