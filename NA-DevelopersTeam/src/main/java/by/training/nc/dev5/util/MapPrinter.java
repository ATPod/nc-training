package by.training.nc.dev5.util;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nikita on 22.03.2017.
 */
public class MapPrinter<K, V> {
    private Map<K, V> map;

    public MapPrinter(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<K, V>> entries = map.entrySet();

        sb.append('{');
        for (Map.Entry<K, V> entry : entries) {
            sb.append(entry.getKey());
            sb.append("='");
            sb.append(entry.getValue());
            sb.append("',");
        }
        sb.replace(sb.length() - 1, sb.length(), "}");

        return sb.toString();
    }
}
