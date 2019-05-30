package com.yjl.sample.handler;

import com.google.inject.Inject;
import com.yjl.sample.mapper.WxChannelMapper;
import com.yjl.vertx.base.web.anno.component.RestRouteMapping;
import com.yjl.vertx.base.web.anno.component.RestRouteV2Handler;
import com.yjl.vertx.base.web.handler.BaseRouteV2Handler;
import com.yjl.vertx.base.web.util.ContextUtil;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

@RestRouteV2Handler({@RestRouteMapping(value = "/test/1/:appId", method = HttpMethod.POST), @RestRouteMapping("/test/2")})
public class Sample3Handler extends BaseRouteV2Handler {
	
	@Inject
	private WxChannelMapper wxChannelMapper;
	
	@Override
	public Future<Void> handleSuccess(RoutingContext routingContext) {
		JsonObject params = ContextUtil.getParam(routingContext);
		return this.wxChannelMapper.getChannelInfo(params.getString("appId")).compose(jsonObject -> {
			routingContext.response().end(jsonObject.put("path", routingContext.request().path()).toBuffer());
			Future<Void> future = Future.future();
			future.complete();
			return future;
		});
	}
}
