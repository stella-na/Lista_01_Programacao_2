package questao04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.*;

public class Data {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		//Letra a)
		System.out.println("Digite uma data (DD/MM/AAAA): ");
		String dataRecebida = sc.nextLine();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate data = LocalDate.parse(dataRecebida, formato); 
		
		//Letra b)
		LocalDate dataHoje = LocalDate.now();
		long resultado = data.until(dataHoje, ChronoUnit.DAYS);
		System.out.println("\nDiferença em dias: " + resultado);
		
		//Letra c)
		LocalDate diasAdicionados = data.plusDays(110);
		String diasAdicionadosFormatado = diasAdicionados.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Com 110 dias adicionados: " + diasAdicionadosFormatado);
		
		
		//Letra d)
		LocalDate agosto = diasAdicionados.withMonth(8);
		String agostoFormatado = agosto.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Com agosto: " + agostoFormatado);
		
		//Letra e)
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String dataFormatada = agosto.format(formato1);
        System.out.println("Data alterada:  " + dataFormatada);
        System.out.println();
        
        
        //Letra f)
        System.out.println("-".repeat(36));
        System.out.println("Calculadora de dias úteis");
        System.out.println("-".repeat(36));
        System.out.println("Digite a primeira data (DD/MM/AAAA): ");
        String data1 = sc.nextLine(); 
        LocalDate data1_format = LocalDate.parse(data1, formato); 
        System.out.println("Digite a segunda data (DD/MM/AAAA): ");
        String data2 = sc.nextLine(); 
        LocalDate data2_format = LocalDate.parse(data2, formato); 
             
        int diasUteis = calcularDiasUteis(data1_format, data2_format);
        System.out.printf("Número de dias úteis: %d\n", diasUteis);
        System.out.println("-".repeat(36));
	
        sc.close();
	}
	
	//Letra f)
	static int calcularDiasUteis(LocalDate data1, LocalDate data2){
		int dia = 0;
		long resultado = data1.until(data2, ChronoUnit.DAYS);
		if(resultado < 0) {
			resultado = -resultado;
		}
		for(int i = 0; i <= resultado; i++) {
			if((data1.getDayOfWeek().getValue() != 6) && (data1.getDayOfWeek().getValue() != 7)) {
				dia++;				
			}		
			data1 = data1.plusDays(1);				
			}			
		return dia;	
	}
	
}