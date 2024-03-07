package com.generica;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;

public class ServerDrivenUI {
	
	private static final String ENCODING="UTF-8";
	
	public static Template gerarTemplate(String template) throws ParseException {
		RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
		StringReader reader = new StringReader(template);
		Template tpl = new Template();
		tpl.setRuntimeServices(runtimeServices);
		
		tpl.setData(runtimeServices.parse(reader, "default"));
		tpl.setEncoding(ENCODING);
		tpl.initDocument();
		
		return tpl;	
	}

	public static StringWriter mergearTemplateComObjeto(Template template, String objetoDoTemplate, Object object) {
		StringWriter writer = new StringWriter();
		
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put(objetoDoTemplate, object);
		
		template.merge(velocityContext, writer);
		
		return writer;
	}
			

}
