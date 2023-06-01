package com.bigcorp.crm.faces.facebean;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


@Named
@ApplicationScoped
public class ApplicationFaceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public String switchLocale() {
		Locale currentLocale = Locale.getDefault();
		if( currentLocale == Locale.UK) {
			Locale.setDefault(Locale.FRANCE);
		}else {
			Locale.setDefault(Locale.UK);
		}
		return null;
	}

}