package questao02;

public class teste {

		  static double total = 0;
		  static double contador = 0;
		  static int[] cavaloX = { 1, 2, 2, 1, -1, -2, -2, -1 };
		  static int[] cavaloY = { 2, 1, -1, -2, -2, -1, 1, 2 };
		  static int lastX;
		  static int lastY;
		  

		  public static void moverCavalo(int x, int y, int k) {
		    if(k>0) {
		      lastX = x;
		      lastY = y;
		      System.out.printf("POS: %d:%d / MOV: %d\n\n", x, y, k);
		  
		      for (int i = 0; i < 8; i++) {
		        x = lastX;
		        y = lastY;
		        x += cavaloX[i];
		        y += cavaloY[i];
		  
		        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
		          contador++;
		          total+=8;
		          System.out.printf("MOV ATUAL: %f / POS: %d:%d\n\n", contador, x, y);
		          k--;
		          moverCavalo(x,y,k);
		        }
		      }
		    }
		    else{
		      double prob = contador/total;
		      System.out.printf("A probabilidade é de: %f\n\n", prob);
		    }
		  }

		  public static void main(String[] args) {
		    contador = 0;
		    moverCavalo(0, 0, 1);
		  }
}