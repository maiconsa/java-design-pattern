package filter;

import java.util.HashSet;
import java.util.Set;

import filter.car.Car;
import filter.car.CarByBrandFilter;
import filter.car.CarByModelFilter;
import filter.car.CarFabricationGreaterThanFilter;
import filter.operations.AndFilter;

public class Main {

	public static void main(String[] args) {
		
		Set<Car> items = new HashSet<>();
		items.add(new Car("2010", "honda", "civic"));
		items.add(new Car("2011", "honda", "civic"));
		items.add(new Car("2011", "honda", "accord"));
		items.add(new Car("2010", "toyota", "corolla"));
		items.add(new Car("2011", "fiat", "uno"));
		
		
		Set<Car> resultNoneFilter =   Filter.builder(items).filter();
		System.out.println(resultNoneFilter);
			
		Set<Car> fabricationGreaterThan2010 = Filter
				.builder(items)
				.and(new CarFabricationGreaterThanFilter("2010"))
				.and(new CarByBrandFilter("honda"))
				.filter();
		System.out.println(fabricationGreaterThan2010);
		
		Set<Car> civicOuUnos = Filter.builder(items)
				.or(new AndFilter<>(new CarByModelFilter("civic"), new CarFabricationGreaterThanFilter("2011")))
				.or(new CarByModelFilter("uno"))
				.filter();
		System.out.println(civicOuUnos);
	}

}
