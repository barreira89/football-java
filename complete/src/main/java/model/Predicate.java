package model;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface Predicate {

	public BooleanExpression getPredicate();
	
}
