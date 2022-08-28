package questao05;

public class Vacina {
	private int codigo;
	private String nome;
	private String lote;
	
	public Vacina(int codigo, String nome, String lote) {
		this.codigo = codigo;
		this.nome = nome;
		this.lote = lote;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getLote() {
		return lote;
	}
	
}
