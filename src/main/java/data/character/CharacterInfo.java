package data.character;

import data.character.reliquarie.ReliquarieInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: genshinutil
 * @className: CharacterInfo
 * @Description: 角色详细信息
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 5:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterInfo {

    private long id;
    //角色大图url
    private String image;
    //角色头像url
    private String icon;
    private String name;
    //元素
    private String element;
    //好感度
    private int fetter;
    //等级
    private int level;
    //稀有度
    private int rarity;
    //武器信息
    private WeaponInfo weapon;
    //圣遗物信息
    private List<ReliquarieInfo> reliquaries;
    //技能信息
    private List<ConstellationInfo> constellations;
    //命座
    private int actived_constellation_num;
    //皮肤信息
    private List<CostumeInfo> costumes;
    //这个不知道他是啥，全是NULL，暂且先string
    private String external;

}
