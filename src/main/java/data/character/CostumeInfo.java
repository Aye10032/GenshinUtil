package data.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: genshinutil
 * @className: CostumeInfo
 * @Description: 皮肤信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CostumeInfo {

    private long id;
    private String name;
    //图标url
    private String icon;

}
