package model.services;

import model.entities.Contract;
import model.entities.Installment;
import model.exception.DomainException;

import java.util.Calendar;


public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService() {
    }

    // onlinePaymentService só será conhecido em tempo de excução quando for instanciado
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }




    // Método que processa 1 contrato  e gera parcelas
    // Recebe como argumento 1 contrato  e a quantidade de meses que o contrato será percelado
    public void processContract(Contract contract ,Integer months){
        if(months <= 0){
            throw new DomainException("O numero de parcelas devem ser maior que 0");
        }

        // Criando instancia de Calendar
        Calendar calendar = Calendar.getInstance();

        // Configurando o calendar com a data
        calendar.setTime(contract.getDate());




        for (int i = 0; i < months; i++) {
            double fee = onlinePaymentService.interest(contract.getTotalValue(), (i+1));
            calendar.add(Calendar.MONTH, 1);
            contract.addInstallment(new Installment(calendar.getTime(), (contract.getTotalValue()+fee)  / months ));
        }

        contract.getInstallmentList().forEach(installment -> installment.setAmount(installment.getAmount() + onlinePaymentService.paymentFee(installment.getAmount())));



    }
}
