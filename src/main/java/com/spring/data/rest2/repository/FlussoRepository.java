package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "FlussoEntity", path = "performanceMensile")
public interface FlussoRepository extends PagingAndSortingRepository<FlussoEntity, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page<FlussoEntity> findByNameStartsWith(@Param("name") String name, Pageable p);
}
