package org.dance.account;

import java.util.ArrayList;
import java.util.Collection;

import lombok.experimental.Delegate;



public class DelegationExample {
	private interface SimpleCollection {
		
	}
	
	@Delegate(excludes = SimpleCollection.class)
	private final Collection<String> collection = new ArrayList<String>();
	

}

class ExcludesDelegateExample {
	long counter = 0L;

	private interface Add {
		boolean add(String x);

		boolean addAll(Collection<? extends String> x);
	}

	@Delegate(excludes = Add.class)
	private final Collection<String> collection = new ArrayList<String>();

	public boolean add(String item) {
		counter++;
		return collection.add(item);
	}

	public boolean addAll(Collection<? extends String> col) {
		counter += col.size();
		return collection.addAll(col);
	}
}