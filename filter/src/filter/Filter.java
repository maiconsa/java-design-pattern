package filter;

import java.util.Set;
import java.util.stream.Collectors;

public interface Filter<T extends Filtable> {
   default Set<T> filter(Set<T> list){
	   return list.stream().filter(item -> this.accept(item)).collect(Collectors.toSet());
   };
    
    boolean accept(T item);
    
    @SafeVarargs
	static <T extends Filtable>  FilterBuilder<T> builder(T ...items){
    	return new FilterBuilder<T>(items); 
    }
    static <T extends Filtable>  FilterBuilder<T> builder(Set<T> items){
    	return new FilterBuilder<T>(items); 
    }

}
