package com.yjl.sample.handler;

import com.yjl.vertx.base.com.util.AppUtil;
import com.yjl.vertx.base.web.anno.component.RestRouteMapping;
import com.yjl.vertx.base.web.anno.component.RestRouteV2Handler;
import com.yjl.vertx.base.web.handler.BaseRouteV2Handler;
import com.yjl.vertx.base.web.util.ContextUtil;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

@RestRouteV2Handler({@RestRouteMapping(value = "/test/1/:appId", method = HttpMethod.POST), @RestRouteMapping("/test/2")})
public class SampleHandler1 extends BaseRouteV2Handler {
	@Override
	public Future<Void> handleSuccess(RoutingContext routingContext) {
		routingContext.response().end(ContextUtil.getAllParams(routingContext).mergeIn(AppUtil.getLocalAddress()).toBuffer());
		return Future.succeededFuture();
	}
}
