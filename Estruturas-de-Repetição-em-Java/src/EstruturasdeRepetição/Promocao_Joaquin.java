/**
 * 
 */
package EstruturasdeRepetição;
import java.util.Scanner;
/**
 * @author patrikrufino
 * Programa para devolver um valor promocional;
 */

public class Promocao_Joaquin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double preco = 0;
		
		try (var ler = new Scanner(System.in)) {
		
		for(int i = 0; i <= 10; i++) {
			System.out.printf("\n Entre com o preço do seu produto: \n" + "R$", preco);
			preco = ler.nextDouble();
			System.out.println("O preço promocional sera:\n" + "R$" + (preco / 2));
		}
	}
		
	}

}
