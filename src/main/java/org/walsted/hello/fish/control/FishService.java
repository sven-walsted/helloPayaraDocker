	package org.walsted.hello.fish.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.walsted.hello.fish.entity.Fish;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FishService {

	@PersistenceContext(unitName = "fish")
	private EntityManager entityManager;

	public void create(Fish entity) {
		entityManager.persist(entity);
	}

	public Fish find(Long id) {
		Fish entity = entityManager.find(Fish.class, id);
		if (entity == null) {
			throw new EntityNotFoundException("No Fish found for id: " + id);
		}
		return entity;
	}
	
	public Fish update(Fish entity) {
		Fish merged = entityManager.merge(entity);
		return merged;
	}
	
	public void delete(Long id) {
		Fish entity = find(id);
		entityManager.remove(entity);
	}
	
	public List<Fish> findAll() {
		try {
			TypedQuery<Fish> query = entityManager
					.createQuery("SELECT e FROM Fish e ORDER BY e.familyName, e.genusName, e.speciesName ASC", Fish.class);
			return query.getResultList();
		} catch(RuntimeException e) {
			throw new RuntimeException("Could not get list: "+ e.getMessage());
		}
	}
}
