package questao05;

import java.time.LocalDate;

public class TesteVacinaMain {

	static RelacaoVacinados rv = new RelacaoVacinados();
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("José Maria", "0333787383", "IDOSOS", LocalDate.of(1955, 06, 10));
		Pessoa p2 = new Pessoa("Maria José", "3830333787", "IDOSOS", LocalDate.of(1953, 04, 23));
		Pessoa p3 = new Pessoa("José Silva", "7870333383", "IDOSOS", LocalDate.of(1951, 02, 07));
		Pessoa p4 = new Pessoa("Maria Silva", "3787303383", "IDOSOS", LocalDate.of(1956, 05, 18));
		Pessoa p5 = new Pessoa("José Santos", "1333787383", "IDOSOS", LocalDate.of(1950, 03, 05));
		
		Vacina v1 = new Vacina(32, "CORONAVAC", "67");
		Vacina v2 = new Vacina(12, "OXFORD", "246");
		
		RegistroVacina r1 = new RegistroVacina("3", LocalDate.of(2022, 07, 22), "Joao Marcos", 1, "DRIVE THRU - UFRPE - UNIVERSIDADE RURAL", p1.getGrupo(), p1, v1);
		RegistroVacina r2 = new RegistroVacina("2",LocalDate.of(2022, 07, 25), "Joao Marcos", 1, "DRIVE THRU GERALDÃO", p2.getGrupo(), p2, v1);
		RegistroVacina r3 = new RegistroVacina("5",LocalDate.of(2022, 07, 24), "Joao Marcos", 1, "CENTRO DE VACINAÇÃO PARQUE DE EXPOSIÇÃO", p3.getGrupo(), p3, v2);
		RegistroVacina r4 = new RegistroVacina("1",LocalDate.of(2022, 07, 21), "Joao Marcos", 1, "CENTRO DE VACINAÇÃO  COMPAZ ARIANO SUASSUNA", p4.getGrupo(), p4, v2);
		RegistroVacina r5 = new RegistroVacina("7",LocalDate.of(2022, 07, 06), "Joao Marcos", 1, "DRIVE THRU ARRUDA", p5.getGrupo(), p5, v1);
		RegistroVacina r6 = new RegistroVacina("8",LocalDate.of(2022, 07, 27), "Joao Marcos", 2, "DRIVE THRU ARRUDA", p5.getGrupo(), p5, v1);
		
		
		
		rv.adicionar(r1);
		rv.adicionar(r2);
		rv.adicionar(r3);
		rv.adicionar(r4);
		rv.adicionar(r5);
		rv.adicionar(r6);

		imprimirTabela();
		
	}
	
	public static void imprimirTabela() {
				
		System.out.printf(" %-12s| %-20s | %-5s | %24s%n", "CPF", "Nome", "Idade", "Data Indicada p. 2a Dose ");
		System.out.println("----------------------------------------------------------------------");
		rv.listarPessoasQueNaoTomaram2aDose();
		System.out.print("----------------------------------------------------------------------");
		System.out.printf("\nTotal de vacinados acima de 65 anos: %.0f\n", rv.calcularTotalVacinadosAcimade(65));
		System.out.printf("Total de vacinados que não tomaram a 2a. dose: %.0f\n", rv.getVacinadosNaoTomaram2aDose());
		System.out.printf("Total de vacinados que tomaram a 2a. dose: %.0f\n", rv.calcularTotalVacinadosAcimade(0) - rv.getVacinadosNaoTomaram2aDose());
	}

}