package br.com.accenture.projetogrupoum.modelo;

import org.springframework.stereotype.Component;

@Component
public class Retorno {
    
    private String msg;


    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
