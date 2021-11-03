package com.ciclo3.usa.ciclo3.model;

public class ReportClient {

    private Long total;
    private Client client;

    public ReportClient (Long total, Client client){

        this.total = total;
        this.client = client;
    }
    

    public Long gettotal(){
        return total;
    }

    public void settotal(Long total){
        this.total = total;
    }

    public Client getclient(){
        return client;
    }

    public void setclient(Client client){
        this.client = client;
    }
}
