package questao03;

public class Estoque {
	private Produto produto;
	private int qtdAtual;
	private int qtdMinima;
	
	public Estoque() {
		
	}

	public Estoque(Produto produto, int qtdAtual, int qtdMinima) {
		this.produto = produto;
		this.qtdAtual = qtdAtual;
		this.qtdMinima = qtdMinima;
	}

	public int getQtdAtual() {
		return qtdAtual;
	}

	public void mudarQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}
	
	public void reporEstoque(int qtd) {
		this.qtdAtual += qtd;
	}
	
	public void darBaixa(int qtd) {
		this.qtdAtual -= qtd;
	}
	
	public void relatorio() {
		System.out.println("Código: " + produto.getCodigo() + "\n" + "Produto: " 
							+ produto.getNome() + "\n" + "Quantidade Atual: " 
							+ this.qtdAtual + "\n" + "Quantidade Mínima: " +  this.qtdMinima);
		System.out.println("------------------------");
	}

}
