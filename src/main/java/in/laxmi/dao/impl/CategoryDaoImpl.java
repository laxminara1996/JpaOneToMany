package in.laxmi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.laxmi.dao.CategoryDao;
import in.laxmi.entity.CategoryEntity;

public class CategoryDaoImpl implements CategoryDao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	public void saveCategory(CategoryEntity entity) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		try {
			em.persist(entity);
			t.commit();
			System.out.println("category with Products are Persisted");
		}catch(Exception e){
			t.rollback();
			e.printStackTrace();
			
		}
		finally {
			em.close();
		}
		
	}

	public CategoryEntity fetchCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
        CategoryEntity entity=em.find(CategoryEntity.class, categoryId);
        em.close();
		return entity;
	}

	public void removeCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
        CategoryEntity entity=em.find(CategoryEntity.class, categoryId);
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        try {
        	em.remove(entity);
        	tx.commit();
        }catch(Exception e) {
        	tx.rollback();
        	e.printStackTrace();
        }
		
	}

}
