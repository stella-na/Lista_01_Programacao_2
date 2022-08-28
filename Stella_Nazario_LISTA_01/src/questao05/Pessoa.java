package questao05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {
	private String nome;
	private String cpf;
	private String grupo;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, String cpf, String grupo, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.grupo = grupo;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public int calcularIdade() {
		LocalDate hoje = LocalDate.now();
		int idade = (int) dataNascimento.until(hoje, ChronoUnit.YEARS);
		return idade;
	}

}
