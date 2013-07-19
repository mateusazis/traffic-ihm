package br.uff.ihm.traffic;

public class Line {
	public Company company;
	public String number;
	public String route;
	public float lotationPcgt, averageSpeed;
	
	public Line(String number, Company c, String route, float lotationPctg, float averageSpeed){
		this.number = number;
		this.company = c;
		this.route = route;
		this.lotationPcgt = lotationPctg;
		this.averageSpeed = averageSpeed;
	}
}
