package es.justWeddings.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Outlays;
import es.justWeddings.domain.Outlays4wedding;
import es.justWeddings.services.SuppliersService;
import es.justWeddings.utils.Constants;

@Component
@ViewScoped
public class SuppliersBean {

	private TreeNode suppliersTree;
    
    private TreeNode selectedSupplier;
    private List<Outlays4wedding> outLaysList;
    
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
    	outLaysList = new ArrayList<Outlays4wedding>();
    	suppliersTree =   suppliersService.getSupplierTree(groomsBean.getWeddingId(),outLaysList);
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
    	selectedSupplier = event.getTreeNode();
    	if(selectedSupplier.getData() instanceof Outlays4wedding) {
    		Outlays4wedding sup = (Outlays4wedding) selectedSupplier.getData();
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
    	Outlays4wedding selected = null;
    	if(selectedSupplier.getData() instanceof Outlays4wedding) {
    		selected = (Outlays4wedding)selectedSupplier.getData();
    	}else{
    		selected = new Outlays4wedding();
    		selected.setOutlay((Outlays)selectedSupplier.getData());
    		TreeNode childNode = new DefaultTreeNode(Constants.LEAF,selected,selectedSupplier);
    	}
    	selected.setAmountPaid(paid);
    	selected.setConfirmed(confirmed ? Constants.YES : Constants.NO);
    	selected.setEstimatedPrice(estimation);
    	selected.setFinalPrice(finalPrice);
    	selected.setName(name);
    	selected.setNotes(notes);
    }
    public Double getTotalPaid(){
    	return outLaysList.stream().map(Outlays4wedding::getAmountPaid).mapToDouble(Double::doubleValue).sum(); 
    }

    public Double getTotalPending(){
    	 double price = outLaysList.stream().map(Outlays4wedding::getFinalPrice).mapToDouble(Double::doubleValue).sum();
    	 return price - getTotalPaid();
    }

    /* GETTERS & SETTERS */
    
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
	

	public List<Outlays4wedding> getOutLaysList() {
		return outLaysList;
	}

	public void setOutLaysList(List<Outlays4wedding> outLaysList) {
		this.outLaysList = outLaysList;
	}

}