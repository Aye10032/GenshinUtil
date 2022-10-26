import data.PlayerInfo;

/**
 * @program: genshinutil
 * @className: Test
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/10/26 下午 4:42
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        GenshinUtil util = new GenshinUtil();
        util.init("UM_distinctid=18413047e04226-0a596a65742563-26021f51-1fa400-18413047e05429; _ga=GA1.2.303908809.1666766374;" +
                " _gid=GA1.2.1183046962.1666766374; smidV2=20221026143934b5495043ec17f41f79b32ce661877b9f00e8da5340d33bb50; " +
                "CNZZDATA1275023096=53068858-1666763620-%7C1666763620; _MHYUUID=5e001331-f613-4303-897a-a9217ed14223; " +
                "ltoken=2Fkr68gDZ1qejhcIJmmPQGHf632JBi57cDyXybrh; ltuid=75726813; cookie_token=Y34l8tYapvsrd7iQC3VZLcdXxYDCByk6YcST09uI; " +
                "account_id=75726813; .thumbcache_a5f2da7236017eb7e922ea0d742741d5=F9scTenZ5lffuQlwDoAxe/xpWoGQYW/DsOHhY42G3jVs0Cn9IcW6b2jL3yoTIzZjZ1zDO6o4+53r2RuEnlbWTQ%3D%3D",
                "100080227");
        System.out.println(util.getPlayerInfo().getAvatarByName("珊瑚宫心海").toString());
    }

}
