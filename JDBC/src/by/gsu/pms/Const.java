package by.gsu.pms;

public class Const {
    private Const() {
    }

    public static final String CREATE_POINTS_TABLE = "CREATE TABLE `points` (\n" +
            " `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            " `x` int(30) NOT NULL,\n" +
            " `y` int(30) NOT NULL,\n" +
            " PRIMARY KEY (`id`),\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8";

    public static final String SELECT_NEAREST_POINT = "SELECT (MIN(SQRT(POW(points.x - ?,2) + POW(points.y - ?,2)))) as R FROM `points`";

    public static final String SELECT_FARTHEST_POINT = "SELECT (MAX(SQRT(POW(points.x - ?,2) + POW(points.y - ?,2)))) as R FROM `points`";
}
