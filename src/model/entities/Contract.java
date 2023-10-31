package model.entities;

//region IMPORTS
import model.exception.DomainException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//endregion



public class Contract {

    //region ATRIBUTOS
    private Integer number;
    private Date date;
    private Double totalValue;
    //endregion

    // 1 Contrato pode ter Varias parcelas   relacionamento(1 x *)
    List<Installment> installmentList = new ArrayList<>();

    //region CONSTRUTORES

    public Contract(){

    }

    public Contract(Integer number, Date date, Double totalValue){
        // Programação defensiva
        if(totalValue <= 0){
            throw new DomainException("O valor total deve ser maior que 0");
        }

        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }
    //endregion

    //region GETTERS

    public Integer getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    //endregion

    public void addInstallment(Installment installment){
        installmentList.add(installment);
    }

   public void showingInstalment(){
        installmentList.forEach(System.out::println);
   }

}
