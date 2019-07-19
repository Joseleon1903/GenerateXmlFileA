package com.generating.xml.fl.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="PROCESS")
public class ProcessAction {

    @XmlElement(name= "PROCESS_ID")
    private String processId;

    public ProcessAction(){}

    public ProcessAction(String processId){
        this.processId=processId;
    }

}
