/**
 * 
 */
package EstruturasdeRepetição;
import java.util.Scanner;

/**
 * @author patrikrufino
 * Programa para calular a média de notas de um aluno.
 */
public class MediaNotasAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variáveis
		double nota1 = 0, nota2 = 0, mediaNotas;
		
		try (var ler = new Scanner(System.in)) {
			for(int i = 0; i <= 5; i++) {
				System.out.printf("\nDigite a primeira nota: ", nota1);
				nota1 = ler.nextDouble();
				System.out.printf("\nDigite a segunda nota: ", nota2);
				nota2 = ler.nextDouble();
				mediaNotas = (nota1 + nota2) / 2;
				if(mediaNotas >= 7.0) {
					System.out.println("Situação:\nAprovada! \nCom uma media de:\n" 
							+ mediaNotas);
				}
				else {
					System.out.println("Situação:\nReprovada\nCom uma media de:\n"
							+ mediaNotas);
				}
			}
		}
	}

}
