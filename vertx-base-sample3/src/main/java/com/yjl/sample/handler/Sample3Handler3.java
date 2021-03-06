package com.yjl.sample.handler;

import com.google.inject.Inject;
import com.yjl.sample.mapper.WxChannelMapper;
import com.yjl.sample.mapper.WxUserMapper;
import com.yjl.vertx.base.web.anno.component.RestRouteMapping;
import com.yjl.vertx.base.web.anno.component.RestRouteV2Handler;
import com.yjl.vertx.base.web.handler.BaseRouteV2Handler;
import com.yjl.vertx.base.web.util.ContextUtil;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestRouteV2Handler({@RestRouteMapping(value = "/test/5/:appId", method = HttpMethod.POST), @RestRouteMapping("/test/6")})
public class Sample3Handler3 extends BaseRouteV2Handler {
	
	@Inject
	private WxChannelMapper wxChannelMapper;
	
	@Inject
	private WxUserMapper wxUserMapper;
	
	@Override
	public Future<Void> handleSuccess(RoutingContext routingContext) {
		JsonObject params = ContextUtil.getParam(routingContext);
		return this.wxChannelMapper.getChannelId(params.getString("appId")).compose(channelId -> {
			routingContext.response().end(new JsonObject().put("channel", channelId).toBuffer());
			Future<Void> future = Future.future();
			future.complete();
			return future;
		});
	}
}
