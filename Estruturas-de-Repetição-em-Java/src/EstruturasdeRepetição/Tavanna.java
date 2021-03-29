/**
 * 
 */
package EstruturasdeRepetição;
import java.util.Scanner;

/**
 * @author patrikrufino
 * Este programa calcula tabuadas.
 */
public class Tavanna {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variáveis globais
		int option = 0;
		try (var ler = new Scanner(System.in)) {
		
		// Mensagem ao usuário + Data input
		System.out.printf("Bem vindo ao Tavanna!\n"
				+ "\nAqui você pode ver as tabuadas, escolha sua opção:\n"
				+ "\nDigite 1 para ver todas as tabuadas de 1 a 10."
				+ "\nDigite 2 para ver a tabuada de um número específico.\n"
				+ "\nDigite sua opção aqui =>"
				+ "", option);
		
		// Ler opção
		option = ler.nextInt();
		
		if(option == 1) {
			int valor = 1;
			while(valor <= 10) {
				for(int i = 0; i <= 10; i++) {
					System.out.println(valor + " X " + i + " = " + (valor * i));
				}
				valor ++;
				System.out.println("\t");
			}
		}
		else if (option == 2) {
			System.out.printf("\n Qual tabuada você precisa saber?\n"
					+ "\nEssa é a tabuada do =>");
			int valor = ler.nextInt();
			for(int i = 0; i <= 10; i++) {
				System.out.println(valor + " X " + i + " + " + (valor * i));
			}
			
		}
	}
	}

}
