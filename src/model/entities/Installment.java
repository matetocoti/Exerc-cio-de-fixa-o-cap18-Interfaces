package model.entities;

//region IMPORTS
import model.exception.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;



//endregion

public class Installment {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //region ATRIBUTOS
    private Date dueDate;
    private Double amount;
    //endregion

    //region CONSTRUTORES
    public Installment(){

    }

    public Installment(Date dueDate, Double amount){



        this.dueDate = dueDate;
        this.amount = amount;
    }
    //endregion

    //region GETTERS

    public Date getDueDate() {
        return dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sdf.format(dueDate));
        stringBuilder.append(" - ");
        stringBuilder.append(amount);

        return stringBuilder.toString();
    }

    //endregion

}
