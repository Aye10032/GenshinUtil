package data.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: genshinutil
 * @className: WeaponInfo
 * @Description: 武器信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeaponInfo {

    private long id;
    private String name;
    //武器图标URL
    private String icon;
    //武器种类
    private int type;
    //武器稀有度
    private int rarity;
    //武器等级
    private int level;
    //突破次数
    private int promote_level;
    //武器种类名称
    private String type_name;
    //武器描述
    private String desc;
    //精炼等级
    private int affix_level;

}
