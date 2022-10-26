package data;

import lombok.*;

import java.util.List;

/**
 * @program: genshinutil
 * @className: PlayerInfo
 * @Description: 玩家数据实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 4:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerInfo {

    private String nickname;
    private int level;
    private List<AvatarInfo> avatars;

    public AvatarInfo getAvatarByName(String name){
        for (AvatarInfo info : getAvatars()){
            if (info.getName().equals(name)){
                return info;
            }
        }
        return null;
    }

}
