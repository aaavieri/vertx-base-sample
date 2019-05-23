package com.yjl.sample.mapper;

import com.yjl.vertx.base.autoroute.anno.AutoRouteIf;
import com.yjl.vertx.base.autoroute.anno.AutoRouteIfMethod;
import com.yjl.vertx.base.com.anno.Param;
import com.yjl.vertx.base.dao.anno.component.Dao;
import com.yjl.vertx.base.dao.anno.operation.Insert;
import com.yjl.vertx.base.dao.anno.operation.Select;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;

@Dao
@AutoRouteIf("wxUser")
public interface WxUserMapper {
    
    @Select("select wxappID, openID, clientID, channelID, unionid, phoneNum, information, sessionKey, token, tokenStartTime, insertUser, insertTime, updateUser, updateTime from t_wxuser " +
                "where wxappID = #{wxappID} and openid = #{openID}")
    Future<JsonObject> getWxUser(@Param("wxappID") String appId, @Param("openID") final String openid);
    
    @Insert("insert into t_wxuser (wxappID, openID, clientID, channelID, unionid, phoneNum, information, sessionKey, token, tokenStartTime, insertUser, insertTime, updateUser, updateTime) " +
                "values (#{wxappID}, #{openID}, #{clientID}, #{channelID}, #{unionid}, #{phoneNum}, #{information}, #{sessionKey}, #{token}, #{tokenStartTime}, -1, sysdate(), -1, sysdate()) " +
                "on duplicate key update unionid = #{unionid}, phoneNum = #{phoneNum}, token = #{token}, sessionKey = #{sessionKey}, tokenStartTime = #{tokenStartTime}, " +
                "updateUser = -1, updateTime = sysdate()")
    @AutoRouteIfMethod(value = "saveWxUser", route = HttpMethod.POST)
    Future<Integer> saveWxUser(@Param("userInfo") final JsonObject userInfo);
}
