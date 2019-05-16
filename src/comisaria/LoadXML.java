/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alfon
 */
public class LoadXML {
    public static HashMap leeXML(String file){
        file=file;   //PARA EXPORTAR A JAR ES NECESARIO ESTABLECER ESTE VALOR A "src/assets/"+file;
        HashMap<String,String> bd=new HashMap<>();
        try{
            
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            
            if(doc.hasChildNodes()){
                NodeList nodos=doc.getDocumentElement().getChildNodes();
                for(int i=0;i<nodos.getLength();i++){
                    Node nodo=nodos.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        /*switch(noe.getNodeName()){
                            case "loging":
                                this.
                        }*/
                    }
                }
            }
        }catch(IOException | ParserConfigurationException | SAXException ex){
            ex.printStackTrace();
        }
        return bd;
    }
}
