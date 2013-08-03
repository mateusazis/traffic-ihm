package br.uff.ihm.traffic.models;

public class Line {
	public Company company;
	public String number;
	public String route;
	public Bus [] bus;
	public int nextBusTime;
	
	public Line(String number, Company c, String route, Bus [] bus){
		this.number = number;
		this.company = c;
		this.route = route;
		this.bus = bus;
		for(Bus b : bus)
			b.line = this;
		
		nextBusTime = (60 * 1) + (int)(Math.random() * 60 * 16);
	}
}
