import com.google.gson.*;
import data.AvatarInfo;
import data.PlayerInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.DSUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: genshinutil
 * @className: GenshinUtil
 * @Description: 主类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 4:13
 */
public class GenshinUtil {

    private String Cookie = "";
    private String uuid = "";
    private final OkHttpClient client;

    public GenshinUtil(){
        this.client = new OkHttpClient();
    }

    public void init(String cookie, String uuid){
        this.Cookie = cookie;
        this.uuid = uuid;
    }

    public PlayerInfo getPlayerInfo(){
            Request request = new Request.Builder()
                    .url("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/index?role_id=100080227&server=cn_gf01")
                    .addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.11.1")
                    .addHeader("x-rpc-client_type", "5")
                    .addHeader("x-rpc-app_version", "2.11.1")
                    .addHeader("DS", DSUtil.getDS(uuid))
                    .addHeader("Cookie", Cookie)
                    .build();
            try (Response response = client.newCall(request).execute()){
                String result = Objects.requireNonNull(response.body()).string();
                response.close();

                JsonElement element = JsonParser.parseString(result);

                if (element.isJsonObject()){
                    JsonObject jsonObject = element.getAsJsonObject();

                    if (jsonObject.get("retcode").getAsInt() != 0){
                        return null;
                    }else {
                        JsonObject playerData = jsonObject.getAsJsonObject("data");
                        PlayerInfo playerInfo = new PlayerInfo();
                        playerInfo.setLevel(playerData.getAsJsonObject("role").get("level").getAsInt());
                        playerInfo.setNickname(playerData.getAsJsonObject("role").get("nickname").getAsString());

                        List<AvatarInfo> avatarInfos = new ArrayList<>();
                        JsonArray array = playerData.getAsJsonArray("avatars");
                        for (JsonElement avatar:array){
                            Gson gson = new Gson();
                            AvatarInfo info = gson.fromJson(avatar, AvatarInfo.class);
                            avatarInfos.add(info);
                        }
                        playerInfo.setAvatars(avatarInfos);

                        return playerInfo;
                    }
                }

                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

}
