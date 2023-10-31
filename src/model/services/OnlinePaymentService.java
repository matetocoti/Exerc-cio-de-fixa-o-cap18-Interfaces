package model.services;

public interface OnlinePaymentService {

    // Métodos que devem ser implementados
    Double paymentFee(Double amount);
    Double interest(Double amount ,Integer months);
}
