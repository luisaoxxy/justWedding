package es.justWeddings.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Tables;
import es.justWeddings.domain.types.TableTypes;

@Component
@ViewScoped
public class TablesBean {

  private List<Tables> tables;
  private List<TableTypes> tableTypes;
  private Tables tableSelected;
  private String tableName;
  private String tableType;
  private Integer tableNumber;
  private String tableInvitedBy;
  private String xPosition;
  private String yPosition;
  
  public TablesBean(){
	  tables = new ArrayList<Tables>();
	  tableTypes = new ArrayList<TableTypes>(Arrays.asList(TableTypes.values()));
	  Tables family = new Tables("family", "R", "Luis", 1);
	  family.setxPosition(410);
	  family.setyPosition(25);
	  tables.add(family);
	  Tables friends = new Tables("friends", "C", "Arantxa", 2);
	  friends.setxPosition(665);
	  friends.setyPosition(-11);
	  tables.add(friends);
	  Tables principal = new Tables("Principal", "R", null, 0);
	  principal.setxPosition(532);
	  principal.setyPosition(-94);
	  tables.add(principal);
	  tableSelected = new Tables();
  }
  
  public void onDrop(DragDropEvent dragDropEvent) {
	    String dargId = dragDropEvent.getDragId();
	    Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    xPosition = params.get(dargId + "_left");
	    System.out.println("X_position"+ xPosition);
	    yPosition = params.get(dargId + "_top");
	    System.out.println("Y_position"+ yPosition);
	}

public List<Tables> getTables() {
	return tables;
}

public void setTables(List<Tables> tables) {
	this.tables = tables;
}

public String getTableName() {
	return tableName;
}

public void setTableName(String tableName) {
	this.tableName = tableName;
}

public Integer getTableNumber() {
	return tableNumber;
}

public void setTableNumber(Integer tableNumber) {
	this.tableNumber = tableNumber;
}

public String getTableInvitedBy() {
	return tableInvitedBy;
}

public void setTableInvitedBy(String tableInvitedBy) {
	this.tableInvitedBy = tableInvitedBy;
}

public String getxPosition() {
	return xPosition;
}

public void setxPosition(String xPosition) {
	this.xPosition = xPosition;
}

public String getyPosition() {
	return yPosition;
}

public void setyPosition(String yPosition) {
	this.yPosition = yPosition;
}

public String getTableType() {
	return tableType;
}

public void setTableType(String tableType) {
	this.tableType = tableType;
}

public Tables getTableSelected() {
	return tableSelected;
}

public void setTableSelected(Tables tableSelected) {
	this.tableSelected = tableSelected;
}

public List<TableTypes> getTableTypes() {
	return tableTypes;
}

public void setTableTypes(List<TableTypes> tableTypes) {
	this.tableTypes = tableTypes;
}

}