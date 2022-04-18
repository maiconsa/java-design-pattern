package filter.operations;

import java.util.Set;

import filter.Filtable;
import filter.Filter;

public class OrFilter<T extends Filtable> implements Filter<T> {
	private  Set<Filter<T>> filters;
	@SafeVarargs
	public OrFilter(Filter<T> ...filters) {
		this.filters = Set.of(filters);
	}
	
	@Override
	public boolean accept(T item) {
		return this.filters.stream().anyMatch(filter -> filter.accept(item));
	}
}
