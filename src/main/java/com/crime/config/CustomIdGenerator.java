package com.crime.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.crime.util.RandomUtils;

public class CustomIdGenerator implements IdentifierGenerator {

	private static final long serialVersionUID = 3448920945530567376L;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return RandomUtils.getGeneratedTimeStamp();
	}

	public long nanos() {
		synchronized (this) {

			return System.currentTimeMillis();
		}
	}

}
