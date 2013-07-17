package br.uff.ihm.traffic;

public class Line {
	public Company company;
	public String number;
	
	public Line(String number){
		this.number = number;
		this.company = new Company();
	}
}
