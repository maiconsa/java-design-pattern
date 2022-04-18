package filter;

import java.util.Objects;
import java.util.Set;

import filter.operations.AndFilter;
import filter.operations.OrFilter;

public class FilterBuilder<T extends Filtable> {
	private Set<T> items;
	private Filter<T> filter;

	public FilterBuilder(Set<T> items) {
		this.items  = items;
	}
	
	@SafeVarargs
	public FilterBuilder(T... items) {
		this.items  = Set.of(items);
	}

	public FilterBuilder<T> and(Filter<T> filter) {
		this.filter = Objects.nonNull(this.filter) ?  new AndFilter<>(this.filter, filter) : filter;
		return this;
	}

	public FilterBuilder<T> or(Filter<T> filter) {
		this.filter = Objects.nonNull(this.filter) ?  new OrFilter<>(this.filter, filter) : filter;
		return this;
	}

	public  Set<T> filter() {
		if(this.filter == null) {
			this.filter = new All<>();
		}
		return this.filter.filter(this.items);
	}

	private static class All<T extends Filtable> implements Filter<T> {
		@Override
		public boolean accept(T item) {
			return true;
		}
	}

}
