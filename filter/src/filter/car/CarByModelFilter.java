package filter.car;

import filter.Filter;

public class CarByModelFilter implements Filter<Car> {
	private String model;
	public CarByModelFilter(String model) {
		this.model = model;
	}
	
	@Override
	public boolean accept(Car item) {
		return item.getModel().equalsIgnoreCase(model);
	}

}
