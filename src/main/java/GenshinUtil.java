import com.google.gson.*;
import data.AvatarInfo;
import data.PlayerInfo;
import data.character.CharacterInfo;
import okhttp3.*;
import util.DSUtil;
import util.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static util.Data.*;

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

    public GenshinUtil() {
        this.client = new OkHttpClient();
    }

    public void init(String cookie, String uuid) {
        this.Cookie = cookie;
        this.uuid = uuid;
    }

    public PlayerInfo getPlayerInfo() {
        Request request = new Request.Builder()
                .url(USER_INFO_URL + "?role_id=" + uuid + "&server=cn_gf01")
                .addHeader("User-Agent", USER_AGENT)
                .addHeader("x-rpc-client_type", "5")
                .addHeader("x-rpc-app_version", "2.11.1")
                .addHeader("DS", DSUtil.getDS(uuid))
                .addHeader("Cookie", Cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = Objects.requireNonNull(response.body()).string();
            response.close();

            JsonElement element = JsonParser.parseString(result);

            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();

                if (jsonObject.get("retcode").getAsInt() != 0) {
                    return null;
                } else {
                    JsonObject playerData = jsonObject.getAsJsonObject("data");
                    PlayerInfo playerInfo = new PlayerInfo();
                    playerInfo.setLevel(playerData.getAsJsonObject("role").get("level").getAsInt());
                    playerInfo.setNickname(playerData.getAsJsonObject("role").get("nickname").getAsString());

                    List<AvatarInfo> avatarInfos = new ArrayList<>();
                    JsonArray array = playerData.getAsJsonArray("avatars");
                    for (JsonElement avatar : array) {
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

    public List<CharacterInfo> getCharacterInfo() {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(CHARACTER_INFO_URL + "?role_id=" + uuid + "&server=cn_gf01")
                .method("POST", body)
                .addHeader("User-Agent", USER_AGENT)
                .addHeader("x-rpc-client_type", "5")
                .addHeader("x-rpc-app_version", "2.11.1")
                .addHeader("DS", DSUtil.getDS(uuid))
                .addHeader("Cookie", Cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = Objects.requireNonNull(response.body()).string();
            response.close();
            JsonElement element = JsonParser.parseString(result);

            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();

                if (jsonObject.get("retcode").getAsInt() != 0) {
                    return null;
                } else {
                    JsonArray avatars = jsonObject.getAsJsonObject("data").getAsJsonArray("avatars");
                    List<CharacterInfo> characterInfoList = new ArrayList<>();
                    for (JsonElement avatar : avatars){
                        Gson gson = new Gson();

                        CharacterInfo info = gson.fromJson(avatar, CharacterInfo.class);
                        characterInfoList.add(info);
                    }
                    return characterInfoList;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public CharacterInfo getCharacterInfoByName(String name){
        List<CharacterInfo> characters = getCharacterInfo();
        for (CharacterInfo character : characters){
            if (character.getName().equals(name)){
                return character;
            }
        }
        return null;
    }

}
