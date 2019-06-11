package com.yjl.sample.client;

import com.yjl.vertx.base.autoroute.anno.AutoRouteIf;
import com.yjl.vertx.base.autoroute.anno.AutoRouteIfMethod;
import com.yjl.vertx.base.com.anno.Param;
import com.yjl.vertx.base.webclient.anno.component.RequestClient;
import com.yjl.vertx.base.webclient.anno.request.Request;
import com.yjl.vertx.base.webclient.anno.request.RequestData;
import com.yjl.vertx.base.webclient.enumeration.RequestDataType;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;

@RequestClient(port = 4202, host = "localhost")
@AutoRouteIf("localWxChannel")
public interface LocalWebClient {

	@Request(path = "wxChannel/getChannelInfo", method = HttpMethod.GET)
	@RequestData(type = RequestDataType.QUERY_PARAM, key = "appId", paramKey = "a")
	@AutoRouteIfMethod("testFirst")
	Future<JsonObject> testFirst(@Param("a") String a);
	
	@Request(path = "wxChannel/getChannelInfo", method = HttpMethod.GET)
	@RequestData(type = RequestDataType.JSON_PARAM, key = "appId", paramKey = "whole", whole = true)
	@AutoRouteIfMethod(value = "testSecond", route = HttpMethod.POST)
	Future<JsonObject> testSecond(@Param("whole") JsonObject whole);
}
