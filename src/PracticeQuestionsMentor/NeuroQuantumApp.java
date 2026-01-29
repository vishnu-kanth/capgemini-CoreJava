package PracticeQuestionsMentor;

import java.time.LocalDate;
import java.util.Scanner;

interface Experiment {

	double calculateInnovationScore(int monthsActive);

	double calculateResourceConsumption(int monthsActive);

	default Experiment getHigherImpactExperiment(Experiment e1, Experiment e2) {
		ExperimentInfo ex1 = (ExperimentInfo) e1;
		ExperimentInfo ex2 = (ExperimentInfo) e2;
		return ex1.getFundingAmount() >= ex2.getFundingAmount() ? e1 : e2;
	}

	static int getMonthsActive(int initiationMonth, int initiationYear) {
		LocalDate now = LocalDate.now();
		return (now.getYear() - initiationYear) * 12 + (now.getMonthValue() - initiationMonth);
	}
}

class ExperimentInfo implements Experiment {

	private int experimentId;
	private String experimentTitle;
	private String leadResearcher;
	private double fundingAmount;
	private String complexityLevel;
	private int initiationMonth;
	private int initiationYear;

	public ExperimentInfo(int experimentId, String experimentTitle, String leadResearcher, double fundingAmount,
			String complexityLevel, int initiationMonth, int initiationYear) {
		this.experimentId = experimentId;
		this.experimentTitle = experimentTitle;
		this.leadResearcher = leadResearcher;
		this.fundingAmount = fundingAmount;
		this.complexityLevel = complexityLevel;
		this.initiationMonth = initiationMonth;
		this.initiationYear = initiationYear;
	}

	public double getFundingAmount() {
		return fundingAmount;
	}

	public String getExperimentTitle() {
		return experimentTitle;
	}

	public String getLeadResearcher() {
		return leadResearcher;
	}

	@Override
	public double calculateInnovationScore(int monthsActive) {

		double multiplier = 0;

		if (complexityLevel.equals("QubitOpt"))
			multiplier = 1.5;
		else if (complexityLevel.equals("Entanglement"))
			multiplier = 2.5;
		else if (complexityLevel.equals("Cryptography"))
			multiplier = 3.5;

		return (multiplier * monthsActive * fundingAmount) / 1000;
	}

	@Override
	public double calculateResourceConsumption(int monthsActive) {

		double rate = 0;

		if (complexityLevel.equals("QubitOpt"))
			rate = 0.8;
		else if (complexityLevel.equals("Entanglement"))
			rate = 1.2;
		else if (complexityLevel.equals("Cryptography"))
			rate = 1.8;

		double value = (monthsActive * rate * fundingAmount) / 100;
		return Math.round(value * 10.0) / 10.0;
	}
}

public class NeuroQuantumApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Experiment 1 details:");
		int id1 = Integer.parseInt(sc.nextLine().trim());
		String title1 = sc.nextLine().trim();
		String lead1 = sc.nextLine().trim();
		double fund1 = Double.parseDouble(sc.nextLine().trim());
		String level1 = sc.nextLine().trim();
		int month1 = Integer.parseInt(sc.nextLine().trim());
		int year1 = Integer.parseInt(sc.nextLine().trim());

		System.out.println("Enter Experiment 2 details:");
		int id2 = Integer.parseInt(sc.nextLine().trim());
		String title2 = sc.nextLine().trim();
		String lead2 = sc.nextLine().trim();
		double fund2 = Double.parseDouble(sc.nextLine().trim());
		String level2 = sc.nextLine().trim();
		int month2 = Integer.parseInt(sc.nextLine().trim());
		int year2 = Integer.parseInt(sc.nextLine().trim());

		ExperimentInfo e1 = new ExperimentInfo(id1, title1, lead1, fund1, level1, month1, year1);
		ExperimentInfo e2 = new ExperimentInfo(id2, title2, lead2, fund2, level2, month2, year2);

		int months1 = Experiment.getMonthsActive(month1, year1);
		int months2 = Experiment.getMonthsActive(month2, year2);

		System.out.println("\nExperiment Summary:");

		System.out.println(e1.getExperimentTitle() + " by " + e1.getLeadResearcher());
		System.out.println("Months Active: " + months1);
		System.out.println("Innovation Score: " + e1.calculateInnovationScore(months1));
		System.out.println("Resource Consumption: " + e1.calculateResourceConsumption(months1));

		System.out.println(e2.getExperimentTitle() + " by " + e2.getLeadResearcher());
		System.out.println("Months Active: " + months2);
		System.out.println("Innovation Score: " + e2.calculateInnovationScore(months2));
		System.out.println("Resource Consumption: " + e2.calculateResourceConsumption(months2));

		Experiment higher = e1.getHigherImpactExperiment(e1, e2);
		ExperimentInfo hi = (ExperimentInfo) higher;

		System.out.println("\nHigher Impact Experiment:");
		System.out.println(hi.getExperimentTitle());

		sc.close();
	}
}
