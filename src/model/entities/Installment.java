package model.entities;

//region IMPORTS
import java.util.Date;



//endregion

public class Installment {

    //region ATRIBUTOS
    private Date dueDate;
    private Double amount;
    //endregion

    //region CONSTRUTORES
    public Installment(){

    }

    public Installment(Date dueDate, Double amount) {
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


    //endregion

}
