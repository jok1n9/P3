package aula7.ex1;

public class AverageCompanyDelay implements Comparable<AverageCompanyDelay>{
	
	private Company company;
	private Hour average;
	
	public AverageCompanyDelay(Company c, Hour delay) {
		this.company = c;
		this.average = delay;
	}
	
	public Hour getAverageDelay() {
		return this.average;
	}
	
	public Company getCompany() {
		return this.company;
	}

	@Override
	public int compareTo(AverageCompanyDelay a) {
		return this.average.getTotalMinutes()-a.getAverageDelay().getTotalMinutes();		
	}
	
	@Override
	public String toString() {		
		String format = "%-21.21s%s";
		return String.format(format,this.company.toString(),
				this.average.getTotalMinutes());			
	}

}
