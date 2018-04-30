package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-10T04:41:47.499-0600")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, BigDecimal> userId;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, String> userPass;
}
