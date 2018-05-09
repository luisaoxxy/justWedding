package es.justWeddings.dao;

import java.util.List;

import es.justWeddings.domain.Outlays;

public interface SuppliersDao{


	public List<Outlays> findSupliersByWedding(String weddingId);
}