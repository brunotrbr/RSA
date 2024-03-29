import java.math.BigInteger;
import java.util.Scanner;



public class GerarChaves {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Gerar chaves");
		System.out.println("Informe o n�mero de bits da chave:");
		
		Scanner entradaTexto = new Scanner(System.in);
		int bits = entradaTexto.nextInt();
		System.out.println("\n");
		System.out.println("Numero primo p:");
		BigInteger p = GerarPrimo.Gerar(bits);
		if(p.equals(BigInteger.valueOf(-1))){
        	System.out.println("N�o foi possivel encontrar um numero primo apos 10000 tentativas.");
        	System.out.println("\n");
        	return;
        } else if(p.equals(BigInteger.ZERO)){
        	System.out.println("Quantidade de bits deve ser maior que 1000.");
        	System.out.println("\n");
        	return;
        } 
		System.out.println("\t" + p);
		System.out.println("");
		System.out.println("Numero primo q:");
		BigInteger q = GerarPrimo.Gerar(bits);
		if(q.equals(BigInteger.valueOf(-1))){
        	System.out.println("N�o foi possivel encontrar um numero primo apos 10000 tentativas.");
        	System.out.println("\n");
        	return;
        	
        } else if(q.equals(BigInteger.ZERO)){
        	System.out.println("Quantidade de bits deve ser maior que 1000.");
        	System.out.println("\n");
        	return;
        }
		System.out.println("\t" + q);
		System.out.println("");
		System.out.println("Modulo N:");
		BigInteger N = MultiplicarPrimos.Multiplicar(p, q);
		System.out.println("\t" + N);
		System.out.println("");
		System.out.println("Phi(N) phi:");
		BigInteger phi = CalcularPhi.Calcular(p, q);
		System.out.println("\t" + phi);
		System.out.println("");
		System.out.println("Euler e:");
		BigInteger e = GerarEuler.Gerar(phi);
		e = GerarEuler.TestarEuler(e, phi);
		System.out.println("\t" + e);
		System.out.println("");
		System.out.println("Inverso de Euler d:");
		BigInteger d = CalcularDInversoEuler.Calcular(e,phi);
		System.out.println("\t" + d);
		
		System.out.println("\n");
		
		System.out.println("Chave Publica: \nPK\n{\n\te: "+ e +"\n\tN: "+ N +"\n}");
		System.out.println("Chave Privada: \nSK\n{\n\td: "+ d +",\n\tp: "+ p +",\n\tq: "+ q +"\n}");
		System.out.println("");
	}

}
