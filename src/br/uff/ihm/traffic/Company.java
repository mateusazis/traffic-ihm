package br.uff.ihm.traffic;

public class Company {
	
	public static final Company COMPANY_INGA = new Company("Ingá", "inga.jpg");
	public static final Company COMPANY_1001 = new Company("1001", "1001.jpg");
	
	public String imgName;
	public String name;
	
	public Company(){}
	public Company(String name, String imgPath){
		this.name = name;
		this.imgName = imgPath;
	}
	
	@Override
	public String toString(){
		return "Company: " + name;
	}
}
