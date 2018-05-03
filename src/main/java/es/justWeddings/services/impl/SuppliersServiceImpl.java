package es.justWeddings.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.justWeddings.dao.SuppliersDao;
import es.justWeddings.domain.Suppliers;
import es.justWeddings.domain.Suppliers4wedding;
import es.justWeddings.services.SuppliersService;
import es.justWeddings.utils.Constants;

@Service
public class SuppliersServiceImpl implements SuppliersService {

	@Autowired
	private SuppliersDao suppliersDao;
	private static final Logger logger = Logger.getLogger(SuppliersServiceImpl.class.getSimpleName());
	

	@Override
	public TreeNode getSupplierTree(String weddingId) {
		List<Suppliers> suppliers = suppliersDao.findSupliersByWedding(weddingId);
		TreeNode root = new DefaultTreeNode();
		for (Suppliers suppIter : suppliers) {
			TreeNode nodeAux = new DefaultTreeNode(suppIter,root);
			if(suppIter.getSupplier4wedding() != null && !suppIter.getSupplier4wedding().isEmpty()){
				for (Suppliers4wedding sup4wed : suppIter.getSupplier4wedding()) {
					TreeNode childNode = new DefaultTreeNode(Constants.LEAF,sup4wed,nodeAux);
				}
			}
		}
		return root;
	}
	
	public SuppliersDao getGuestDao() {
		return suppliersDao;
	}

	public void setGuestDao(SuppliersDao suppliersDao) {
		this.suppliersDao = suppliersDao;
	}


}
