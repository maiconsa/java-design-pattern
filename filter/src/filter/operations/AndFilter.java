package filter.operations;

import java.util.Set;

import filter.Filtable;
import filter.Filter;

public class AndFilter<T extends Filtable> implements Filter<T> {
	private  Set<Filter<T>> filters;

	@SafeVarargs
	public AndFilter(Filter<T> ...filters) {
		this.filters = Set.of(filters);
		
	}
	
	@Override
	public boolean accept(T item) {
		return this.filters.stream().allMatch(filter -> filter.accept(item));
	}
}
