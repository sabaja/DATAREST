package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:8000/")
@RepositoryRestResource(collectionResourceRel = "Phone", path = "phones")
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {

    @Override
    Optional<Phone> findById(Long id);
}
