package com.bpcs.sunny.util;

import org.jdom2.Document;
import org.jdom2.input.DOMBuilder;

public class JDom2Helper {
	
	public static Document getJDom2FromW3cDom(org.w3c.dom.Document w3cDocument) {
		   // w3cDocument is the w3c DOM object. we now build the JDOM2 object
		 
        // the DOMBuilder uses the DefaultJDOMFactory to create the JDOM2
        // objects.
        DOMBuilder jdomBuilder = new DOMBuilder();
 
        // jdomDocument is the JDOM2 Object
        Document jdomDocument = jdomBuilder.build(w3cDocument);
        
        return jdomDocument;
 
	}

}
