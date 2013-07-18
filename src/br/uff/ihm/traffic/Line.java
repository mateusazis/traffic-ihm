package br.uff.ihm.traffic;

public class Line {
	public Company company;
	public String number;
	public String route;
	
	public Line(String number, Company c, String route){
		this.number = number;
		this.company = c;
		this.route = route;
	}
}
