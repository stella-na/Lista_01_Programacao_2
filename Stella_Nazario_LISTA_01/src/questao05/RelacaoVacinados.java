package questao05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RelacaoVacinados {

	private RegistroVacina[] vacinados;
	private double vacinadosNaoTomaram2aDose = 0;
	private double vacinadosTomaram2aDose = 0;

	public RelacaoVacinados() {
		vacinados = new RegistroVacina[100];
	}

	public RegistroVacina getVacinados(int indice) {
		return this.vacinados[indice];
	}	

	public double getVacinadosNaoTomaram2aDose() {
		return vacinadosNaoTomaram2aDose;
	}

	public double getVacinadosTomaram2aDose() {
		return vacinadosTomaram2aDose;
	}

	void adicionar(RegistroVacina registro) {
		for(int i = 0; i < vacinados.length; i++) {
			if(vacinados[i] == null) {
				vacinados[i] = registro;
				break;
			}
			
			else if(registro.getpVacinada().getCpf() == vacinados[i].getpVacinada().getCpf() && registro.getDose() == 2) {
				vacinados[i].setDose(registro.getDose());
				break;
			}
		}
	}

	double calcularTotalVacinadosAcimade(int idade) {
		double qtd = 0;
		for (int i = 0; i < vacinados.length; i++) {
			if (vacinados[i] != null && vacinados[i].getpVacinada().calcularIdade() > idade) {
				qtd++;			
			}
		}
		return qtd;
	}

	double totalDeIdososQueTomaram2aDose() {
		double qtd = 0.0;
		for (int i = 0; i < vacinados.length; i++) {
			if (vacinados[i].getGrupo().equals("IDOSOS") && vacinados[i].getDose() == 2) {
				qtd++;
			}	
		}
		return qtd;
	}

	void listarPessoasQueNaoTomaram2aDose() {
		LocalDate hj = LocalDate.now();

		for (int i = 0; i < vacinados.length; i++) {

			if (vacinados[i] != null && vacinados[i].getDose() == 1) {
				vacinadosNaoTomaram2aDose++;
				
				String cpf = vacinados[i].getpVacinada().getCpf();
				String nome = vacinados[i].getpVacinada().getNome();
				int idade = vacinados[i].getpVacinada().calcularIdade();
				LocalDate data2aDose = vacinados[i].getData_vacinacao().plus(21, ChronoUnit.DAYS);
				String data2DoseFormatada = data2aDose.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				if (vacinados[i].getData_vacinacao().until(hj, ChronoUnit.DAYS) <= 21) {
					System.out.printf(" %-12s| %-20s | %5d | %24s%n", cpf, nome, idade, data2DoseFormatada);
				} 
				else {
					System.out.printf(" %-12s| %-20s | %5d | %24s%n", cpf, nome, idade, hj.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				}
			}	
		}
	}
}