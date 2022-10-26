package data.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: genshinutil
 * @className: ConstellationsInfo
 * @Description: 角色技能信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConstellationInfo {

    private long id;
    private String name;
    //图标URL
    private String icon;
    //技能效果
    private String effect;
    //是否解锁
    private boolean is_actived;
    //技能类型
    private String pos;

}
