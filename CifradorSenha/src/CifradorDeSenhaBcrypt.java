import at.favre.lib.crypto.bcrypt.BCrypt;

public class CifradorDeSenhaBcrypt {

	public static char[] cifrarSenha(String senha) {

		char[] bcryptChars = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToChar(6, senha.toCharArray());
       // String bcryptHashString = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        
        return bcryptChars;
		
	
    }
	
	public static boolean verificaSenha(char[] hash, String senha) {
		
		BCrypt.Result result = BCrypt.verifyer().verify(senha.toCharArray(), hash);
		
		return result.verified;
	}
}
