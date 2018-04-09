package es.justWeddings.beans;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.stereotype.Component;

@Component
@SessionScoped
public class LanguageBean {

  private String localeCode = "es";
  private Locale locale;

  private Map<String, Object> countries;
  
  @PostConstruct
  public void init() {
    countries = new LinkedHashMap<String, Object>();
    locale = new Locale("es", "");
    countries.put("Español", locale);// label, value
    countries.put("English", Locale.ENGLISH);
  }

  // value change event listener
  public void countryLocaleCodeChanged(ValueChangeEvent e) {

    String newLocaleValue = e.getNewValue().toString();
    // loop country map to compare the locale code
    for (Map.Entry<String, Object> entry : countries.entrySet()) {
      if (entry.getValue().toString().equals(newLocaleValue)) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
        locale = (Locale)entry.getValue();
      }
    }
  }

  /* GETTERS Y SETTERS */
  public Map<String, Object> getCountriesInMap() {
    return countries;
  }

  public String getLocaleCode() {
    return localeCode;
  }

  public void setLocaleCode(String localeCode) {
    this.localeCode = localeCode;
  }

public Locale getLocale() {
	return locale;
}

public void setLocale(Locale locale) {
	this.locale = locale;
}
}
