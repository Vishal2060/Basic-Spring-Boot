package org.dance.query;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
 

public class PersonListener {

	@PrePersist
	public void prePersist(Person person) {
		System.out.println("prePersist");
	}

	@PostPersist
	public void postPersist(Person person) {
		System.out.println("postPersist");
	}

	@PreUpdate
	public void preUpdate(Person person) {
		System.out.println("preUpdate");
	}

	@PostUpdate
	public void postUpdate(Person person) {
		System.out.println("postUpdate");
	}

	@PreRemove
	public void preRemove(Person person) {
		System.out.println("preRemove");
	}

	@PostRemove
	public void postRemove(Person person) {
		System.out.println("postRemove");
	}

	@PostLoad
	public void postLoad(Person person) {
		System.out.println("postLoad");
	}
}
