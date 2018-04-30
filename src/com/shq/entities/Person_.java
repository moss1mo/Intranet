package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-10T04:10:17.395-0600")
@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Integer> personId;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, String> userName;
	public static volatile SingularAttribute<Person, BigDecimal> userId;
}
