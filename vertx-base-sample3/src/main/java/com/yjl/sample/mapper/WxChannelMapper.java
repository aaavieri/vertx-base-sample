package com.yjl.sample.mapper;

import com.yjl.vertx.base.com.anno.Param;
import com.yjl.vertx.base.dao.anno.component.Dao;
import com.yjl.vertx.base.dao.anno.operation.Select;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

@Dao
public interface WxChannelMapper {
    
    @Select("select wxappID, channelID, wxsecret, barCodeURL, information from t_wxchannel where wxappID = #{appId}")
    Future<JsonObject> getChannelInfo(@Param("appId") String appId);
    
    @Select("select channelID from t_wxchannel where wxappID = #{appId}")
    Future<String> getChannelId(@Param("appId") String appId);
}
