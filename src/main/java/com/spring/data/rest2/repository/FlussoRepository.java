package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import com.spring.data.rest2.entities.PerformanceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "FlussoEntity", path = "flusso")
public interface FlussoRepository extends PagingAndSortingRepository<FlussoEntity, Long> {

    //    http://localhost:8080/flusso/search/nameStartsWith?name=su&sort=name,desc
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page<PerformanceEntity> findByNameStartsWith(@Param("name") String name, Pageable p);
}
