import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Trab02 {
	public static void main(String args[]) {
		String nome1 = "J://Java//Trab01//trab02.txt";
		
		try{
			System.setIn(new FileInputStream(new File(nome1)));
		} 
		catch(FileNotFoundException e) {
			System.out.println("Arquivo Não encontrado");
		}
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		int tip[],minutos[], n,i;
		String nome[], telefone[];
		double vc[], va[][];
		
		
		
		System.out.print("Digite a quantidade de Clientes: ");
		n = sc.nextInt();
		
		tip = new int[n];
		minutos = new int[n];
		nome = new String[n];
		telefone = new String[n];
		vc = new double[n];
		va = new double[3][2];
		
		System.out.println("Digite o valor das assinaturas(0, 1 ou 3):");
		for(i=0;i<3;i++){
			System.out.print("Digite o valor da assinatura" + i +" : ");
			va[i][0] = sc.nextDouble();
			System.out.print("Digite o valor dos minutos excedidos na " + i +"ª assinatura: ");
			va[i][1] = sc.nextDouble();
		}
		
		for(i=0;i<n;i++){
			System.out.print("Digite o nome do " + (i+1) +"º cliente: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.print("Digite o Telefone do cliente "+ nome[i]+": ");
			telefone[i] = sc.next();
			System.out.print("Digite o tipo de Assinatura(0, 1 ou 2) do cliente "+ nome[i]+": ");
			tip[i] = sc.nextInt();
			System.out.print("Digite quantos minutos que o cliente "+ nome[i]+" utilizou: ");
			minutos[i] = sc.nextInt();
		}
		
		
		for(i=0;i<n;i++){
			if(minutos[i]<= 90){
				vc[i] =  va[tip[i]][0];				
			}
			else{
				vc[i] = (double) va[tip[i]][0] + ((minutos[i] - 90)*va[tip[i]][1]);
			}
		}
		System.out.println("\n\tNome \t Telefone \t Tipo \t Minutos \t ValorDaConta");
		for(i=0;i<n;i++){
			System.out.print( nome[i] + "\t");
			System.out.print(telefone[i] + "\t");
			System.out.print(tip[i] + "\t");
			System.out.print(minutos[i] + "\t");
			System.out.println("\t" + vc[i]);
		}
		double rec = 0.0;
		for(i=0;i<n;i++){
			rec+= vc[i];
		}
		System.out.println("\nReceita Total: R$" + rec );
		double mnr;
		int pos;
		mnr = vc[0];
		pos = 0;
		for (i=0;i<n;i++){
			if(mnr > vc[i]){
				mnr = vc[i];
				pos = i;
			}
		}		
		System.out.println("\nMenor conta: R$" + mnr + " " + nome[pos] + " " + telefone[pos] );
		int med = 0, soma = 0, qtd = 0;
		for(i=0;i<n;i++){
			if(tip[i]==1){
			soma += minutos[i];
			qtd++;
			}
		}
		med = soma/qtd;
		System.out.println("\nMédia de minutos de clientes do plano 1: " + med + " minutos" );
		System.out.println("\nClientes que não consumiram minutos excedentes: ");
		System.out.println("\tNome \tTelefone");
		for(i=0;i<n;i++){
			if(minutos[i]<=90){
				System.out.println(  nome[i] + "\t "+telefone[i] );				
			}
		}
		qtd=0;
		for(i=0;i<n;i++){
			if(minutos[i]>=120){
			qtd++;
			}
		}
		System.out.println("\nQuantidade de clientes que consumiram mais de 120 minutos(inclusive): " + qtd);
		qtd=0;
		for(i=0;i<n;i++){
			if(tip[i]==2){
			qtd++;
			}
		}
		double perc;
		perc = (double)qtd/n*100;
		System.out.print("\nPorcentagem de clientes que em o plano 2 em relação ao total de clientes:" + perc + "%");
		sc.close();
	}

}
