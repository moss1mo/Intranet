package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-11-13T10:33:10.440-0600")
@StaticMetamodel(Sequence.class)
public class Sequence_ {
	public static volatile SingularAttribute<Sequence, String> seqName;
	public static volatile SingularAttribute<Sequence, BigDecimal> seqCount;
}
