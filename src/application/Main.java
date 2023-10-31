package application;


//region IMPORTS
import model.entities.Contract;
import model.services.ContractService;
import model.services.ServiceP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
//endregion

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try(Scanner input = new Scanner(System.in)) {

            System.out.println("Entre com os dados do contrato: ");

            System.out.print("Numero: ");
            int number = input.nextInt();
            input.nextLine();

            System.out.print("Data (dd/MM/yyyy): ");
            Date date = sdf.parse(input.nextLine());

            System.out.print("Valor do contrato: ");
            double contractValue = input.nextDouble();

            System.out.print("Entre com o numero de parcelas: ");
            int installmentQuantity = input.nextInt();
            input.nextLine();


            Contract contract = new Contract(number ,date ,contractValue);
            ContractService contractService = new ContractService(new ServiceP());
            contractService.processContract(contract ,installmentQuantity);

            System.out.println("Parcelas: ");
            contract.showingInstalment();

        }catch (RuntimeException runtimeException){
            System.out.println("Error: " + runtimeException.getMessage());
        }
        catch (ParseException parseException){
            System.out.println("Error: " + parseException.getMessage());
        }
    }
}