package org.dance.query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="persons")
public interface PersonRepo extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>, PersonRepoCustom {

	@Query("SELECT p FROM Person p WHERE p.name= :name")
	List<Person> getAll(@Param(value = "name") String name);

}
