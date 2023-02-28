import java.util.Scanner;

public class exec {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String senha = scan.next();
		char[] hash;
		boolean verifica = true;
		
		hash = CifradorDeSenhaBcrypt.cifrarSenha(senha);
		
		do {
			
			System.out.println("Digite a senha: ");
			senha = scan.next();
			
			
			if(CifradorDeSenhaBcrypt.verificaSenha(hash, senha)) {
				System.out.println("Senha correta");
				verifica = false;
			}else {
				System.out.println("Senha Incorreta");
				verifica = false;
			}
			
		} while (verifica);

	}

}
