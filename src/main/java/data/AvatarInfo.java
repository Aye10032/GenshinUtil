package data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: genshinutil
 * @className: AvatarInfo
 * @Description: 角色信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvatarInfo {

    private long id;
    //头像URL
    private String image;
    private String name;
    //元素
    private String element;
    //好感度
    private int fetter;
    //等级
    private int level;
    //稀有度
    private int rarity;
    //命座
    private int actived_constellation_num;
    //卡片图像URL
    private String card_image;

}
