package questao02;

import java.util.Scanner;

class TesteTabuleiro {

	static final int NUMERO = 8;

	// vetores de possiveis movimentos do cavalo
	static int cavalox[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int cavaloy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------------------------------");
		System.out.println("BEM VINDO AO TESTE DE PROBABILIDADES!");
		System.out.println("-------------------------------------\n");
		String loop = "s";
		
		while(loop.equals("s")) {
			System.out.print("Escolha a posição X: ");
			int x = sc.nextInt();
			
			System.out.print("Escolha a posição Y: ");
			int y = sc.nextInt();
						
			if(x < 0 || x >= 8 || y < 0 || y >= 8) {
				System.out.println("Valores Inválidos!\nEscolha um número de 0 a 7\n");
			}
			else {
				System.out.print("Escolha o número de movimentos: ");
				int k = sc.nextInt();
				double prob = is_knight_on_board(x, y, k);
				double porcentagem = is_knight_on_board(x, y, k)*100;
				System.out.printf("A probabilidade do cavalo permanecer dentro do tabuleiro é de: %.3f ou %.1f%s \n\n", prob, porcentagem, "%");
				
				System.out.print("Continuar? s/n: ");
				String c = sc.next();
				System.out.println();
				
				if(c.equals("n")) {
					System.out.println("VOLTE SEMPRE!");
					loop = "n";
				}
			}
		}
			
		sc.close();
	}

	//----------------------- MÉTODOS --------------------------
	
	// Verificar se o cavalo estiver dentro do tabuleiro
	static boolean verificarSeEstaDentro(int x, int y) {
		return (x >= 0 && x < NUMERO && y >= 0 && y < NUMERO);
	}
	
	static double is_knight_on_board(int pos_x, int pos_y, int movimentos) {

		double probabilidade[][][] = new double[NUMERO][NUMERO][movimentos + 1];

		// Se o numero de movimentos for 0, a probabilidade será 1
		for (int i = 0; i < NUMERO; ++i)
			for (int j = 0; j < NUMERO; ++j)
				probabilidade[i][j][0] = 1;

		for (int n = 1; n <= movimentos; ++n) {

			// Para toda posição (x, y) depois de n numeros de movimentos
			for (int x = 0; x < NUMERO; ++x) {

				for (int y = 0; y < NUMERO; ++y) {

					double prob = 0.0;

					// Para toda posição possivel de (x, y)
					for (int i = 0; i < 8; ++i) {
						int possivel_move_x = x + cavalox[i];
						int possivel_move_y = y + cavaloy[i];

						if (verificarSeEstaDentro(possivel_move_x, possivel_move_y)) {
							prob += probabilidade[possivel_move_x][possivel_move_y][n - 1] / 8.0;
						}
					}
					probabilidade[x][y][n] = prob;
				}
			}
		}
		return probabilidade[pos_x][pos_y][movimentos];
	}
}