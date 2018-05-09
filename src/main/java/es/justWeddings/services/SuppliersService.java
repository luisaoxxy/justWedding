package es.justWeddings.services;

import java.util.List;

import org.primefaces.model.TreeNode;

import es.justWeddings.domain.Outlays4wedding;

public interface SuppliersService {


  public TreeNode getSupplierTree(String weddingId,List<Outlays4wedding> outLays);

}
