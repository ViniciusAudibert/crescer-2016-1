package br.com.crescer.crescer.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author vinicius.audibert
 */
@ManagedBean
@ViewScoped
public class Hello implements Serializable {

    private String helloWorld = "Hello World!";

    @PostConstruct
    public void init(){
        helloWorld = "Hello World!";
        System.out.println(helloWorld);
    }
    
    @PreDestroy
    public void out(){
        System.out.println("Saida");
    }
    
    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }
}
