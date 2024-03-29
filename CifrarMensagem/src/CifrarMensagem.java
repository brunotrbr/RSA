import java.math.BigInteger;
import java.util.Scanner;


public class CifrarMensagem {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("Execute o programa informando 2 n�meros: euler e, e o modulo N:");
			System.out.println("Ex: 7 55");
		} else {
			
			System.out.println("Digite a mensagem que sera cifrada:");
			Scanner scanner = new Scanner(System.in);
			String mensagem = scanner.nextLine();
			
			BigInteger M = ConverterMensagemParaNumerico.ConverterDeString(mensagem);
			BigInteger e = new BigInteger(args[0]);
			BigInteger N = new BigInteger(args[1]);
			
			if(M.compareTo(N) > 0){
				System.out.println("A mensagem nao pode ser cifrada pois seu tamanho e maior que o modulo N.");
				return;
			}

			BigInteger mensagemCifrada_C = cifrarMensagem(M,e,N);
			System.out.println(mensagemCifrada_C);
		}
	}
	
	public static BigInteger Cifrar(BigInteger M, BigInteger e, BigInteger N) {
		return cifrarMensagem(M,e,N);
	}

	private static BigInteger cifrarMensagem(BigInteger M, BigInteger e, BigInteger N){
		BigInteger mensagemCifrada = M.modPow(e,N);
		return mensagemCifrada;
	}
}
