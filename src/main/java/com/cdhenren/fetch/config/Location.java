package com.cdhenren.fetch.config;

/**
 * 西藏地市
 *
 * @author baopz
 * @since 2.0.0
 */
public enum Location {
    lasa("891", "拉萨"),
    rikaze("892", "日喀则"),
    shannan("893", "山南"),
    linzhi("894", "林芝"),
    changdu("895", "昌都"),
    naqu("896", "那曲"),
    ali("897", "阿里");
    private String id;
    private String name;

    /**
     * 根据ID得到
     *
     * @param id
     * @return
     */
    public static String acquireNameOfId(String id) throws LocationNotFoundExcetion {
        for (Location location : Location.values()) {
            if (location.getId().equals(id)) {
                return location.getName();
            }
        }
        throw new LocationNotFoundExcetion("地区编号:" + id);
    }

    Location(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
