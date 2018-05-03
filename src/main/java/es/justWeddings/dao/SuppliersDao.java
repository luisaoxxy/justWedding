package es.justWeddings.dao;

import java.util.List;

import es.justWeddings.domain.Suppliers;

public interface SuppliersDao{


	public List<Suppliers> findSupliersByWedding(String weddingId);
}