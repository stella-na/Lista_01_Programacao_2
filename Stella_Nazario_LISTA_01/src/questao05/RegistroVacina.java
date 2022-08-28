package questao05;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegistroVacina {
	
	private String id;
	private LocalDate data_vacinacao;
	private String atendente;
	private int dose;
	private String local;
	private String grupo;
	private Pessoa pVacinada;
	private Vacina vacina;
		
	public RegistroVacina(String id, LocalDate data_vacinacao, String atendente, int dose, String local, String grupo,
			Pessoa pVacinada, Vacina vacina) {
		this.id = id;
		this.data_vacinacao = data_vacinacao;
		this.atendente = atendente;
		this.dose = dose;
		this.local = local;
		this.grupo = grupo;
		this.pVacinada = pVacinada;
		this.vacina = vacina;
	}
	public LocalDate getData_vacinacao() {
		return data_vacinacao;
	}
	public void setData_vacinacao(LocalDate data_vacinacao) {
		this.data_vacinacao = data_vacinacao;
	}
	public String getAtendente() {
		return atendente;
	}
	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getGrupo() {
		return grupo;
	}
	
	public void setGrupo(String grupo) {
		ArrayList<String> grupos = new ArrayList<>();
		grupos.add("IDOSOS");
		grupos.add("TRABALHADORES DA SAÚDE");
		grupos.add("OUTRAS PRIORIDADES");
		
		if(grupos.contains(grupo)) {
			this.grupo = grupo;
		}
	}
	public String getId() {
		return id;
	}
	public Pessoa getpVacinada() {
		return pVacinada;
	}
	public Vacina getVacina() {
		return vacina;
	}
	
}
