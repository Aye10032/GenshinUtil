package data.character.reliquarie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: genshinutil
 * @className: ReliquariesInfo
 * @Description: 圣遗物信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReliquarieInfo {

    private long id;
    private String name;
    //圣遗物图标URL
    private String icon;
    //部位
    private int pos;
    //稀有度
    private int rarity;
    //等级
    private int level;
    //套装信息
    private SetInfo set;
    //部位名称
    private String pos_name;

}
