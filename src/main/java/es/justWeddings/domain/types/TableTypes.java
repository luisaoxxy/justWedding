package es.justWeddings.domain.types;

public enum TableTypes {
	CIRCULAR("C"),
	RECTANGULAR("R");
	
	String text;

	TableTypes(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
