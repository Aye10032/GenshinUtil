package data.character.reliquarie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: genshinutil
 * @className: SetInfo
 * @Description: 圣遗物套装信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 6:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SetInfo {

    private long id;
    private String name;
    //套装效果
    private List<AffixeInfo> affixes;

}
