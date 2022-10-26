package data.character.reliquarie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: genshinutil
 * @className: AffixeInfo
 * @Description: 圣遗物套装效果
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 6:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AffixeInfo {

    //生效件数
    private int activation_number;
    //效果描述
    private String effect;

}
