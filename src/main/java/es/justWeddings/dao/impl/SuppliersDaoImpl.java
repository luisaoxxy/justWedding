package es.justWeddings.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.justWeddings.dao.SuppliersDao;
import es.justWeddings.domain.Outlays;
@Repository
@Transactional
public class SuppliersDaoImpl implements SuppliersDao{

	
	@PersistenceContext
    private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Outlays> findSupliersByWedding(String weddingId){
		StringBuilder sql = new StringBuilder("SELECT su FROM Outlays su ");
		sql.append("LEFT JOIN FETCH su.outlays4wedding su4w WHERE su4w IS NULL  OR su4w.wedding.id= :weddingId");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("weddingId", weddingId);
		return query.getResultList();
	}
}