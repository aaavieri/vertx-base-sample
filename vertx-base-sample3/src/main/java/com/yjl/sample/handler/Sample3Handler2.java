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

@RestRouteV2Handler({@RestRouteMapping(value = "/test/3/:appId", method = HttpMethod.POST), @RestRouteMapping("/test/4")})
public class Sample3Handler2 extends BaseRouteV2Handler {
	
	@Inject
	private WxChannelMapper wxChannelMapper;
	
	@Inject
	private WxUserMapper wxUserMapper;
	
	@Override
	public Future<Void> handleSuccess(RoutingContext routingContext) {
		JsonObject params = ContextUtil.getParam(routingContext);
		Future<JsonObject> channelFuture = this.wxChannelMapper.getChannelInfo(params.getString("appId"));
		Future<JsonArray> userListFuture = this.wxUserMapper.getAppUserList(params.getString("appId"));
		return CompositeFuture.all(channelFuture, userListFuture).compose(compositeFuture -> {
			JsonObject channelInfo = compositeFuture.resultAt(0);
			JsonArray userList = compositeFuture.resultAt(1);
			routingContext.response().end(new JsonObject().put("channel", channelInfo).put("user", userList).toBuffer());
			Future<Void> future = Future.future();
			future.complete();
			return future;
		});
	}
}
