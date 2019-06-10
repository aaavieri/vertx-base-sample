package com.yjl.sample.adaptor;

import com.yjl.vertx.base.dao.adaptor.AbstractDaoAdaptor;
import com.yjl.vertx.base.dao.enumeration.SqlOperation;
import io.vertx.ext.sql.ResultSet;

public class SelectStringAdaptor extends AbstractDaoAdaptor<ResultSet, String> {
	@Override
	public SqlOperation matchOperation() {
		return SqlOperation.SELECT;
	}
	
	@Override
	public String adapt(ResultSet resultSet) {
		return resultSet.getRows().isEmpty() ? "" : resultSet.getRows().get(0).getInteger("channelID").toString();
	}
}
