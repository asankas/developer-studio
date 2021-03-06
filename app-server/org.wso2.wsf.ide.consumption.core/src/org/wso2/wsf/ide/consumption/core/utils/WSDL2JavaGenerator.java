/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.wsf.ide.consumption.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.WSDL11ToAxisServiceBuilder;
import org.apache.axis2.description.WSDL20ToAxisServiceBuilder;
import org.apache.axis2.description.WSDLToAxisServiceBuilder;
import org.apache.axis2.util.CommandLineOption;
import org.apache.axis2.util.CommandLineOptionConstants.WSDL2JavaConstants;
import org.apache.woden.WSDLException;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.wsf.ide.consumption.core.plugin.WebServiceWSASConsumptionCorePlugin;
import org.xml.sax.SAXException;

public class WSDL2JavaGenerator {
	private static IDeveloperStudioLog log=Logger.getLog(WebServiceWSASConsumptionCorePlugin.PLUGIN_ID);

    /**
     * Maps a string containing the name of a language to a constant defined in 
     * CommandLineOptionConstants.LanguageNames
     * @param UILangValue a string containg a language, e.g. "java", "cs", "cpp" or "vb"
     * @return a normalized string constant
     */
    private String mapLanguagesWithCombo(String UILangValue)  {
       return UILangValue;
    }
    /**
     * Creates a list of parameters for the code generator based on the decisions made by 
     * the user on the OptionsPage(page2). For each setting, there is a Command-Line option for 
     * the Axis2 code generator.
     * @return a Map with keys from CommandLineOptionConstants with the values entered 
     * by the user on the Options Page.
     */
    public Map fillOptionMap(boolean isAyncOnly,
            		  boolean isSyncOnly,
            		  boolean isServerSide,
            		  boolean isServerXML,
            		  boolean isTestCase,
            		  boolean isGenerateAll,
            		  String serviceName,
            		  String portName,
            		  String databindingName,
            		  String WSDLURI,
            		  String packageName,
            		  String selectedLanguage,
            		  String outputLocation,
            		  String sourceCodeLocation,
            		  String namespace2packageList,
            		  boolean isServerSideInterface,
            		  boolean isUnpackClasses,
            		  boolean isSwitchOnUnwrap,
            		  boolean isNoBuildXml,
            		  boolean isNoWSDL,
            		  boolean isNoMessageReceiver
            		  ){
       Map optionMap = new HashMap();
       
     try{  
        //Reflection invocatin resources
//		Class CommandLineOptionConstantsClass = ClassLoadingUtil.loadClassFromAntClassLoader(
//							"org.apache.axis2.util.CommandLineOptionConstants$WSDL2JavaConstants");
//		Class CommandLineOptionClass = ClassLoadingUtil.loadClassFromAntClassLoader(
//														"org.apache.axis2.util.CommandLineOption");
//		Constructor CommandLineOptionConstructor = CommandLineOptionClass.getConstructor(
//														new Class[]{String.class,String[].class});
        //WSDL file name
       
							//       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.WSDL_LOCATION_URI_OPTION, 
							//    		   		 new CommandLineOption(
							//    		   				 CommandLineOptionConstants.WSDL2JavaConstants.WSDL_LOCATION_URI_OPTION,
							//    		   				 getStringArray(WSDLURI)));
		
        //Reflection Invocation 
//		Field WSDL_LOCATION_URI_OPTION_FIELD = CommandLineOptionConstantsClass.getField(
//																		"WSDL_LOCATION_URI_OPTION");
//		optionMap.put((String)WSDL_LOCATION_URI_OPTION_FIELD.get(String.class),
//						CommandLineOptionConstructor.newInstance(
//							new Object[]{(String)WSDL_LOCATION_URI_OPTION_FIELD.get(String.class),
//							getStringArray(WSDLURI)}));
		optionMap.put(WSDL2JavaConstants.WSDL_LOCATION_URI_OPTION,new CommandLineOption(WSDL2JavaConstants.WSDL_LOCATION_URI_OPTION,getStringArray(WSDLURI)));
       //Async only
	       if (isAyncOnly)
	       {
								//          optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.CODEGEN_ASYNC_ONLY_OPTION, 
								//        		  	new CommandLineOption(
								//        		  			CommandLineOptionConstants.WSDL2JavaConstants.CODEGEN_ASYNC_ONLY_OPTION,
								//        		  			new String[0]));
	        
	    	//Reflection Invocation     	   
			optionMap.put(WSDL2JavaConstants.CODEGEN_ASYNC_ONLY_OPTION,
							new CommandLineOption(WSDL2JavaConstants.CODEGEN_ASYNC_ONLY_OPTION,new String[0]));
	       }
	       
	       //sync only
	       if (isSyncOnly)
	       {
								//          optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.CODEGEN_SYNC_ONLY_OPTION, 
								//        		  new CommandLineOption(
								//        		  CommandLineOptionConstants.WSDL2JavaConstants.CODEGEN_SYNC_ONLY_OPTION,
								//        		  new String[0]));
	       //Reflection Invocation
	    		optionMap.put(WSDL2JavaConstants.CODEGEN_SYNC_ONLY_OPTION,
						new CommandLineOption(WSDL2JavaConstants.CODEGEN_SYNC_ONLY_OPTION,
								new String[0]));
	       }
	       //serverside
	       if (isServerSide)
	       {
								//          optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.SERVER_SIDE_CODE_OPTION, 
								//        		  new CommandLineOption(
								//        		  CommandLineOptionConstants.WSDL2JavaConstants.SERVER_SIDE_CODE_OPTION,
								//        		  new String[0]));
		    //Reflection Invocation
			optionMap.put(WSDL2JavaConstants.SERVER_SIDE_CODE_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.SERVER_SIDE_CODE_OPTION,
							new String[0]));
	          //server xml
	          if (isServerXML)
	          {
	          //optionMap.put(
								//            		 CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_SERVICE_DESCRIPTION_OPTION,
	          // 	new CommandLineOption(
	          // 	CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_SERVICE_DESCRIPTION_OPTION,
								//            		 new String[0]));
	    		optionMap.put(WSDL2JavaConstants.GENERATE_SERVICE_DESCRIPTION_OPTION,
	    		              new CommandLineOption(WSDL2JavaConstants.GENERATE_SERVICE_DESCRIPTION_OPTION,
					   new String[0]));
	          }
	          if (isGenerateAll){
								//              optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_ALL_OPTION, 
								//            		  new CommandLineOption(
								//            		  CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_ALL_OPTION,
								//            		  new String[0]));
				optionMap.put(WSDL2JavaConstants.GENERATE_ALL_OPTION,
						new CommandLineOption(WSDL2JavaConstants.GENERATE_ALL_OPTION,
								new String[0]));
	          }
	       }
	       //test case
	       if (isTestCase)
	       {
								//          optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_TEST_CASE_OPTION,
								//        		  new CommandLineOption(
								//        		  CommandLineOptionConstants.WSDL2JavaConstants.GENERATE_TEST_CASE_OPTION,
								//        		  new String[0]));
			optionMap.put(WSDL2JavaConstants.GENERATE_TEST_CASE_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.GENERATE_TEST_CASE_OPTION,
							new String[0]));
	       }
	       //package name
								//       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.PACKAGE_OPTION,
								//    		   new CommandLineOption(
								//    		   CommandLineOptionConstants.WSDL2JavaConstants.PACKAGE_OPTION,
								//    		   getStringArray(packageName)));
			optionMap.put(WSDL2JavaConstants.PACKAGE_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.PACKAGE_OPTION,
										getStringArray(packageName)));
			
	       //selected language
								//       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.STUB_LANGUAGE_OPTION,
								//    		   new CommandLineOption(
								//    		   CommandLineOptionConstants.WSDL2JavaConstants.STUB_LANGUAGE_OPTION,
								//    		   getStringArray(mapLanguagesWithCombo(selectedLanguage))));
			optionMap.put(WSDL2JavaConstants.STUB_LANGUAGE_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.STUB_LANGUAGE_OPTION,
									getStringArray(mapLanguagesWithCombo(selectedLanguage))));
			
	       //output location
								//       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.OUTPUT_LOCATION_OPTION,
								//    		   new CommandLineOption(
								//    		   CommandLineOptionConstants.WSDL2JavaConstants.OUTPUT_LOCATION_OPTION,
								//    		   getStringArray(outputLocation)));
			optionMap.put(WSDL2JavaConstants.OUTPUT_LOCATION_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.OUTPUT_LOCATION_OPTION,
									getStringArray(outputLocation)));
	      //source code location
			optionMap.put(WSDL2JavaConstants.SOURCE_FOLDER_NAME_OPTION,
		              new CommandLineOption(WSDL2JavaConstants.SOURCE_FOLDER_NAME_OPTION,
								getStringArray(sourceCodeLocation)));
			
	      //databinding
								//       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.DATA_BINDING_TYPE_OPTION,
								//    		   new CommandLineOption(
								//    		   CommandLineOptionConstants.WSDL2JavaConstants.DATA_BINDING_TYPE_OPTION,
								//    		   getStringArray(databindingName)));
			optionMap.put(WSDL2JavaConstants.DATA_BINDING_TYPE_OPTION,
			              new CommandLineOption(WSDL2JavaConstants.DATA_BINDING_TYPE_OPTION,
								  getStringArray(databindingName)));
	       
	       //port name
	       if (portName!=null){
								//	       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.PORT_NAME_OPTION,
								//	    		   new CommandLineOption(
								//	    		   CommandLineOptionConstants.WSDL2JavaConstants.PORT_NAME_OPTION,
								//	    		   getStringArray(portName)));
	    		optionMap.put(WSDL2JavaConstants.PORT_NAME_OPTION,
	    		              new CommandLineOption(WSDL2JavaConstants.PORT_NAME_OPTION,
	    								getStringArray(portName)));
	       }else{
						optionMap.put(WSDL2JavaConstants.All_PORTS_OPTION,
						              new CommandLineOption(WSDL2JavaConstants.All_PORTS_OPTION,
						getStringArray(portName)));
	       }
	       
	       //service name
	       if (serviceName!= null){
								//	       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.SERVICE_NAME_OPTION,
								//	    		   new CommandLineOption(
								//	    		   CommandLineOptionConstants.WSDL2JavaConstants.SERVICE_NAME_OPTION,
								//	    		   getStringArray(serviceName)));
	    		optionMap.put(WSDL2JavaConstants.SERVICE_NAME_OPTION,new CommandLineOption(WSDL2JavaConstants.SERVICE_NAME_OPTION,
	    									getStringArray(serviceName)));
	       }
	       //ns2pkg mapping
	       if (namespace2packageList!= null){
								//	       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.NAME_SPACE_TO_PACKAGE_OPTION,
								//	    		   new CommandLineOption(
								//	    		   CommandLineOptionConstants.WSDL2JavaConstants.NAME_SPACE_TO_PACKAGE_OPTION
								//	    		   , getStringArray(namespace2packageList)));
	    		optionMap.put(WSDL2JavaConstants.NAME_SPACE_TO_PACKAGE_OPTION,new CommandLineOption(WSDL2JavaConstants.NAME_SPACE_TO_PACKAGE_OPTION,
	    					getStringArray(namespace2packageList)));
	       }
	       
	       //server side interface  mapping
	       if (isServerSideInterface){
								//	       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.SERVER_SIDE_INTERFACE_OPTION,
								//	    		   new CommandLineOption(
								//	    		   CommandLineOptionConstants.WSDL2JavaConstants.SERVER_SIDE_INTERFACE_OPTION,
								//	    		   new String[0]));
	    		optionMap.put(WSDL2JavaConstants.SERVER_SIDE_INTERFACE_OPTION,new CommandLineOption(WSDL2JavaConstants.SERVER_SIDE_INTERFACE_OPTION,
	    					new String[0]));
	       }
	       //unpack classes mapping
	       if (isUnpackClasses){
								//	       optionMap.put(CommandLineOptionConstants.WSDL2JavaConstants.UNPACK_CLASSES_OPTION,
								//	    		   new CommandLineOption(
								//	    		   CommandLineOptionConstants.WSDL2JavaConstants.UNPACK_CLASSES_OPTION,
								//	    		   new String[0]));
	    		optionMap.put(WSDL2JavaConstants.UNPACK_CLASSES_OPTION,new CommandLineOption(WSDL2JavaConstants.UNPACK_CLASSES_OPTION,
	    					new String[0]));
	       }
	       
	       if (isSwitchOnUnwrap){
	    	   optionMap.put(WSDL2JavaConstants.UNWRAP_PARAMETERS,new CommandLineOption(WSDL2JavaConstants.UNWRAP_PARAMETERS,
	    							   new String[0]));
	       }
	       
	       if (isNoBuildXml){
	    	   optionMap.put(WSDL2JavaConstants.NO_BUILD_XML_OPTION_LONG,new CommandLineOption(WSDL2JavaConstants.NO_BUILD_XML_OPTION_LONG,
	    							   new String[0]));
	       }
	       
	       if (isNoWSDL){
	    	   optionMap.put(WSDL2JavaConstants.NO_WSDLS_OPTION_LONG,new CommandLineOption(WSDL2JavaConstants.NO_WSDLS_OPTION_LONG,
	    							   new String[0]));
	       }
	       
	       if (isNoMessageReceiver){
	    	   optionMap.put(WSDL2JavaConstants.NO_MESSAGE_RECEIVER_OPTION_LONG,new CommandLineOption(WSDL2JavaConstants.NO_MESSAGE_RECEIVER_OPTION_LONG,
	    							   new String[0]));
	       }
	       
	       String wsdlVersion = getWSDLVersion(WSDLURI);
	       if (wsdlVersion!=null){
						optionMap.put(WSDL2JavaConstants.WSDL_VERSION_OPTION,new CommandLineOption(WSDL2JavaConstants.WSDL_VERSION_OPTION,
									   new String[]{wsdlVersion}));
	       }
       
     }catch(Exception e){
    	 log.error(e);
     }
       return optionMap;
       
    }
    
    public String getBaseUri(String wsdlURI){
    	
    	try {
			URL url;
			if (wsdlURI.indexOf("://")==-1){
				url = new URL("file","",wsdlURI);
			}else{
				url = new URL(wsdlURI);	
			}

			
			String baseUri;
			if ("file".equals(url.getProtocol())){
				baseUri = new File(url.getFile()).getParentFile().toURL().toExternalForm();
			}else{
				baseUri = url.toExternalForm().substring(0,
						url.toExternalForm().lastIndexOf("/")
				);
			}
		
			
			return baseUri;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
    }
    
	public String getWSDLVersion(String wsdlURI) throws MalformedURLException{
		String wsdlVersion=null;
		URL url;
		if (wsdlURI.indexOf("://")==-1){
			url = new URL("file","",wsdlURI);
		}if (wsdlURI.indexOf(":/")==-1){
			url = new URL("file","",wsdlURI);
		}
		else{
			url = new URL(wsdlURI);	
		}
		try {
			URLConnection openConnection = url.openConnection();
		    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document document = parser.parse(openConnection.getInputStream());
		    String tagName = document.getDocumentElement().getTagName();
		    if (tagName.equals("wsdl2:description")){
		    	wsdlVersion="2.0";
		    }
		    openConnection.getInputStream().close();
		} catch (IOException e) {
		} catch (SAXException e) {
		} catch (ParserConfigurationException e) {
		}
		return wsdlVersion;
	}
    
    /**
     * Reads the WSDL Object Model from the given location.
     * 
     * @param wsdlURI the filesystem location (full path) of the WSDL file to read in.
     * @return the WSDLDescription object containing the WSDL Object Model of the given WSDL file
     * @throws WSDLException when WSDL File is invalid
     * @throws IOException on errors reading the WSDL file
     */
    public AxisService getAxisService(String wsdlURI, String portName) throws Exception{
//    	String wsdl11AxisServiceBuilderClass="org.apache.axis2.description.WSDL11ToAxisServiceBuilder";
//    	String wsdl2AxisServiceBuilderClass="org.apache.axis2.description.WSDL20ToAxisServiceBuilder";
    		URL url;
			if (!(wsdlURI.startsWith("file:")||wsdlURI.startsWith("http:"))){
				url = new URL("file","",wsdlURI);
			} else{
				url = new URL(wsdlURI);	
			}
			
//			String axisBuilderClass=null;
//			if (getWSDLVersion(wsdlURI)==null)
//				axisBuilderClass=wsdl11AxisServiceBuilderClass;
//			else
//				axisBuilderClass=wsdl2AxisServiceBuilderClass;
//			
//			Class WSDLToAxisServiceBuilderClass = ClassLoadingUtil.loadClassFromAntClassLoader(
//					axisBuilderClass);
//			Constructor constructor = WSDLToAxisServiceBuilderClass.getConstructor(
//					new Class[]{InputStream.class, QName.class, String.class});
//			Object WSDLToAxisServiceBuilderInstance = constructor.newInstance(
//					new Object[]{url.openConnection().getInputStream(),null,portName});
			
			WSDLToAxisServiceBuilder wsdlToAxisServiceBuilder;
			
			if (getWSDLVersion(wsdlURI)==null) {
	            wsdlToAxisServiceBuilder = new WSDL11ToAxisServiceBuilder(url.openConnection().getInputStream(),null,portName);
            } else{
	            wsdlToAxisServiceBuilder = new WSDL20ToAxisServiceBuilder(url.openConnection().getInputStream(),null,portName);
            }
			
//			Method setBaseUriMethod = WSDLToAxisServiceBuilderClass.getMethod(
//					"setBaseUri", 
//					new Class[]{String.class});
//			setBaseUriMethod.invoke(
//					WSDLToAxisServiceBuilderInstance, 
//					new Object[]{wsdlURI});

			wsdlToAxisServiceBuilder.setBaseUri(wsdlURI);

//			Method setAllPortsMethod = WSDLToAxisServiceBuilderClass.getMethod(
//					"setAllPorts", 
//					new Class[]{boolean.class});
//			setAllPortsMethod.invoke(
//					WSDLToAxisServiceBuilderInstance, 
//					new Object[]{portName==null});
			if (wsdlToAxisServiceBuilder instanceof WSDL11ToAxisServiceBuilder){
				((WSDL11ToAxisServiceBuilder)wsdlToAxisServiceBuilder).setAllPorts(portName==null);
			}else if (wsdlToAxisServiceBuilder instanceof WSDL20ToAxisServiceBuilder){
				((WSDL20ToAxisServiceBuilder)wsdlToAxisServiceBuilder).setAllPorts(portName==null);
			}
			//Fix for the Axis2 1.2 
			//builder.setCodegen(true);
//			Method setCodegenMethod = WSDLToAxisServiceBuilderClass.getMethod(
//					"setCodegen", 
//					new Class[]{boolean.class});
//			setCodegenMethod.invoke(
//					WSDLToAxisServiceBuilderInstance, 
//					new Object[]{true});
			wsdlToAxisServiceBuilder.setCodegen(true);
//			Method populateServiceMethod = WSDLToAxisServiceBuilderClass.getMethod(
//					"populateService", 
//					null);
//			return populateServiceMethod.invoke(WSDLToAxisServiceBuilderInstance, null);
			return wsdlToAxisServiceBuilder.populateService();
			//return this import org.apache.axis2.description.AxisService;
    }

    /**
     * Converts a single String into a String Array
     * 
     * @param value a single string
     * @return an array containing only one element
     */
    private String[] getStringArray(String value)
    {
       String[] values = new String[1];
       values[0] = value;
       return values;
    }
}

