package filter.car;

import filter.Filtable;

public class Car implements Filtable {
	private String fabricationYear;
	private String brand;
	private String model;

	public Car(String fabricationYear, String brand, String model) {
		this.fabricationYear = fabricationYear;
		this.brand = brand;
		this.model = model;
	}

	public String getFabricationYear() {
		return fabricationYear;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return String.format("{fabrication: %s , brand : %s , model: %s}", getFabricationYear(), getBrand() , getModel());

	}

}
