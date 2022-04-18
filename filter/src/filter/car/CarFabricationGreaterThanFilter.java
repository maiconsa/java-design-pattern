package filter.car;

import filter.Filter;

public class CarFabricationGreaterThanFilter implements Filter<Car> {
	private String date;
	public CarFabricationGreaterThanFilter(String date) {
		this.date = date;
	}
	
	@Override
	public boolean accept(Car item) {
		return  Integer.parseInt(item.getFabricationYear()) > Integer.parseInt(this.date) ;
	}

}
