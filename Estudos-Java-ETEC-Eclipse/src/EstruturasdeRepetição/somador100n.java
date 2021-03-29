package EstruturasdeRepetição;
import javax.swing.JOptionPane;

/**
* @author patrikrufino
* Programa para devolver um valor promocional;
*/

public class somador100n {

	public static void main(String[] args) {
		int soma = 0;
		
		JOptionPane.showMessageDialog(null, "Você sabe quanto é a soma"
				+ "dos primeiros 100 números do nosso sistema númerico?");
		
		for(int i = 1; i <= 100; i++)
			soma += i;
		JOptionPane.showMessageDialog(null, "A soma dos 100 é igual:\n"
				+ soma);

	}

}
