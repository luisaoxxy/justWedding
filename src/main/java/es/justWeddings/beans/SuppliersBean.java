package es.justWeddings.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Suppliers;
import es.justWeddings.domain.Suppliers4wedding;
import es.justWeddings.services.SuppliersService;
import es.justWeddings.utils.Constants;

@Component
@ViewScoped
public class SuppliersBean {

	private TreeNode suppliersTree;
    
    private TreeNode selectedSupplier;
    
    private boolean confirmed; 
    private double estimation; 
    private double finalPrice;
    private double paid;
    private String notes;
    private String name;
    
    @Autowired
	private SuppliersService suppliersService;
    @Autowired
    private GroomsBean groomsBean;
    
    @PostConstruct
    public void init() {
    	suppliersTree =   suppliersService.getSupplierTree(groomsBean.getWeddingId());
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
    	selectedSupplier = event.getTreeNode();
    	if(selectedSupplier.getData() instanceof Suppliers4wedding) {
    		Suppliers4wedding sup = (Suppliers4wedding) selectedSupplier.getData();
    		confirmed = sup.getConfirmed().equals(Constants.YES);
    		estimation = sup.getEstimatedPrice();
    		finalPrice = sup.getFinalPrice();
    		paid = sup.getAmountPaid();
    		notes = sup.getNotes();
    		name = sup.getName();
    	}else{
    		confirmed = false;
    		estimation= 0;
    		finalPrice= 0;
    		paid= 0;
    		notes = "";
    		name = "";
    	}
    }
    
    public void updateSuplier(){
    	Suppliers4wedding selected = null;
    	if(selectedSupplier.getData() instanceof Suppliers4wedding) {
    		selected = (Suppliers4wedding)selectedSupplier.getData();
    	}else{
    		selected = new Suppliers4wedding();
    		selected.setSupplier((Suppliers)selectedSupplier.getData());
    		TreeNode childNode = new DefaultTreeNode(Constants.LEAF,selected,selectedSupplier);
    	}
    	selected.setAmountPaid(paid);
    	selected.setConfirmed(confirmed ? Constants.YES : Constants.NO);
    	selected.setEstimatedPrice(estimation);
    	selected.setFinalPrice(finalPrice);
    	selected.setName(name);
    	selected.setNotes(notes);
    }
    
	public TreeNode getSuppliersTree() {
		return suppliersTree;
	}

	public void setSuppliersTree(TreeNode suppliersTree) {
		this.suppliersTree = suppliersTree;
	}

	public TreeNode getSelectedSupplier() {
		return selectedSupplier;
	}

	public void setSelectedSupplier(TreeNode selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public double getEstimation() {
		return estimation;
	}

	public void setEstimation(double estimation) {
		this.estimation = estimation;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}