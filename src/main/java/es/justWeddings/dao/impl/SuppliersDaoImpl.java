package es.justWeddings.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.justWeddings.dao.SuppliersDao;
import es.justWeddings.domain.Suppliers;
@Repository
@Transactional
public class SuppliersDaoImpl implements SuppliersDao{

	
	@PersistenceContext
    private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Suppliers> findSupliersByWedding(String weddingId){
		StringBuilder sql = new StringBuilder("SELECT su FROM Suppliers su ");
		sql.append("LEFT JOIN FETCH su.supplier4wedding su4w WHERE su4w IS NULL  OR su4w.wedding.id= :weddingId");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("weddingId", weddingId);
		return query.getResultList();
	}
}