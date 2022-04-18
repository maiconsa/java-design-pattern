package filter.car;

import filter.Filter;

public class CarByBrandFilter implements Filter<Car> {
	private String brand;
	public CarByBrandFilter(String brand) {
		this.brand = brand;
	}
	
	@Override
	public boolean accept(Car item) {
		return item.getBrand().equals(this.brand);
	}

}
