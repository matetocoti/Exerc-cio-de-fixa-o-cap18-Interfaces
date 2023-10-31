package model.services;


// Classe que implementa a interface
public class ServiceP implements OnlinePaymentService {
    @Override
    public Double paymentFee(Double amount) {
       return (amount * 0.02);
    }

    @Override
    public Double interest(Double amount, Integer months) {
        double fee = (0.01 * months);

        return  (fee * amount);
    }
}
