package application02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites02.Departament;
import entites02.HourContract;
import entites02.Worker;
import entites02.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner edd = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Insira o nome do departamento: ");
		String departamentName = edd.nextLine();
		System.out.println("Insira os dados do trabalhador");
		System.out.print("NOME: ");
		String workerName = edd.nextLine();
		System.out.print("Nível: ");
		String workerLevel = edd.nextLine();
		System.out.println("Salário base: R$");
		double baseSalary = edd.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Departament(departamentName));

		System.out.print("Quantos contratos para este trabalhador? ");
		int n = edd.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do contrato nº"+i);
			System.out.print("Data (DD/MM/AAAA):");
			Date contractDate = sdf.parse(edd.next());
			System.out.print("Valor por hora: ");
			double valeuPerHour = edd.nextDouble();
			System.out.print("Duração (horas): ");
			int duration = edd.nextInt();
			
			HourContract hourContract = new HourContract(contractDate, valeuPerHour, duration);
			worker.addContract(hourContract);
			
			
		}
		
		System.out.println();
		System.out.print("Digite o mês e o ano para calcular a renda (MM/AAAA): ");
		String mouthAndYear = edd.next();
		
		int mouth = Integer.parseInt(mouthAndYear.substring(0,2));
		int year = Integer.parseInt(mouthAndYear.substring(3));
		System.out.print("Nome:" + worker.getName());
		System.out.println("Departamento:" + worker.getDepartament().getNome());
		System.out.println("Renda para "+mouthAndYear+":"+ String.format("%.2f", worker.income(year, mouth)));

			edd.close();
	}

}
