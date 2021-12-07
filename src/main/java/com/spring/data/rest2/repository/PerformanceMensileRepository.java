package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.PerformanceMensile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "PerformanceMensile", path = "performanceMensile")
public interface PerformanceMensileRepository extends PagingAndSortingRepository<PerformanceMensile, Long> {
}
